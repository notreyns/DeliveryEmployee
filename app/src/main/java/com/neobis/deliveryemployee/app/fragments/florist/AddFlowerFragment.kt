package com.neobis.deliveryemployee.app.fragments.florist

import android.app.AlertDialog
import android.graphics.Bitmap
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.net.Uri
import android.os.Bundle
import android.provider.MediaStore
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import androidx.activity.result.contract.ActivityResultContracts
import com.google.android.material.bottomsheet.BottomSheetDialogFragment
import com.neobis.deliveryemployee.R
import com.neobis.deliveryemployee.app.base.BaseViewModel
import com.neobis.deliveryemployee.databinding.DialogSuccessPlatncreationBinding
import com.neobis.deliveryemployee.databinding.FragmentAddFlowerBinding
import org.koin.androidx.viewmodel.ext.android.viewModel


class AddFlowerFragment : BottomSheetDialogFragment() {

    private lateinit var binding: FragmentAddFlowerBinding


    private var uri:  Uri? = null
    private var bitmap:  Bitmap? = null

    private val viewModel by viewModel<PlantViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        provideViewModel()?.let { observableViewModel ->
            lifecycle.addObserver(observableViewModel)
        }
    }

    private fun provideViewModel(): BaseViewModel? {
        return viewModel
    }


    private val getContent =
        registerForActivityResult(ActivityResultContracts.GetContent()) { uri ->
            if (uri != null) {
             //   binding.addplantPhotoIv.setImageURI(uri)
                val bitmap = MediaStore.Images.Media.getBitmap(requireContext().contentResolver, uri)
                Log.d("plant", bitmap.toString())
                binding.addplantPhotoIv.setImageBitmap(bitmap)
                this.bitmap = bitmap
                this.uri = uri
            }
        }

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
            Log.d("plant", "clicklistenner")
            viewModel.createPlant(bitmap!!, "test name", 1, 12, 423, "test desription")
        }
        binding.addplantPhotoCard.setOnClickListener {
            selectImageFromGallery()

        }
    }

    private fun selectImageFromGallery() = getContent.launch("image/*")


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