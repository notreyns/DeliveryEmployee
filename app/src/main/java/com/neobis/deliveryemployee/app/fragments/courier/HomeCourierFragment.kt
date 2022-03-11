package com.neobis.deliveryemployee.app.fragments.courier

import android.view.LayoutInflater
import android.view.ViewGroup
import com.neobis.deliveryemployee.app.base.BaseFragment
import com.neobis.deliveryemployee.databinding.FragmentHomeCourierBinding
import com.neobis.deliveryemployee.databinding.FragmentMainCourierBinding

class HomeCourierFragment: BaseFragment<FragmentHomeCourierBinding>() {
    override fun inflateView(
        inflater: LayoutInflater,
        container: ViewGroup?
    ): FragmentHomeCourierBinding? {
        return FragmentHomeCourierBinding.inflate(inflater, container, false)
    }
}