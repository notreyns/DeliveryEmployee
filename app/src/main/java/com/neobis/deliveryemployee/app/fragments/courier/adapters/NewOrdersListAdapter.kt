package com.neobis.deliveryemployee.app.fragments.courier.adapters


import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.neobis.deliveryemployee.databinding.CardNewCourierOrderItemBinding
import com.neobis.deliveryemployee.domain.interactor.model.OrderModel
import com.neobis.deliveryemployee.domain.models.CourierNewOrderModel
import com.neobis.deliveryemployee.domain.models.PlantItemModel


class NewOrdersListAdapter : RecyclerView.Adapter<NewOrdersListAdapter.NewOrderItemViewHolder>() {
    var onOrderClickListener: ((OrderModel) -> Unit)? = null

    var orderList = listOf<OrderModel>()
        set(value) {
            field = value
            notifyDataSetChanged()
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
            idNewOrder.text = "Заказ №" + historyItem.id.toString()
            curoderFloristAddressTv.text = "Советская 111"
            curorderCustomeradressTv.text = historyItem.address
            neworderPrice.text = "10"+historyItem.total_price.toString() + " coм"
            dateNew.text = historyItem.date_created.substring(0, 10)
        }
        holder.binding.root.setOnClickListener {
            onOrderClickListener?.invoke(historyItem)
        }

    }

    override fun getItemCount(): Int {
        return orderList.size
    }

    class NewOrderItemViewHolder(val binding: CardNewCourierOrderItemBinding) :
        RecyclerView.ViewHolder(binding.root) {
    }
    }
