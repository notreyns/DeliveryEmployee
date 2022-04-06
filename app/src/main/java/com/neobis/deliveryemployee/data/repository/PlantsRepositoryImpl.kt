package com.neobis.deliveryemployee.data.repository

import com.neobis.deliveryclient.data.rest.client.RestClient
import com.neobis.deliveryclient.domain.interactor.result.Result
import com.neobis.deliveryemployee.domain.interactor.repository.PlantsRepository
import com.neobis.deliveryemployee.domain.models.PlantItemModel
import okhttp3.MediaType
import okhttp3.MediaType.Companion.toMediaTypeOrNull
import okhttp3.MultipartBody
import okhttp3.RequestBody
import java.io.File

class PlantsRepositoryImpl(private val restClient: RestClient) : PlantsRepository {

    override fun createPlant(plantItem: PlantItemModel?): Result<Void> {
        var profilePic: MultipartBody.Part? = null
        val file = File(plantItem!!.uri.path!!)
        val requestFile: RequestBody =
            RequestBody.create("multipart/form-data".toMediaTypeOrNull(), file)
        profilePic = MultipartBody.Part.createFormData("picture", file.name, requestFile)
        return restClient.plantApiService().createPlant(
            category = plantItem!!.category,
            name = plantItem.name,
            description = plantItem.description,
            price = plantItem.price,
            quantity = plantItem.quantity,
            image = profilePic
        )
    }

}