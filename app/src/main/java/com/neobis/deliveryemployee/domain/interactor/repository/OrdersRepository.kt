package com.neobis.deliveryemployee.domain.interactor.repository

import com.neobis.deliveryclient.domain.interactor.result.Result
import com.neobis.deliveryemployee.domain.interactor.model.OrderModel
import com.neobis.deliveryemployee.domain.interactor.model.PlantModel
import com.neobis.deliveryemployee.domain.models.PlantItemModel

interface OrdersRepository {
    fun getList(): Result<List<OrderModel>>
}