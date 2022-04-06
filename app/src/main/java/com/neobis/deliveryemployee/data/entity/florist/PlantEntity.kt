package com.neobis.deliveryemployee.data.entity.florist


data class PlantEntity(
    val category: CategoryEntity,
    val date_created: String,
    val description: String,
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