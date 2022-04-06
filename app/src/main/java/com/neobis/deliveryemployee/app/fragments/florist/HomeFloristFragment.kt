package com.neobis.deliveryemployee.app.fragments.florist

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.neobis.deliveryemployee.R
import com.neobis.deliveryemployee.app.base.BaseFragment
import com.neobis.deliveryemployee.app.base.BaseViewModel
import com.neobis.deliveryemployee.app.fragments.florist.adapters.PlantListAdapter
import com.neobis.deliveryemployee.databinding.FragmentHomeFloristBinding
import com.neobis.deliveryemployee.domain.models.PlantItemModel

class HomeFloristFragment : BaseFragment<FragmentHomeFloristBinding>() {

    override fun provideViewModel(): BaseViewModel? {
        return null
    }

    private val adapter by lazy {
        PlantListAdapter()
    }
    override fun inflateView(
        inflater: LayoutInflater,
        container: ViewGroup?
    ): FragmentHomeFloristBinding? {
        return FragmentHomeFloristBinding.inflate(inflater, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupRecyclerView()
        adapter.onPlantClickListener = {
            findNavController().navigate(R.id.flowerDetailsFragment)
        }

    }


    private fun setupRecyclerView() {
     //   val adapter = PlantListAdapter()
        binding.plantsRecview.adapter = adapter
       /* val list = mutableListOf(
            PlantItemModel(R.drawable.example_plant, "Опунция", "Суккуленты",
                "4530 c", 6),
            PlantItemModel(R.drawable.example_plant, "Опунция", "Суккуленты",
                "4530 c", 6)
        )*/
       // adapter.setList(list)


    }


}