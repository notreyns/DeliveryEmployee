package com.neobis.deliveryclient.domain.interactor.repository

import com.neobis.deliveryclient.domain.interactor.result.Result
import com.neobis.deliveryclient.domain.interactor.model.JWTTokenModel
import com.neobis.deliveryclient.domain.interactor.model.UserModel

interface LoginRepository {
    fun loginUser(userModel: UserModel?) : Result<JWTTokenModel>
}