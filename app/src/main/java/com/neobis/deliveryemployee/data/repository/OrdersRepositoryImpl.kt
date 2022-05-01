package com.neobis.deliveryemployee.data.repository

import com.neobis.deliveryclient.data.rest.client.RestClient
import com.neobis.deliveryclient.domain.interactor.result.Result
import com.neobis.deliveryemployee.data.entity.mapper.mappers.PlantMapper
import com.neobis.deliveryemployee.domain.interactor.model.OrderModel
import com.neobis.deliveryemployee.domain.interactor.repository.OrdersRepository

class OrdersRepositoryImpl(
    private val restClient: RestClient,
    private val mapper: PlantMapper
) : OrdersRepository {
    override fun getList(): Result<List<OrderModel>> {
        return restClient.ordersApiService().getNewOrders()
    }
}
