package com.neobis.deliveryemployee.app.fragments.courier.orderstages

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.google.android.material.bottomsheet.BottomSheetDialog
import com.neobis.deliveryemployee.R
import com.neobis.deliveryemployee.app.base.BaseFragment
import com.neobis.deliveryemployee.app.base.BaseViewModel
import com.neobis.deliveryemployee.databinding.FragmentGetOrderFromFloristBinding
import com.neobis.deliveryemployee.databinding.FragmentInprocessOrderBinding

class GetOrderFromFloristFragment : BaseFragment<FragmentGetOrderFromFloristBinding>() {

    override fun provideViewModel(): BaseViewModel? {
        return null
    }

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
        binding.openDetailsBottom.setOnClickListener {
            showOrderDetailsBottomSheet()
        }
    }

    private fun showOrderDetailsBottomSheet() {
        val bottomSheetDialog = BottomSheetDialog(requireContext())
        bottomSheetDialog.setContentView(R.layout.bottomsheet_plantslist_courier)
        bottomSheetDialog.show()

    }

}