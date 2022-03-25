package com.neobis.deliveryclient.app.model.loading

import android.os.Bundle
import androidx.annotation.IdRes
import androidx.navigation.NavOptions

data class FragmentTransaction(
    @IdRes val navigationId: Int,
    val bundle: Bundle? = null,
    val navOptions: NavOptions? = null
)