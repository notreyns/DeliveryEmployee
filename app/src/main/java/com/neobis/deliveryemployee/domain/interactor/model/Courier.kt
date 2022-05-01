package com.neobis.deliveryemployee.domain.interactor.model

data class Courier(
    val courier_allowance: String,
    val id: Int,
    val salary: String,
    val user: User
)