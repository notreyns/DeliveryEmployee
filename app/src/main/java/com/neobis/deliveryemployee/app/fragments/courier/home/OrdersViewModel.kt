package com.neobis.deliveryemployee.app.fragments.courier.home

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.neobis.deliveryemployee.app.base.BaseViewModel
import com.neobis.deliveryemployee.domain.interactor.model.OrderModel
import com.neobis.deliveryemployee.domain.interactor.usecase.courier.GetNewOrders

class OrdersViewModel(private val getList: GetNewOrders) : BaseViewModel() {

    private var _ordersList = MutableLiveData<List<OrderModel>>()
    val orders: LiveData<List<OrderModel>> = _ordersList

    fun getNewOrders() {
        showLoading()
        getList.execute(viewModelScope) { result ->
            result.perform(
                {
                    hideLoading()
                    _ordersList.value = it
                },
                {
                    Log.d("plant", it.message.toString())
                }
            )
        }
    }
}