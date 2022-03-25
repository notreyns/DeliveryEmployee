package com.neobis.deliveryclient.data.entity


data class JWTTokenEntity(
    var role: String,
    var access: String,
    var refresh: String
)