package com.neobis.deliveryemployee.app.fragments.courier.orderstages

import android.app.AlertDialog
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.google.android.material.bottomsheet.BottomSheetDialog
import com.neobis.deliveryemployee.R
import com.neobis.deliveryemployee.app.base.BaseFragment
import com.neobis.deliveryemployee.databinding.DialogSuccessCourierJobBinding
import com.neobis.deliveryemployee.databinding.DialogSuccessPlatncreationBinding
import com.neobis.deliveryemployee.databinding.FragmentDeliverClientBinding
import com.neobis.deliveryemployee.databinding.FragmentFinishOrderBinding

class FinishOrderFragment: BaseFragment<FragmentFinishOrderBinding>() {

    override fun inflateView(
        inflater: LayoutInflater,
        container: ViewGroup?
    ): FragmentFinishOrderBinding? {
        return FragmentFinishOrderBinding.inflate(inflater, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.unnaccepterOrderTitle.setNavigationOnClickListener {
            findNavController().navigate(R.id.homeCourierFragment)
        }
        binding.completeOrder.setOnClickListener {
            showSuccessWorkAlertDialog()
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



    private fun showSuccessWorkAlertDialog() {
        val alertBinding = DialogSuccessCourierJobBinding.inflate(LayoutInflater.from(context))
        val mBuilder = AlertDialog.Builder(context)
            .setView(alertBinding.root)
        val mAlertDialog = mBuilder.show()
        alertBinding.hidesuccessplantAlert.setOnClickListener {
            mAlertDialog.dismiss()
            findNavController().navigate(R.id.homeCourierFragment)
        }
        mAlertDialog!!.window?.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
    }
}