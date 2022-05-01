package com.neobis.deliveryemployee.app.fragments.florist

import android.content.Context
import android.graphics.Bitmap
import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.neobis.deliveryclient.app.model.toast.ToastDuration
import com.neobis.deliveryemployee.app.base.BaseViewModel
import com.neobis.deliveryemployee.domain.interactor.model.PlantModel
import com.neobis.deliveryemployee.domain.interactor.usecase.florist.CreatePlantUseCase
import com.neobis.deliveryemployee.domain.interactor.usecase.florist.GetListOfPlants
import com.neobis.deliveryemployee.domain.models.PlantItemModel
import id.zelory.compressor.Compressor
import id.zelory.compressor.constraint.format
import id.zelory.compressor.constraint.quality
import id.zelory.compressor.constraint.size
import kotlinx.coroutines.launch
import java.io.File


class PlantViewModel(
    private val createPlantUseCase: CreatePlantUseCase,
    private val getListOfPlants: GetListOfPlants
) : BaseViewModel() {

    private var _plantsList = MutableLiveData<List<PlantModel>>()
    val plants: LiveData<List<PlantModel>> = _plantsList

    fun getListOfPlants() {
        getListOfPlants.execute(viewModelScope) { result ->
            showLoading()
            result.perform(
                {
                    hideLoading()
                    _plantsList.value = it
                },
                {
                    Log.d("plant", it.message.toString())
                }
            )
        }
    }

    fun createPlant(
        file: File,
        context: Context,
        bitmap: Bitmap,
        name: String,
        category: Int,
        quantity: Int,
        price: Int,
        description: String,
    ) {
        viewModelScope.launch {
            val compressedImageFile = Compressor.compress(context, file) {
                quality(30)
                format(Bitmap.CompressFormat.PNG)
            }
            val plant =
                PlantItemModel(compressedImageFile, bitmap, name, 1, quantity, price, description)
            createPlantUseCase.execute(viewModelScope, plant) { result ->
                result.perform(
                    {
                        Log.d("plant", "успешно")

                        showToast("Растение успешно добавлено!", ToastDuration.SHORT)
                    }, {
                        Log.d("plant", it.message.toString() + it.localizedMessage)
                        showToast("Ошибка, повторите попытку!", ToastDuration.SHORT)
                    }
                )
            }
        }
    }

}