package com.adolfoponce.spinning.presentation.ui.settingStores

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.adolfoponce.spinning.databinding.FragmentSettingStoreBinding
import com.adolfoponce.spinning.domain.model.RecipesModel
import com.adolfoponce.spinning.presentation.model.HomeViewModel
import com.adolfoponce.spinning.presentation.ui.feed.adapter.FeedAdapter

class SettingStoreFragment  : Fragment() {

    private var _binding: FragmentSettingStoreBinding? = null
    private val homeViewModel by activityViewModels<HomeViewModel>()
    lateinit var adapter: FeedAdapter
    var localData:ArrayList<RecipesModel> = arrayListOf()

    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentSettingStoreBinding.inflate(inflater, container, false)
        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        adapter = FeedAdapter(requireContext(), arrayListOf()) {
            var action = SettingStoreFragmentDirections.actionSettingStoreFragmentToDetailStoreFragment()
            findNavController().navigate(action)
        }

        var manager = LinearLayoutManager(requireContext(), LinearLayoutManager.VERTICAL,false)
        binding.historyClasses.layoutManager = manager
        binding.historyClasses.adapter = adapter


        observeEvents()
        homeViewModel.getCategories()
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
        homeViewModel.listCategories.observe(viewLifecycleOwner) {
            if (it.data!!.items!=null) {
               // localData = it.data.items
                 adapter.updateList(it.data.items)
            }

        }
    }
}
