package com.neobis.deliveryclient.domain.interactor.model

data class JWTTokenModel(
    val role: String,
    var access: String,
    var refresh: String
)