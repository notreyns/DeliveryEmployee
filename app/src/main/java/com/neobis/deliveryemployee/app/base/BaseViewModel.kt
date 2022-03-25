package com.neobis.deliveryemployee.app.base

import android.content.Context
import android.os.Bundle
import androidx.annotation.IdRes
import androidx.annotation.StringRes
import androidx.lifecycle.DefaultLifecycleObserver
import androidx.lifecycle.ViewModel
import com.neobis.deliveryclient.app.exception.factory.ErrorMessageFactory
import com.neobis.deliveryclient.app.helper.event.SingleLiveEvent
import com.neobis.deliveryclient.app.model.loading.FragmentTransaction
import com.neobis.deliveryclient.app.model.loading.LoadingParams
import com.neobis.deliveryclient.app.model.loading.LoadingViewParams
import com.neobis.deliveryclient.app.model.toast.ToastDuration
import com.neobis.deliveryclient.domain.interactor.result.Result
import com.neobis.deliveryemployee.R

abstract class BaseViewModel : ViewModel() , DefaultLifecycleObserver {

    lateinit var context: () -> Context
    lateinit var requiredArguments: () -> Bundle

    val navigateToFragment = SingleLiveEvent<FragmentTransaction>()
    val showLoading = SingleLiveEvent<LoadingParams>()
    val showLoadingView = SingleLiveEvent<LoadingViewParams>()
    val showToast = SingleLiveEvent<Pair<String, ToastDuration>>()

    fun showToast(message: String, duration: ToastDuration) {
        showToast.startEvent(Pair(message, duration))
    }

    fun navigateFragment(@IdRes navigationId: Int, bundle: Bundle? = null) {
        val fragmentTransaction = FragmentTransaction(navigationId, bundle)
        navigateToFragment.startEvent(fragmentTransaction)
    }

    fun showLoading() {
        showLoading.startEvent(LoadingParams(true))
    }

    fun hideLoading() {
        showLoading.startEvent(LoadingParams(false))
    }

    fun showLoadingView(@StringRes message: Int = R.string.app_name) {
        showLoadingView.startEvent(LoadingViewParams(true, message))
    }

    fun hideLoadingView() {
        showLoadingView.startEvent(LoadingViewParams(false))
    }

    fun <T> handleResult(result: Result<T>, onSuccess: (T) -> Unit) {
        result.perform(onSuccess = onSuccess) { throwable ->
            onCoroutinesFailed(throwable)
        }
    }

    protected fun getString(@StringRes resourceId: Int): String {
        return context().getString(resourceId)
    }

    private fun onCoroutinesFailed(
        throwable: Throwable,
        defaultErrorMessage: String = getString(R.string.app_name)
    ) {
        throwable.printStackTrace()

        val errorMessage = ErrorMessageFactory.create(throwable)
        showToast(errorMessage ?: defaultErrorMessage, ToastDuration.LONG)
        hideLoading()
    }
}
