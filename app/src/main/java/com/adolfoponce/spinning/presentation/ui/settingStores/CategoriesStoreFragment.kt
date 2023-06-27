package com.adolfoponce.spinning.presentation.ui.settingStores

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.GridLayoutManager
import com.adolfoponce.spinning.databinding.FragmentCategoriesStoreBinding
import com.adolfoponce.spinning.domain.model.CategoriesModel
import com.adolfoponce.spinning.domain.model.RecipesModel
import com.adolfoponce.spinning.presentation.model.HomeViewModel
import com.adolfoponce.spinning.presentation.ui.feed.adapter.FeedAdapter

class CategoriesStoreFragment  : Fragment() {

    private var _binding: FragmentCategoriesStoreBinding? = null
    private val homeViewModel by activityViewModels<HomeViewModel>()
    lateinit var adapter: FeedAdapter
    var localData:ArrayList<RecipesModel> = arrayListOf()

    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentCategoriesStoreBinding.inflate(inflater, container, false)
        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        adapter = FeedAdapter(requireContext(), arrayListOf()) {
             var action = CategoriesStoreFragmentDirections.actionCategoriesFragmentToSettingStoreFragment()
             findNavController().navigate(action)
        }

        var manager = GridLayoutManager(requireContext(),2,GridLayoutManager.VERTICAL,false)
        binding.recyclerCategoriesStores.layoutManager = manager
        binding.recyclerCategoriesStores.adapter = adapter


        observeEvents()
        homeViewModel.getCategories()
    }

    fun filterData(query:String){
        var items_filtered :ArrayList<RecipesModel>? = arrayListOf()

        adapter.updateList(items_filtered as ArrayList<CategoriesModel>)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }


    private fun observeEvents() {
        homeViewModel.listCategories.observe(viewLifecycleOwner) {
            Log.e("XXXXXX","SS")
            if (it.data!!.items!=null) {
                Log.e("XXXXXX","!=NULL")
              //  localData = it.data.items
                adapter.updateList(it.data.items)
            }else{
                Log.e("XXXXXX","NULL")
            }

        }
    }
}
