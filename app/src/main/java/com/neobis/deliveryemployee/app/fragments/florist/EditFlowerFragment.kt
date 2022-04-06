package com.neobis.deliveryemployee.app.fragments.florist

import android.app.AlertDialog
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.neobis.deliveryemployee.R
import com.neobis.deliveryemployee.app.base.BaseFragment
import com.neobis.deliveryemployee.app.base.BaseViewModel
import com.neobis.deliveryemployee.databinding.DialogSuccessPlanteditionBinding
import com.neobis.deliveryemployee.databinding.FragmentEditFlowerBinding


class EditFlowerFragment : BaseFragment<FragmentEditFlowerBinding>() {


    override fun provideViewModel(): BaseViewModel? {
        return null
    }
    override fun inflateView(
        inflater: LayoutInflater,
        container: ViewGroup?
    ): FragmentEditFlowerBinding? {
        return FragmentEditFlowerBinding.inflate(inflater, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.savechangesBtn.setOnClickListener {
            showSuccessAlert()
        }
    }

    private fun showSuccessAlert() {
        val alertBinding = DialogSuccessPlanteditionBinding.inflate(LayoutInflater.from(context))
        val mBuilder = AlertDialog.Builder(context)
            .setView(alertBinding.root)
        val mAlertDialog = mBuilder.show()
        alertBinding.hidesuccessplantAlert.setOnClickListener {
            mAlertDialog.dismiss()
            findNavController().navigate(R.id.flowerDetailsFragment)
        }
        mAlertDialog!!.window?.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
    }


}