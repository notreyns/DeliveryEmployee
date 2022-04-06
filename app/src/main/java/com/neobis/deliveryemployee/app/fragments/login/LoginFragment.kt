package com.neobis.deliveryemployee.app.fragments.login

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.neobis.deliveryemployee.R
import com.neobis.deliveryemployee.app.base.BaseFragment
import com.neobis.deliveryemployee.app.base.BaseViewModel
import com.neobis.deliveryemployee.databinding.FragmentLoginBinding
import org.koin.androidx.viewmodel.ext.android.viewModel


class LoginFragment : BaseFragment<FragmentLoginBinding>() {

    private val viewModel by viewModel<LoginViewModel>()

    override fun provideViewModel(): BaseViewModel? {
        return viewModel
    }

    override fun inflateView(
        inflater: LayoutInflater,
        container: ViewGroup?
    ): FragmentLoginBinding? {
        return FragmentLoginBinding.inflate(
            inflater, container, false
        )
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.loginBtn.setOnClickListener {
            viewModel.login(binding.phoneEt.text.toString(), binding.passwordEt.text.toString())
        }
        viewModel.userRole.observe(viewLifecycleOwner){
            if (it == null) {
                findNavController().navigate(R.id.loginFragment)
            } else if (it == "Курьер") {
                findNavController().navigate(R.id.mainCourierFragment)
            } else if (it == "Флорист") {
                findNavController().navigate(R.id.mainFloristFragment)
            }
        }

    }


}