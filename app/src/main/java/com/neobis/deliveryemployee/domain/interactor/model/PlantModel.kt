package com.neobis.deliveryemployee.domain.interactor.model

import com.neobis.deliveryemployee.data.entity.florist.CategoryEntity

data class PlantModel(
    val categoryModel: CategoryEntity,
    val date_created: String,
    val florist: Int,
    val id: Int,
    val is_sold: Boolean,
    val name: String,
    val picture: String,
    val price: String,
    val quantity: Int,
    val sun: String,
    val temperature: String,
    val watering: String
)