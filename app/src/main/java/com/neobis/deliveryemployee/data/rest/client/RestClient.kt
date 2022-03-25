package com.neobis.deliveryclient.data.rest.client

import com.neobis.deliveryclient.data.rest.api.UserApi

interface RestClient {
    fun userApiService(): UserApi
}