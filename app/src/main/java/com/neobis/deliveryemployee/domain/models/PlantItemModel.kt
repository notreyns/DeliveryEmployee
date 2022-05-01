package com.neobis.deliveryemployee.domain.models

import android.graphics.Bitmap
import java.io.File


data class PlantItemModel(
     var file: File,
    var bitmap: Bitmap,
    var name: String,
    var category: Int,
    var quantity: Int,
    var price: Int,
    var description: String,
)