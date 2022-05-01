package com.neobis.deliveryemployee.data.rest.api

import com.neobis.deliveryclient.domain.interactor.result.Result
import com.neobis.deliveryemployee.domain.interactor.model.OrderModel
import retrofit2.http.GET

interface OrdersApi {

    @GET(GET_NEW_ORDERS)
    fun getNewOrders(): Result<List<OrderModel>>

    companion object {
        private const val GET_NEW_ORDERS = "orders/order/"
    }
}