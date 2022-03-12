package com.neobis.deliveryemployee.app.fragments.courier.adapters


import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.neobis.deliveryemployee.databinding.CardNewCourierOrderItemBinding
import com.neobis.deliveryemployee.domain.models.CourierNewOrderModel


class NewOrdersListAdapter : RecyclerView.Adapter<NewOrdersListAdapter.NewOrderItemViewHolder>() {


    var orderList = listOf<CourierNewOrderModel>()
        set(value) {
            field = value
        }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NewOrderItemViewHolder {
        val binding = CardNewCourierOrderItemBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        )

        return NewOrderItemViewHolder(binding)
    }

    override fun onBindViewHolder(holder: NewOrderItemViewHolder, position: Int) {
        val historyItem = orderList[position]
        holder.binding.apply {
            idNewOrder.text = historyItem.id
            curoderFloristAddressTv.text = historyItem.floristAddress
            curorderCustomeradressTv.text= historyItem.clientAddress
            neworderPrice.text = historyItem.price


        }

    }

    override fun getItemCount(): Int {
        return orderList.size
    }

    class NewOrderItemViewHolder(val binding: CardNewCourierOrderItemBinding) :
        RecyclerView.ViewHolder(binding.root) {
    }
    }
