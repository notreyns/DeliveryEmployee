package com.neobis.deliveryemployee.data.repository

import android.graphics.Bitmap
import android.util.Base64
import android.util.Log
import com.neobis.deliveryclient.data.rest.client.RestClient
import com.neobis.deliveryclient.domain.interactor.result.Result
import com.neobis.deliveryemployee.domain.interactor.repository.PlantsRepository
import com.neobis.deliveryemployee.domain.models.PlantItemModel
import okhttp3.MultipartBody
import okhttp3.RequestBody
import java.io.ByteArrayOutputStream


class PlantsRepositoryImpl(private val restClient: RestClient) :
    PlantsRepository {

    override fun createPlant(plantItem: PlantItemModel?): Result<PlantItemModel> {
        val bos = ByteArrayOutputStream()
        plantItem!!.bitmap.compress(Bitmap.CompressFormat.PNG, 100 /*ignored for PNG*/, bos);
        val byteArray = bos.toByteArray();

        val stringBase64 = Base64.encodeToString(byteArray, Base64.DEFAULT)
        Log.d("base64", stringBase64)
        val requestBody: RequestBody = MultipartBody.Builder()
            .setType(MultipartBody.FORM)
       /* @Field("category") category: Int,
        @Field("picture") image: String,
        @Field("price") price :Int,
        @Field("name") name: String,
        @Field("watering") water: String,
        @Field("temperature") temp: String,
        @Field("sun") sun: String,
        @Field("quantity") quantity: Int,
        @Field("is_easy") isEasy: Int*/

            .addFormDataPart("category", "1")
            .addFormDataPart("name", "param2222")
            .addFormDataPart("price", "3400")
            .addFormDataPart("quantity", "24")
            .addFormDataPart("picture", stringBase64)
            .addFormDataPart("watering", "param2")
            .addFormDataPart("sun", "param2")
            .addFormDataPart("temperature", "param2")
            .addFormDataPart("is_easy", "1")
            .build()
        return restClient.plantApiService().createPlant(
            /*requestBody*/
            category = 1,
            name = "testname2",
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