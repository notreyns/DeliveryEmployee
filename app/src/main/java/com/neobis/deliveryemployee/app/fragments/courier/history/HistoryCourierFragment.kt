package com.neobis.deliveryemployee.app.fragments.courier.history

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.neobis.deliveryemployee.R
import com.neobis.deliveryemployee.app.base.BaseFragment
import com.neobis.deliveryemployee.app.base.BaseViewModel
import com.neobis.deliveryemployee.app.fragments.courier.adapters.HistoryListAdapter
import com.neobis.deliveryemployee.databinding.FragmentHistoryCourierBinding
import com.neobis.deliveryemployee.domain.models.CourierNewOrderModel


class HistoryCourierFragment : BaseFragment<FragmentHistoryCourierBinding>() {
    override fun provideViewModel(): BaseViewModel? {
        return null
    }

    override fun inflateView(
        inflater: LayoutInflater,
        container: ViewGroup?
    ): FragmentHistoryCourierBinding {
        return FragmentHistoryCourierBinding.inflate(inflater, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val list = mutableListOf(
            CourierNewOrderModel(
                "Заказ №109678",
                " м-р. Кок-Жар, ул 7-апреля 2/12",
                "Советская 97",
                "880 сом",
                "12.02.2022"
            ),
            CourierNewOrderModel(
                "Заказ №109677",
                " м-р. Кок-Жар, ул 7-апреля 2/12",
                "Советская 197",
                "320 сом",
                "12.02.2022"

            ),
            CourierNewOrderModel(
                "Заказ №109676",
                " м-р. Кок-Жар, ул 7-апреля 2/12",
                "Советская 97",
                "1500 сом",
                "12.02.2022"

            ),
            CourierNewOrderModel(
                "Заказ №109675",
                " м-р. Кок-Жар, ул 7-апреля 2/12",
                "Советская 197",
                "3500 сом",
                "12.02.2022"
            ),
        )

        val adapter = HistoryListAdapter()
        adapter.orderList = list
        binding.oldordersRecview.adapter = adapter
        adapter.onHistoryClickListener = {
            findNavController().navigate(R.id.completedOrderFragment)
        }
    }




}