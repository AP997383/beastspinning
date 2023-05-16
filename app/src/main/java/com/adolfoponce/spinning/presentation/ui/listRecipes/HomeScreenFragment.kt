package com.adolfoponce.spinning.presentation.ui.listRecipes

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.SearchView
import android.widget.Toast
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.adolfoponce.spinning.R
import com.adolfoponce.spinning.databinding.FragmentSecondBinding
import com.adolfoponce.spinning.domain.model.RecipesModel
import com.adolfoponce.spinning.presentation.model.HomeViewModel
import com.adolfoponce.spinning.presentation.ui.listRecipes.adapter.RecipesAdapter

class HomeScreenFragment  : Fragment() {

    private var _binding: FragmentSecondBinding? = null
    private val homeViewModel by activityViewModels<HomeViewModel>()
    lateinit var adapter: RecipesAdapter
    var localData:ArrayList<RecipesModel> = arrayListOf()

    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentSecondBinding.inflate(inflater, container, false)
        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        adapter = RecipesAdapter(requireContext(), arrayListOf()) {
            // var action = HomeScreenFragmentDirections.actionSecondFragmentToDetailRecipeFragment(it)
           // findNavController().navigate(action)
        }

        var manager = LinearLayoutManager(requireContext(), LinearLayoutManager.VERTICAL,false)
        //binding.listRecipes.layoutManager = manager
        //binding.listRecipes.adapter = adapter


        observeEvents()
        homeViewModel.getRecipes()
    }

    fun filterData(query:String){
        var items_filtered :ArrayList<RecipesModel>? = arrayListOf()

        adapter.updateList(items_filtered as ArrayList<RecipesModel>)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }


    private fun observeEvents() {
        homeViewModel.listRecipes.observe(viewLifecycleOwner) {
            if (it.data!!.recipes!=null) {
                localData = it.data.recipes
                adapter.updateList(it.data.recipes)
            }

        }
    }
}
