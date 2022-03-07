package com.neobis.deliveryemployee.app.fragments.florist

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.Navigation
import androidx.navigation.fragment.findNavController
import androidx.navigation.ui.NavigationUI
import com.google.android.material.bottomsheet.BottomSheetDialog
import com.neobis.deliveryemployee.R
import com.neobis.deliveryemployee.app.base.BaseFragment
import com.neobis.deliveryemployee.databinding.FragmentMainFloristBinding


class MainFloristFragment : BaseFragment<FragmentMainFloristBinding>() {

    override fun inflateView(
        inflater: LayoutInflater,
        container: ViewGroup?
    ): FragmentMainFloristBinding? {
        return FragmentMainFloristBinding.inflate(inflater, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val navController = Navigation.findNavController(requireActivity(), R.id.home_florist_fragm)
        NavigationUI.setupWithNavController(binding.bottomnavigationbar, navController)

        binding.fab.setOnClickListener{
           showAddPlantBotttomSheet()
        }


    }

    private fun showAddPlantBotttomSheet() {
        val bottomSheetDialog = BottomSheetDialog(requireContext());
        bottomSheetDialog.setContentView(R.layout.fragment_add_flower)
        bottomSheetDialog.show()
    }


}