package com.neobis.deliveryemployee.domain.interactor.repository

import com.neobis.deliveryclient.domain.interactor.result.Result
import com.neobis.deliveryemployee.domain.models.PlantItemModel

interface PlantsRepository {
    fun createPlant(plantItem: PlantItemModel?) : Result<PlantItemModel>
}