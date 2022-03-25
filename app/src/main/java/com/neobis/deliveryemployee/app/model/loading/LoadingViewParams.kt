package com.neobis.deliveryclient.app.model.loading

import androidx.annotation.StringRes
import com.neobis.deliveryclient.R

data class LoadingViewParams(
    val isVisible: Boolean,
    @StringRes val text: Int = R.string.app_name
)