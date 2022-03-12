package com.neobis.deliveryemployee.app.fragments.courier.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.neobis.deliveryemployee.app.base.BaseFragment
import com.neobis.deliveryemployee.app.fragments.courier.adapters.NewOrdersListAdapter
import com.neobis.deliveryemployee.databinding.FragmentNewOrdersBinding
import com.neobis.deliveryemployee.domain.models.CourierNewOrderModel

class NewOrdersFragment : BaseFragment<FragmentNewOrdersBinding>() {


    override fun inflateView(
        inflater: LayoutInflater,
        container: ViewGroup?
    ): FragmentNewOrdersBinding {
        return FragmentNewOrdersBinding.inflate(inflater, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupRecyclerView()
    }


    private fun setupRecyclerView() {
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

        val adapter = NewOrdersListAdapter()
        adapter.orderList = list
        binding.newordersRecview.adapter = adapter
    }


}
