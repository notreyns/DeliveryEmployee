package com.neobis.deliveryemployee.app.fragments.florist

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.view.isVisible
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.neobis.deliveryemployee.R
import com.neobis.deliveryemployee.app.base.BaseFragment
import com.neobis.deliveryemployee.app.base.BaseViewModel
import com.neobis.deliveryemployee.app.fragments.florist.adapters.PlantListAdapter
import com.neobis.deliveryemployee.databinding.FragmentHomeFloristBinding
import com.neobis.deliveryemployee.domain.models.PlantItemModel
import org.koin.androidx.viewmodel.ext.android.viewModel

class HomeFloristFragment : BaseFragment<FragmentHomeFloristBinding>() {

    private val viewModel by viewModel<PlantViewModel>()

    override fun provideViewModel(): BaseViewModel? {
        return viewModel
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
        binding.plantsRecview.adapter = adapter
        adapter.onPlantClickListener = {
            findNavController().navigate(R.id.flowerDetailsFragment)
        }
        viewModel.getListOfPlants()
        viewModel.plants.observe(viewLifecycleOwner){
            adapter.setList(it)
        }
        viewModel.showLoading.observe(viewLifecycleOwner) {
            binding.progressBar.isVisible = it.isVisible
            binding.plantsRecview.isVisible = !it.isVisible
        }
    }


    private fun setupRecyclerView() {
     //val adapter = PlantListAdapter()

       /* val list = mutableListOf(
            PlantItemModel(R.drawable.example_plant, "Опунция", "Суккуленты",
                "4530 c", 6),
            PlantItemModel(R.drawable.example_plant, "Опунция", "Суккуленты",
                "4530 c", 6)
        )*/
       // adapter.setList(list)


    }


}