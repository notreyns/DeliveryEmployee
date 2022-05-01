package com.neobis.deliveryemployee.domain.interactor.usecase.florist

import com.neobis.deliveryclient.domain.interactor.result.Result
import com.neobis.deliveryclient.domain.interactor.usecase.base.UseCase
import com.neobis.deliveryemployee.domain.interactor.model.PlantModel
import com.neobis.deliveryemployee.domain.interactor.repository.PlantsRepository

class GetListOfPlants(
    private val repository: PlantsRepository
) : UseCase<List<PlantModel>, Void>() {

    override suspend fun doOnBackground(params: Void?): Result<List<PlantModel>> {
        return repository.getList()
    }
}