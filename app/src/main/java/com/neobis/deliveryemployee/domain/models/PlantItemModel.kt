package com.neobis.deliveryemployee.domain.models

import android.net.Uri


data class PlantItemModel(
    var uri: Uri,
    var name: String,
    var category: Int,
    var quantity: Int,
    var price: Int,
    var description: String,


)