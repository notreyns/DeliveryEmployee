package com.neobis.deliveryemployee.domain.models

import android.graphics.Bitmap



data class PlantItemModel(
    var bitmap: Bitmap,
    var name: String,
    var category: Int,
    var quantity: Int,
    var price: Int,
    var description: String,

    )