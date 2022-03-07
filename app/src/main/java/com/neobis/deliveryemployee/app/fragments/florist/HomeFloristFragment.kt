package com.neobis.deliveryemployee.app.fragments.florist

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.neobis.deliveryemployee.R
import com.neobis.deliveryemployee.app.base.BaseFragment
import com.neobis.deliveryemployee.app.fragments.adapters.PlantListAdapter
import com.neobis.deliveryemployee.databinding.FragmentHomeFloristBinding
import com.neobis.deliveryemployee.databinding.FragmentMainFloristBinding
import com.neobis.deliveryemployee.domain.models.PlantItemModel

class HomeFloristFragment : BaseFragment<FragmentHomeFloristBinding>() {

/*    private val adapter by lazy {
        PlantListAdapter()
    }*/
    override fun inflateView(
        inflater: LayoutInflater,
        container: ViewGroup?
    ): FragmentHomeFloristBinding? {
        return FragmentHomeFloristBinding.inflate(inflater, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupRecyclerView()


    }


    private fun setupRecyclerView() {
        val adapter = PlantListAdapter()
        binding.plantsRecview.adapter = adapter
        val list = mutableListOf(
            PlantItemModel(R.drawable.example_plant, "Опунция", "Суккуленты",
                "4530 c", 6),
            PlantItemModel(R.drawable.example_plant, "Опунция", "Суккуленты",
                "4530 c", 6)
        )
        adapter.setList(list)


    }


}