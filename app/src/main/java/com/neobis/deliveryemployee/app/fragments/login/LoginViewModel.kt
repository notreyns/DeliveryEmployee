package com.neobis.deliveryemployee.app.fragments.login

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.example.evergreenclient.data.localDatabase.LocalDatabase
import com.neobis.deliveryclient.app.model.toast.ToastDuration
import com.neobis.deliveryclient.domain.interactor.model.UserModel
import com.neobis.deliveryclient.domain.interactor.usecase.login.LoginUseCase
import com.neobis.deliveryemployee.app.base.BaseViewModel

class LoginViewModel(
    private val loginUseCase: LoginUseCase,
    private val sharedPref: LocalDatabase
) : BaseViewModel() {

    private val _userRole = MutableLiveData<String>()
    val userRole: LiveData<String>
        get() = _userRole

    fun login(phone: String, password: String) {
        val user = UserModel("+996${phone.trim()}", password.trim())

        loginUseCase.execute(viewModelScope, user) { result ->
            result.perform(
                {
                    _userRole.value = it.role
                    /* sharedPref.saveAccessToken(it.access)
                     sharedPref.saveRefreshToken(it.refresh)*/
                    sharedPref.saveUserRole(it.role)
                    showToast("Пользователь успешно найден!", ToastDuration.SHORT)
                }, {
                    Log.d("login", it.message.toString() + it.localizedMessage)
                    showToast("Ошибка, повторите попытку! ${it.message}", ToastDuration.SHORT)
                }
            )
        }
    }

    fun checkUser() {
        if (sharedPref.fetchUserRole() == null) {
            _userRole.postValue("")
        } else {
            _userRole.postValue(sharedPref.fetchUserRole())
        }
    }


}