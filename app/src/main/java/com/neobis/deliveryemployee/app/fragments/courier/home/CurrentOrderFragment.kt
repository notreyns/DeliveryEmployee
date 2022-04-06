package com.neobis.deliveryemployee.app.fragments.courier.home

import android.view.LayoutInflater
import android.view.ViewGroup
import com.neobis.deliveryemployee.app.base.BaseFragment
import com.neobis.deliveryemployee.app.base.BaseViewModel
import com.neobis.deliveryemployee.databinding.FragmentCurrentOrderBinding


class CurrentOrderFragment : BaseFragment<FragmentCurrentOrderBinding>() {


    override fun provideViewModel(): BaseViewModel? {
        return null
    }

    override fun inflateView(
        inflater: LayoutInflater,
        container: ViewGroup?
    ): FragmentCurrentOrderBinding? {
        return FragmentCurrentOrderBinding.inflate(inflater, container, false)
    }

}