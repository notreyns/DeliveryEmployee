package com.neobis.deliveryemployee.domain.interactor.usecase.login

import com.neobis.deliveryclient.domain.interactor.model.JWTTokenModel
import com.neobis.deliveryclient.domain.interactor.repository.LoginRepository
import com.neobis.deliveryclient.domain.interactor.result.Result
import com.neobis.deliveryclient.domain.interactor.usecase.base.UseCase

class RefreshTokenUseCase(
    private val repository: LoginRepository
    ): UseCase<String, String>() {
    override suspend fun doOnBackground(params: String?): Result<String> {
        return repository.refreshToken(params)
    }

}