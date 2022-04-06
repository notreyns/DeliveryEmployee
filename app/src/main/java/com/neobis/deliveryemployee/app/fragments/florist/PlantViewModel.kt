package com.neobis.deliveryemployee.app.fragments.florist

import android.net.Uri
import androidx.lifecycle.viewModelScope
import com.neobis.deliveryclient.app.model.toast.ToastDuration
import com.neobis.deliveryemployee.app.base.BaseViewModel
import com.neobis.deliveryemployee.domain.interactor.usecase.florist.CreatePlantUseCase
import com.neobis.deliveryemployee.domain.models.PlantItemModel

class PlantViewModel(
    private val createPlantUseCase: CreatePlantUseCase,
) : BaseViewModel() {


    fun createPlant(
        image: Uri,
        name: String,
        category: Int,
        quantity: Int,
        price: Int,
        description: String,
    ) {
        val plant = PlantItemModel(image, name, 1, quantity, price, description)
        createPlantUseCase.execute(viewModelScope, plant) { result ->
            result.perform(
                {
                    showToast("Растение успешно добавлено!", ToastDuration.SHORT)
                }, {
                    showToast("Ошибка, повторите попытку!", ToastDuration.SHORT)
                }
            )
        }
    }
}