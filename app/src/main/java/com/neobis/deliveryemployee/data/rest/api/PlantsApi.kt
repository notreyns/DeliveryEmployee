package com.neobis.deliveryemployee.data.rest.api

import com.neobis.deliveryclient.domain.interactor.result.Result
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.POST


interface PlantsApi {

    @FormUrlEncoded
    @POST(CREATE_PLANT_ENDPOINT)
    fun createPlant(
        @Field("category") category: Int,
        @Field("picture") image: String,
        @Field("price") price :Int,
        @Field("name") name: String,
        @Field("watering") water: String,
        @Field("temperature") temp: String,
        @Field("sun") sun: String,
        @Field("quantity") quantity: Int,
        @Field("is_easy") isEasy: Int,
        ): Result<Void>


    companion object {
        private const val CREATE_PLANT_ENDPOINT = "products/plants/"
    }

}