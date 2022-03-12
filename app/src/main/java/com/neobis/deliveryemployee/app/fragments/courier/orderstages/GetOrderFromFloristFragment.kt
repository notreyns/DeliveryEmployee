package com.neobis.deliveryemployee.app.fragments.courier.orderstages

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.neobis.deliveryemployee.R
import com.neobis.deliveryemployee.app.base.BaseFragment
import com.neobis.deliveryemployee.databinding.FragmentGetOrderFromFloristBinding
import com.neobis.deliveryemployee.databinding.FragmentInprocessOrderBinding

class GetOrderFromFloristFragment : BaseFragment<FragmentGetOrderFromFloristBinding>() {

    override fun inflateView(
        inflater: LayoutInflater,
        container: ViewGroup?
    ): FragmentGetOrderFromFloristBinding? {
        return FragmentGetOrderFromFloristBinding.inflate(inflater, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.unnaccepterOrderTitle.setNavigationOnClickListener {
            findNavController().navigate(R.id.homeCourierFragment)
        }
        binding.takeOrderFlorist.setOnClickListener {
            findNavController().navigate(R.id.deliverClientFragment)
        }
    }
}