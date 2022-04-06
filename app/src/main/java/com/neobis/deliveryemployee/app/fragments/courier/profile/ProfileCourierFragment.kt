package com.neobis.deliveryemployee.app.fragments.courier.profile

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import com.neobis.deliveryemployee.R
import com.neobis.deliveryemployee.app.base.BaseFragment
import com.neobis.deliveryemployee.app.base.BaseViewModel
import com.neobis.deliveryemployee.databinding.FragmentProfileCourierBinding

class ProfileCourierFragment : BaseFragment<FragmentProfileCourierBinding>() {

    override fun provideViewModel(): BaseViewModel? {
        return null
    }

    override fun inflateView(
        inflater: LayoutInflater,
        container: ViewGroup?
    ): FragmentProfileCourierBinding? {
        return FragmentProfileCourierBinding.inflate(inflater, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupDropdown()
    }

    private fun setupDropdown() {
        val months = resources.getStringArray(R.array.month_dropdown)
        val dropdownAdapter = ArrayAdapter(requireContext(), R.layout.dropdown_item, months)
        binding.autoCompleteDropDown.setAdapter(dropdownAdapter)
    }


}