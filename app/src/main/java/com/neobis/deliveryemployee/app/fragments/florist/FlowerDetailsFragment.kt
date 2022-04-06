package com.neobis.deliveryemployee.app.fragments.florist

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.neobis.deliveryemployee.R
import com.neobis.deliveryemployee.app.base.BaseFragment
import com.neobis.deliveryemployee.app.base.BaseViewModel
import com.neobis.deliveryemployee.databinding.FragmentFlowerDetailsBinding


class FlowerDetailsFragment : BaseFragment<FragmentFlowerDetailsBinding>() {

    override fun provideViewModel(): BaseViewModel? {
        return null
    }
    override fun inflateView(
        inflater: LayoutInflater,
        container: ViewGroup?
    ): FragmentFlowerDetailsBinding? {
        return FragmentFlowerDetailsBinding.inflate(inflater, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        /* activity?.findViewById<BottomNavigationView>(R.id.bottomnavigationbar)
             ?.setVisibility(View.GONE)
         activity?.findViewById<FloatingActionButton>(R.id.fab)
             ?.setVisibility(View.GONE)*/
        binding.plantbackbtnImageView.setOnClickListener {
            findNavController().navigateUp()
        }
        binding.editplanthintTextView.setOnClickListener {
            findNavController().navigate(R.id.editFlowerFragment)
        }

    }

    override fun onDestroyView() {
        super.onDestroyView()
        activity?.findViewById<BottomNavigationView>(R.id.bottomnavigationbar)?.visibility = View.VISIBLE
        activity?.findViewById<FloatingActionButton>(R.id.fab)?.visibility = View.VISIBLE
    }


}