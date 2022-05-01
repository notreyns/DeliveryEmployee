package com.neobis.deliveryemployee.domain.interactor.usecase.courier

import com.neobis.deliveryclient.domain.interactor.result.Result
import com.neobis.deliveryclient.domain.interactor.usecase.base.UseCase
import com.neobis.deliveryemployee.domain.interactor.model.OrderModel
import com.neobis.deliveryemployee.domain.interactor.model.PlantModel
import com.neobis.deliveryemployee.domain.interactor.repository.OrdersRepository
import com.neobis.deliveryemployee.domain.interactor.repository.PlantsRepository

class GetNewOrders(
    private val repository: OrdersRepository
) : UseCase<List<OrderModel>, Void>() {

    override suspend fun doOnBackground(params: Void?): Result<List<OrderModel>> {
        return repository.getList()
    }
}