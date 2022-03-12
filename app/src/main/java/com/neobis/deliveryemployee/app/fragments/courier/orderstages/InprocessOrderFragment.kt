package com.neobis.deliveryemployee.app.fragments.courier.orderstages

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.neobis.deliveryemployee.R
import com.neobis.deliveryemployee.app.base.BaseFragment
import com.neobis.deliveryemployee.databinding.FragmentInprocessOrderBinding
import com.neobis.deliveryemployee.databinding.FragmentUnaccepterOrderBinding

class InprocessOrderFragment: BaseFragment<FragmentInprocessOrderBinding>() {

    override fun inflateView(
        inflater: LayoutInflater,
        container: ViewGroup?
    ): FragmentInprocessOrderBinding? {
        return FragmentInprocessOrderBinding.inflate(inflater, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.unnaccepterOrderTitle.setNavigationOnClickListener {
            findNavController().navigate(R.id.homeCourierFragment)
        }
        binding.goToFloristBtn.setOnClickListener {
            findNavController().navigate(R.id.getOrderFromFloristFragment)
        }
    }

}