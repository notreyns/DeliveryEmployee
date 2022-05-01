package com.neobis.deliveryemployee.data.rest.api

import com.neobis.deliveryclient.domain.interactor.result.Result
import com.neobis.deliveryemployee.data.entity.florist.PlantEntity
import com.neobis.deliveryemployee.data.rest.api.PlantsApi.Companion.GET_PLANTS_ENDPOINT
import com.neobis.deliveryemployee.domain.models.PlantItemModel
import okhttp3.MultipartBody
import okhttp3.RequestBody
import retrofit2.http.*


interface PlantsApi {


    @Multipart
    @POST(CREATE_PLANT_ENDPOINT)
    fun createPlant(
        @Part("category") category: Int,
        @Part image: MultipartBody.Part,
        @Part("price") price: Int,
        @Part("name") name: String,
        @Part("watering") water: String,
        @Part("temperature") temp: String,
        @Part("sun") sun: String,
        @Part("quantity") quantity: Int,
        @Part("is_easy") isEasy: Int
    ): Result<PlantItemModel>


    @Headers(
        "Content-Type: application/json"
    )
    @FormUrlEncoded
    @POST(CREATE_PLANT_ENDPOINT)
    fun createPlant2(
        @Field("category") category: Int,
        @Field("picture") image: String,
        @Field("price") price: Int,
        @Field("name") name: String,
        @Field("watering") water: String,
        @Field("temperature") temp: String,
        @Field("sun") sun: String,
        @Field("quantity") quantity: Int,
        @Field("is_easy") isEasy: Int
    ): Result<PlantItemModel>


    @GET(GET_PLANTS_ENDPOINT)
    fun getList(): Result<List<PlantEntity>>


    companion object {
        private const val CREATE_PLANT_ENDPOINT = "products/plants/"
        private const val GET_PLANTS_ENDPOINT = "florist-plant-history"
    }

}