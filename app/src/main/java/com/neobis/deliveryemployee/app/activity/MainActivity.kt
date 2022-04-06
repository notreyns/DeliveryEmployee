package com.neobis.deliveryemployee.app.activity

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.findNavController
import com.example.evergreenclient.data.localDatabase.LocalDatabase
import com.neobis.deliveryemployee.R
import com.neobis.deliveryemployee.app.fragments.login.LoginViewModel
import org.koin.androidx.viewmodel.ext.android.viewModel

class MainActivity : AppCompatActivity() {

    private val viewModel  by viewModel<LoginViewModel>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val navController = findNavController(R.id.nav_host_fragment)

        //val sharedPreferences = LocalDatabase(applicationContext)

        viewModel.checkUser()
        viewModel.userRole.observe(this){
            if(it.length == 0){
                navController.navigate(R.id.loginFragment)
            }else if(it == "Курьер"){
                navController.navigate(R.id.mainCourierFragment)
            }else if(it == "Флорист"){
                navController.navigate(R.id.mainFloristFragment)
            }
        }
       /* if (sharedPreferences.fetchUserRole() == null) {
            navController.navigate(R.id.loginFragment)
        } else if (sharedPreferences.fetchUserRole() == "Курьер") {
            navController.navigate(R.id.mainCourierFragment)
        } else if (sharedPreferences.fetchUserRole() == "Флорист") {
            navController.navigate(R.id.mainFloristFragment)
        }*/
    }
}