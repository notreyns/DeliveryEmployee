package com.neobis.deliveryemployee.app.fragments.courier.history

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import com.neobis.deliveryemployee.app.base.BaseFragment
import com.neobis.deliveryemployee.databinding.FragmentHistoryCourierBinding


class HistoryCourierFragment : BaseFragment<FragmentHistoryCourierBinding>() {

    override fun inflateView(
        inflater: LayoutInflater,
        container: ViewGroup?
    ): FragmentHistoryCourierBinding {
        return FragmentHistoryCourierBinding.inflate(inflater, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        /*val viewPager = binding.historyViewpager
        val tabLayout = binding.historyTablay

        val adapter = HistoryViewPager(childFragmentManager, lifecycle)
        viewPager.adapter = adapter

        val categoryArray = arrayOf(
            "Текущий заказ",
            "Завершенные заказы",
        )
        TabLayoutMediator(tabLayout, viewPager) { tab, position ->
            tab.text = categoryArray[position]
        }.attach()*/
    }


}