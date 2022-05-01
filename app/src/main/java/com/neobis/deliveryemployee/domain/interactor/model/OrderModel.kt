package com.neobis.deliveryemployee.domain.interactor.model

data class OrderModel(
    val id: Int,
    val client: Any,
    val client_status: String,
    val comment: String,
   // val courier: Courier,
    val courier_status: String,
    val date_created: String,
    val first_name: String,
    val last_name: String,
    val phone_number: String,
    val address: String,
    val is_active: Boolean,
    val is_cancelled: Boolean,
    val total_price: Int
)