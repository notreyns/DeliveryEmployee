package com.neobis.deliveryclient.data.rest.client

import com.neobis.deliveryclient.data.rest.api.UserApi
import com.neobis.deliveryemployee.data.rest.api.OrdersApi
import com.neobis.deliveryemployee.data.rest.api.PlantsApi

interface RestClient {
    fun userApiService(): UserApi
    fun plantApiService(): PlantsApi
    fun ordersApiService(): OrdersApi
}