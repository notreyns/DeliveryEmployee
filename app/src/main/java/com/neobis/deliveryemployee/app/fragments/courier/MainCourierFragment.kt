package com.neobis.deliveryemployee.app.fragments.courier

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.Navigation
import androidx.navigation.ui.NavigationUI
import com.neobis.deliveryemployee.R
import com.neobis.deliveryemployee.app.base.BaseFragment
import com.neobis.deliveryemployee.databinding.FragmentMainCourierBinding

class MainCourierFragment: BaseFragment<FragmentMainCourierBinding>() {
    override fun inflateView(
        inflater: LayoutInflater,
        container: ViewGroup?
    ): FragmentMainCourierBinding? {
        return FragmentMainCourierBinding.inflate(inflater, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val navController = Navigation.findNavController(requireActivity(), R.id.home_courier_fragm)
        NavigationUI.setupWithNavController(binding.bottomnavigationbar, navController)

    }
}