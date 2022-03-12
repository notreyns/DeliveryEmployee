package com.neobis.deliveryemployee.app.fragments.courier.adapters


import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.neobis.deliveryemployee.databinding.CardCourierHistoryItemBinding
import com.neobis.deliveryemployee.databinding.CardNewCourierOrderItemBinding
import com.neobis.deliveryemployee.domain.models.CourierNewOrderModel


class HistoryListAdapter : RecyclerView.Adapter<HistoryListAdapter.HistoryItemViewHolder>() {
    var onHistoryClickListener: ((CourierNewOrderModel) -> Unit)? = null

    var orderList = listOf<CourierNewOrderModel>()
        set(value) {
            field = value
        }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HistoryItemViewHolder {
        val binding = CardCourierHistoryItemBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        )

        return HistoryItemViewHolder(binding)
    }

    override fun onBindViewHolder(holder: HistoryItemViewHolder, position: Int) {
        val historyItem = orderList[position]
        holder.binding.apply {
            idNewOrder.text = historyItem.id
            curoderFloristAddressTv.text = historyItem.floristAddress
        }
        holder.binding.root.setOnClickListener {
            onHistoryClickListener?.invoke(historyItem)
        }

    }

    override fun getItemCount(): Int {
        return orderList.size
    }

    class HistoryItemViewHolder(val binding: CardCourierHistoryItemBinding) :
        RecyclerView.ViewHolder(binding.root) {
    }
    }
