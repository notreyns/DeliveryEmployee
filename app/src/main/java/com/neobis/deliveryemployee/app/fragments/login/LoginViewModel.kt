package com.neobis.deliveryemployee.app.fragments.login

import androidx.lifecycle.viewModelScope
import com.neobis.deliveryclient.app.model.toast.ToastDuration
import com.neobis.deliveryclient.domain.interactor.model.UserModel
import com.neobis.deliveryclient.domain.interactor.usecase.login.LoginUseCase
import com.neobis.deliveryemployee.app.base.BaseViewModel

class LoginViewModel(
    private val loginUseCase: LoginUseCase
) : BaseViewModel() {

    fun login(phone: String, password: String) {
        val user = UserModel(phone, password)
        loginUseCase.execute(viewModelScope, user) { result ->
            result.perform(
                {
                    showToast("Пользователь успешно вошел!", ToastDuration.SHORT)
                }, {
                    showToast("Ошибка, повторите попытку!", ToastDuration.SHORT)
                }

            )
        }
    }


}