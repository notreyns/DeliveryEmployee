package com.neobis.deliveryemployee.data.rest.api

import com.neobis.deliveryclient.domain.interactor.result.Result
import okhttp3.MultipartBody
import retrofit2.http.*


interface PlantsApi {

    @Multipart
    @FormUrlEncoded
    @POST(CREATE_PLANT_ENDPOINT)
    fun createPlant(
        @Field("category") category: Int,
        @Field("name") name: String,
        @Field("price") price: Int,
        @Field("description") description: String,
        @Field("quantity") quantity:Int,
        @Part image: MultipartBody.Part
    ): Result<Void>


    companion object {
        private const val CREATE_PLANT_ENDPOINT = "products/plants/"
    }

}