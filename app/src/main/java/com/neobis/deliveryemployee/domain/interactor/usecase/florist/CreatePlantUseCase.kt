package com.neobis.deliveryemployee.domain.interactor.usecase.florist

import com.neobis.deliveryclient.domain.interactor.result.Result
import com.neobis.deliveryclient.domain.interactor.usecase.base.UseCase
import com.neobis.deliveryemployee.domain.interactor.repository.PlantsRepository
import com.neobis.deliveryemployee.domain.models.PlantItemModel

class CreatePlantUseCase(
    private val repository: PlantsRepository
) : UseCase<Void, PlantItemModel>() {
    override suspend fun doOnBackground(params: PlantItemModel?): Result<Void> {
        return repository.createPlant(params)
    }
}