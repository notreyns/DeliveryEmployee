package com.neobis.deliveryemployee.domain.models

data class CourierNewOrderModel(
    val id: String,
    val floristAddress: String,
    val clientAddress: String,
    val price: String,
    val date: String,
)