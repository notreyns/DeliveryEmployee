package com.neobis.deliveryemployee.domain.models

data class CoruierHistoryModel(
    val date: String,
    val status: String,
    val list: List<PlantItemModel>,
    val address: String,
    val time: String
)