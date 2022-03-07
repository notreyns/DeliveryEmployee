package com.neobis.deliveryemployee.app.fragments.florist

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.Spinner
import com.google.android.material.bottomsheet.BottomSheetDialogFragment
import com.neobis.deliveryemployee.R
import com.neobis.deliveryemployee.databinding.FragmentAddFlowerBinding


class AddFlowerFragment : BottomSheetDialogFragment() {

    private lateinit var binding: FragmentAddFlowerBinding


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentAddFlowerBinding.inflate(inflater, container, false)
        // Inflate the layout for this fragment
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val categories = resources.getStringArray(R.array.categ_dropdown)
        val dropdownAdapter = ArrayAdapter(requireContext(), R.layout.dropdown_item, categories)
        binding.autoCompleteDropDown.setAdapter(dropdownAdapter)

    }

    override fun onResume() {
        super.onResume()
        val categories = resources.getStringArray(R.array.categ_dropdown)
        val dropdownAdapter = ArrayAdapter(requireContext(), R.layout.dropdown_item, categories)
        binding.autoCompleteDropDown.setAdapter(dropdownAdapter)
    }

}