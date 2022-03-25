package com.neobis.deliveryemployee.app.activity.base

import android.os.Bundle
import androidx.annotation.IdRes
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.NavController
import androidx.navigation.Navigation
import com.neobis.deliveryemployee.R

import com.neobis.deliveryclient.app.model.loading.FragmentTransaction

abstract class BaseActivity : AppCompatActivity() {

    protected lateinit var navigation: NavController

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onStart() {
        super.onStart()
        initializeNavController()
    }

    fun navigateToFragment(fragmentTransaction: FragmentTransaction) {
        navigation.navigate(
            fragmentTransaction.navigationId,
            fragmentTransaction.bundle,
            fragmentTransaction.navOptions
        )
    }

    fun popBackStack(@IdRes navigationId: Int, inclusive: Boolean = false) {
        navigation.popBackStack(navigationId, inclusive)
    }

    private fun initializeNavController() {
        navigation = Navigation.findNavController(this, R.id.nav_host_fragment)
    }
}