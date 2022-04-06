package com.neobis.deliveryclient.data.repository


import com.neobis.deliveryclient.data.entity.mapper.mappers.JWTTokenMapper
import com.neobis.deliveryclient.domain.interactor.result.Result
import com.neobis.deliveryclient.data.rest.client.RestClient
import com.neobis.deliveryclient.domain.interactor.model.JWTTokenModel
import com.neobis.deliveryclient.domain.interactor.model.UserModel
import com.neobis.deliveryclient.domain.interactor.repository.LoginRepository

class UserRepositoryImpl(
    private val restClient: RestClient,
    private val mapper: JWTTokenMapper
) : LoginRepository {

    override fun loginUser(userModel: UserModel?): Result<JWTTokenModel> {
        return restClient.userApiService().loginUser(userModel!!.phone, userModel.password).map {
            mapper.transform(it)
        }
    }

    override fun refreshToken(refresh: String?): Result<String> {
        return restClient.userApiService().refreshToken(refresh!!)
    }
}