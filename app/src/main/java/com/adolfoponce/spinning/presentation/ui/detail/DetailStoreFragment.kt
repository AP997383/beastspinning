package com.adolfoponce.spinning.presentation.ui.detail

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.adolfoponce.spinning.databinding.FragmentDetailStoreBinding
import com.adolfoponce.spinning.domain.model.RecipesModel
import com.adolfoponce.spinning.presentation.model.HomeViewModel
import com.adolfoponce.spinning.presentation.ui.feed.adapter.FeedAdapter

class DetailStoreFragment  : Fragment() {

    private var _binding: FragmentDetailStoreBinding? = null
    private val homeViewModel by activityViewModels<HomeViewModel>()
    lateinit var adapter: FeedAdapter
    var localData:ArrayList<RecipesModel> = arrayListOf()

    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentDetailStoreBinding.inflate(inflater, container, false)
        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        adapter = FeedAdapter(requireContext(), arrayListOf()) {
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

       // adapter.updateList(items_filtered as ArrayList<RecipesModel>)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }


    private fun observeEvents() {
        homeViewModel.listRecipes.observe(viewLifecycleOwner) {
            if (it.data!!.recipes!=null) {
                localData = it.data.recipes
              //  adapter.updateList(it.data.recipes)
            }

        }
    }
}
