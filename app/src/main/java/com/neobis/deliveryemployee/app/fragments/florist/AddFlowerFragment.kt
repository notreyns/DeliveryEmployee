package com.neobis.deliveryemployee.app.fragments.florist

import android.app.AlertDialog
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.Button
import com.google.android.material.bottomsheet.BottomSheetDialogFragment
import com.neobis.deliveryemployee.R
import com.neobis.deliveryemployee.databinding.DialogSuccessPlatncreationBinding
import com.neobis.deliveryemployee.databinding.FragmentAddFlowerBinding


class AddFlowerFragment : BottomSheetDialogFragment() {

    private lateinit var binding: FragmentAddFlowerBinding


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentAddFlowerBinding.inflate(inflater, container, false)

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val categories = resources.getStringArray(R.array.categ_dropdown)
        val dropdownAdapter = ArrayAdapter(requireContext(), R.layout.dropdown_item, categories)
        binding.autoCompleteDropDown.setAdapter(dropdownAdapter)
        binding.addplantBtn.setOnClickListener {
            showSuccessAlert()
        }

    }

    private fun showSuccessAlert() {
        val alertBinding = DialogSuccessPlatncreationBinding.inflate(LayoutInflater.from(context))
        val mBuilder = AlertDialog.Builder(context)
            .setView(alertBinding.root)
        val mAlertDialog = mBuilder.show()
        alertBinding.hidesuccessplantAlert.setOnClickListener {
            mAlertDialog.dismiss()
        }
        mAlertDialog!!.window?.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))

    }

    override fun onResume() {
        super.onResume()
        val categories = resources.getStringArray(R.array.categ_dropdown)
        val dropdownAdapter = ArrayAdapter(requireContext(), R.layout.dropdown_item, categories)
         binding.autoCompleteDropDown.setAdapter(dropdownAdapter)
    }

}