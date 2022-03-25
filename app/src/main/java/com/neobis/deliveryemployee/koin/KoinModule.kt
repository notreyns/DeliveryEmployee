package com.neobis.deliveryemployee.koin

import android.content.Context
import com.example.evergreenclient.data.localDatabase.LocalDatabase
import com.neobis.deliveryclient.data.entity.mapper.mappers.JWTTokenMapper
import com.neobis.deliveryclient.data.repository.UserRepositoryImpl
import com.neobis.deliveryclient.data.rest.client.RestClient
import com.neobis.deliveryclient.data.rest.client.RestClientImpl
import com.neobis.deliveryclient.domain.interactor.repository.LoginRepository
import com.neobis.deliveryclient.domain.interactor.usecase.login.LoginUseCase
import com.neobis.deliveryemployee.app.fragments.login.LoginViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module


val retrofitModule = module {
    single { provideRestClient() }
}

val preferencesModule = module {
    single {  }
}

val repositoryModule = module {
    single { tokenDataMapper() }

    single {
        provideUserRepository(
            restClient = get(),
            mapper = tokenDataMapper()
        )
    }

}

val viewModels = module {

    factory { provideLoginUseCase(repository = get()) }
    viewModel { LoginViewModel(loginUseCase = get() ) }
}

fun provideLoginUseCase(repository: LoginRepository) = LoginUseCase(repository)
fun provideSharedPreferences(context: Context) = LocalDatabase(context)

fun provideUserRepository(
    restClient: RestClient,
    mapper: JWTTokenMapper
): LoginRepository{
    return UserRepositoryImpl(restClient, mapper)
}

fun provideRestClient(): RestClient {
    return RestClientImpl()
}




fun tokenDataMapper() = JWTTokenMapper()
