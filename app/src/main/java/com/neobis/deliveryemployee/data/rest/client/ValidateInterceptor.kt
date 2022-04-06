package com.neobis.deliveryemployee.data.rest.client


import android.util.Log
import com.example.evergreenclient.data.localDatabase.LocalDatabase
import com.neobis.deliveryclient.data.Constants
import com.neobis.deliveryclient.data.rest.api.UserApi
import kotlinx.coroutines.runBlocking
import okhttp3.*
import org.koin.java.KoinJavaComponent.inject
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.io.IOException

class ValidateInterceptor : Interceptor {

    private val localDatabase : LocalDatabase by inject(LocalDatabase::class.java)

    companion object {
        const val UNAUTHORIZED_CODE = 401
    }

    private lateinit var originalRequest: Request
    private lateinit var authenticationRequest: Request

    @Throws(IOException::class)
    override fun intercept(chain: Interceptor.Chain): Response {
        synchronized(this) {
            originalRequest = chain.request()
            authenticationRequest = chain.request()
            if (localDatabase.fetchAccessToken() != null) {
                authenticationRequest = originalRequest.newBuilder()
                    .addHeader(
                        "Authorization",
                        "Bearer " + localDatabase.fetchAccessToken()!!
                    )
                    .build()
            }

            var initialResponse = chain.proceed(authenticationRequest)

            if (initialResponse.code == UNAUTHORIZED_CODE) {
                val responseNewTokenLoginModel = runBlocking {
                    localDatabase.fetchRefreshToken()?.let {
                        retrofitAuth().create(UserApi::class.java).refreshToken(
                            it
                        ).perform(
                            {
                                localDatabase.saveAccessToken(it)
                                val newAuthenticationRequest =
                                    originalRequest.newBuilder().addHeader(
                                        "Authorization",
                                        "Bearer $it"
                                    ).build()
                                initialResponse = chain.proceed(newAuthenticationRequest)
                            }, {
                                Log.d("ValidateInterceptor", it.message.toString())
                            }
                        )
                    }
                }
            }
            return initialResponse

        }
    }

    private fun retrofitAuth(): Retrofit {
        return Retrofit.Builder()
            .baseUrl(Constants.BASE_URL)
            .client(createRefreshAuth())
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    private fun createRefreshAuth(): OkHttpClient {
        val okHttpClientBuilder: OkHttpClient.Builder = OkHttpClient.Builder()
        val dispatcher = Dispatcher()
        dispatcher.maxRequests = 1
        okHttpClientBuilder.dispatcher(dispatcher)
        return okHttpClientBuilder.build()
    }
}
