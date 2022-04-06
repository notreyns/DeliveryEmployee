package com.neobis.deliveryclient.data.rest.api

import com.neobis.deliveryclient.data.entity.JWTTokenEntity
import com.neobis.deliveryclient.domain.interactor.result.Result
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.POST


interface UserApi {

    @FormUrlEncoded
    @POST(LOGIN_ENDPOINT)
    fun loginUser(
        @Field("phone_number") phone: String,
        @Field("password") password: String
    ): Result<JWTTokenEntity>

    @FormUrlEncoded
    @POST(REFRESH_TOKEN_ENDPOINT)
    fun refreshToken(
        @Field("refresh") refresh: String,
    ): Result<String>

    companion object {
        private const val LOGIN_ENDPOINT = "employee-login"
        private const val REFRESH_TOKEN_ENDPOINT = "token/refresh/"
    }

}