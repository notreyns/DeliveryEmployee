package com.neobis.deliveryemployee.app.fragments.courier.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.google.android.material.tabs.TabLayoutMediator
import com.neobis.deliveryemployee.app.base.BaseFragment
import com.neobis.deliveryemployee.app.base.BaseViewModel
import com.neobis.deliveryemployee.app.fragments.courier.home.HomeOrdersViewPager
import com.neobis.deliveryemployee.databinding.FragmentHomeCourierBinding

class HomeCourierFragment: BaseFragment<FragmentHomeCourierBinding>() {
    override fun provideViewModel(): BaseViewModel? {
        return null
    }

    override fun inflateView(
        inflater: LayoutInflater,
        container: ViewGroup?
    ): FragmentHomeCourierBinding? {
        return FragmentHomeCourierBinding.inflate(inflater, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val viewPager = binding.historyViewpager
        val tabLayout = binding.historyTablay

        val adapter = HomeOrdersViewPager(childFragmentManager, lifecycle)
        viewPager.adapter = adapter

        val categoryArray = arrayOf(
            "Текущий заказ",
            "Новые заказы",
        )
        TabLayoutMediator(tabLayout, viewPager) { tab, position ->
            tab.text = categoryArray[position]
        }.attach()
    }
}