package com.neobis.deliveryemployee.data.repository

import android.graphics.Bitmap
import android.util.Base64
import android.util.Log
import com.neobis.deliveryclient.data.rest.client.RestClient
import com.neobis.deliveryclient.domain.interactor.result.Result
import com.neobis.deliveryemployee.domain.interactor.repository.PlantsRepository
import com.neobis.deliveryemployee.domain.models.PlantItemModel
import java.io.ByteArrayOutputStream


class PlantsRepositoryImpl(private val restClient: RestClient) :
    PlantsRepository {

    override fun createPlant(plantItem: PlantItemModel?): Result<Void> {
        val bos = ByteArrayOutputStream()
        plantItem!!.bitmap.compress(Bitmap.CompressFormat.PNG, 100 /*ignored for PNG*/, bos);
        val byteArray = bos.toByteArray();

        val stringBase64 = "data:image/png;base64,"+ Base64.encodeToString(byteArray, Base64.DEFAULT)
        Log.d("base64", stringBase64)
        return restClient.plantApiService().createPlant(
            category = 1,
            name = "testname",
            price = 3400,
            quantity = 24,
            image = stringBase64,
            sun = "test",
            temp = "test",
            water = "test",
            isEasy = 1
        )
    }

}
/*val requestBody: RequestBody = RequestBody.create(
           context.contentResolver.getType(plantItem!!.base64.toUri())
               ?.let { it.toMediaTypeOrNull() },
           plantItem.base64
       )
       val body: MultipartBody.Part = MultipartBody.Part.Companion.createFormData(
           "picture",
           plantItem.base64.getName(),
           requestBody
       )


       val name: RequestBody =RequestBody.create(
           "text/plain".toMediaTypeOrNull(), "dfgdfg"
       )
       val quantity: RequestBody =RequestBody.create(
           "text/plain".toMediaTypeOrNull(), "1"
       )
       val watering: RequestBody =RequestBody.create(
           "text/plain".toMediaTypeOrNull(), "t"
       )
       val temp: RequestBody =RequestBody.create(
           "text/plain".toMediaTypeOrNull(), "t"
       )
       val sun: RequestBody =RequestBody.create(
           "text/plain".toMediaTypeOrNull(), "e5"
       )
       val price: RequestBody =RequestBody.create(
           "text/plain".toMediaTypeOrNull(), "5"
       )

       val category: MultipartBody.Part =MultipartBody.Part.Companion.createFormData(
           "category", "1"
       )*/