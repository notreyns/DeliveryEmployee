package com.neobis.deliveryemployee.app.fragments.florist.adapters

import android.text.Html
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.neobis.deliveryemployee.R
import com.neobis.deliveryemployee.databinding.CardPlantItemBinding
import com.neobis.deliveryemployee.domain.interactor.model.PlantModel
import com.neobis.deliveryemployee.domain.models.PlantItemModel


class PlantListAdapter : RecyclerView.Adapter<PlantListAdapter.PlantItemViewHolder>() {

    var onPlantClickListener: ((PlantModel) -> Unit)? = null

    private var plantList: List<PlantModel> = mutableListOf()

    fun setList(list: List<PlantModel>) {
        this.plantList = list.toMutableList()
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PlantItemViewHolder {
        val binding = CardPlantItemBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        )
        return PlantItemViewHolder(binding)
    }


    override fun onBindViewHolder(holder: PlantItemViewHolder, position: Int) {
        val plantItem = plantList[position]
        holder.binding.apply {
            cardPlantCateg.text = String.format(
                cardPlantCateg.context.getString(R.string.category_plant), plantItem.categoryModel.name
            )
            cardPlantName.text = plantItem.name
            cardPlantPrice.text = plantItem.price.toString() + " c"
            val quantityStr = String.format(
                cardPlantQuantity.context.getString(R.string.quantity_plant),
                plantItem.quantity
            )

            cardPlantQuantity.text = Html.fromHtml(quantityStr)
            Glide.with(holder.itemView.context).load(plantItem.picture)
                .into(holder.binding.cardPlantImg)
        }

        holder.itemView.setOnClickListener {
            onPlantClickListener?.invoke(plantItem)
        }
    }

    override fun getItemCount(): Int {
        return plantList.size
    }

    class PlantItemViewHolder(val binding: CardPlantItemBinding) :
        RecyclerView.ViewHolder(binding.root) {
    }
}