package com.neobis.deliveryclient.domain.interactor.usecase.login

import com.neobis.deliveryclient.domain.interactor.result.Result
import com.neobis.deliveryclient.domain.interactor.model.JWTTokenModel
import com.neobis.deliveryclient.domain.interactor.model.UserModel
import com.neobis.deliveryclient.domain.interactor.repository.LoginRepository
import com.neobis.deliveryclient.domain.interactor.usecase.base.UseCase

class LoginUseCase(
    private val repository: LoginRepository
) : UseCase<JWTTokenModel, UserModel>() {

    override suspend fun doOnBackground(params: UserModel?): Result<JWTTokenModel> {
        return repository.loginUser(params)
    }
}