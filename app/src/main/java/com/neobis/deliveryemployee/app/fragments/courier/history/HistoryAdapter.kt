package com.neobis.deliveryemployee.app.fragments.courier.history


import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView

/*


class HistoryAdapter : RecyclerView.Adapter<HistoryAdapter.HistoryItemViewHolder>() {


    var orderList = listOf<CoruierHistoryModel>()
        set(value) {
            field = value
        }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HistoryItemViewHolder {
        val binding = CardCompletedOrderBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        )

        return HistoryItemViewHolder(binding)
    }

    override fun onBindViewHolder(holder: HistoryItemViewHolder, position: Int) {
        val historyItem = orderList[position]
        holder.binding.apply {
            historyDate.text = historyItem.date
            historyStatusTv.text = historyItem.status
            historyAddress.text = historyItem.address
            histoyTime.text = historyItem.time
        }
        val adapter = HistroryPlantListAdapter()
        adapter.histItemList= historyItem.list
        holder.binding.histItemsRecview.adapter = adapter

    }

    override fun getItemCount(): Int {
        return orderList.size
    }

    class HistoryItemViewHolder(val binding: CardCompletedOrderBinding) :
        RecyclerView.ViewHolder(binding.root) {
    }
    }
*/
