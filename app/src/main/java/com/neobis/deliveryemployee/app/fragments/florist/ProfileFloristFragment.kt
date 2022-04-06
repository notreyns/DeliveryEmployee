package com.neobis.deliveryemployee.app.fragments.florist

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import com.neobis.deliveryemployee.R
import com.neobis.deliveryemployee.app.base.BaseFragment
import com.neobis.deliveryemployee.app.base.BaseViewModel
import com.neobis.deliveryemployee.databinding.FragmentProfileFloristBinding


class ProfileFloristFragment : BaseFragment<FragmentProfileFloristBinding>() {

    override fun provideViewModel(): BaseViewModel? {
        return null
    }

    override fun inflateView(
        inflater: LayoutInflater,
        container: ViewGroup?
    ): FragmentProfileFloristBinding? {
        return FragmentProfileFloristBinding.inflate(inflater, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        //setupSpinner()
        setupDropdown()
    }

    private fun setupDropdown() {
        val months = resources.getStringArray(R.array.month_dropdown)
        val dropdownAdapter = ArrayAdapter(requireContext(), R.layout.dropdown_item, months)
        binding.autoCompleteDropDown.setAdapter(dropdownAdapter)
    }

    /*private fun setupSpinner() {
        val spinner = binding.incomeSpinner
        val adapter = ArrayAdapter.createFromResource(
            requireContext(),
            R.array.month_dropdown, R.layout.dropdown_item
        )
        spinner.adapter = adapter
    }*/

}