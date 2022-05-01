package com.neobis.deliveryemployee.data.repository

import com.neobis.deliveryclient.data.rest.client.RestClient
import com.neobis.deliveryclient.domain.interactor.result.Result
import com.neobis.deliveryemployee.data.entity.mapper.mappers.PlantMapper
import com.neobis.deliveryemployee.domain.interactor.model.PlantModel
import com.neobis.deliveryemployee.domain.interactor.repository.PlantsRepository
import com.neobis.deliveryemployee.domain.models.PlantItemModel
import okhttp3.MediaType.Companion.toMediaTypeOrNull
import okhttp3.MultipartBody
import okhttp3.RequestBody
import okhttp3.RequestBody.Companion.asRequestBody


class PlantsRepositoryImpl(
    private val restClient: RestClient,
    private val mapper: PlantMapper
) : PlantsRepository {

    override fun createPlant(plantItem: PlantItemModel?): Result<PlantItemModel> {

        val requestFile: RequestBody =
            RequestBody.create("multipart/form-data".toMediaTypeOrNull(), plantItem!!.file)

        plantItem.file.asRequestBody()
        val body: MultipartBody.Part =
            MultipartBody.Part.createFormData("picture", plantItem.file.getName(), requestFile)

        return restClient.plantApiService().createPlant(
            /*requestBody*/
            category = 1,
            name = "testname3",
            price = 3400,
            quantity = 24,
            image = body,
            sun = "test",
            temp = "test",
            water = "test",
            isEasy = 1,
        )
    }

    override fun getList(): Result<List<PlantModel>> {
        return restClient.plantApiService().getList().map {
            mapper.transform(it)
        }
    }
}
/*    val requestFile: RequestBody =
        RequestBody.create("multipart/form-data".toMediaTypeOrNull(), plantItem.file)

    val body: MultipartBody.Part =
        MultipartBody.Part.createFormData("image", plantItem.file.getName(), requestFile)*/

/* val bodyBuilder = MultipartBody.Builder().setType(MultipartBody.FORM)
 val requestBody = plantItem.file?.asRequestBody("image/*".toMediaTypeOrNull())
  if (requestBody != null) {
   bodyBuilder.addFormDataPart("picture", plantItem.file.name, requestBody)
  }
 val requestFile: RequestBody =
     RequestBody.create("multipart/form-data".toMediaTypeOrNull(), stringBase64)
 bodyBuilder.addPart(requestFile)*/


}

override fun getList(): Result<List<PlantModel>> {

}
}


// val requestBody: RequestBody = MultipartBody.Builder()
// .setType(MultipartBody.FORM)
/* @Field("category") category: Int,
@Field("picture") image: String,
@Field("price") price :Int,
@Field("name") name: String,
@Field("watering") water: String,
@Field("temperature") temp: String,
@Field("sun") sun: String,
@Field("quantity") quantity: Int,
@Field("is_easy") isEasy: Int*/

/*   .addFormDataPart("category", "1")
.addFormDataPart("name", "param2222")
.addFormDataPart("price", "3400")
.addFormDataPart("quantity", "24")
.addFormDataPart("picture", stringBase64)
.addFormDataPart("watering", "param2")
.addFormDataPart("sun", "param2")
.addFormDataPart("temperature", "param2")
.addFormDataPart("is_easy", "1")
.build()*/


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