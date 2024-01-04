package com.adolfoponce.spinning.presentation.ui.select_place

import android.os.Build
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.core.view.setPadding
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.viewbinding.ViewBinding
import com.adolfoponce.spinning.databinding.FragmentPreviewPlaceBinding
import com.adolfoponce.spinning.databinding.FragmentSelectPlaceBinding
import com.adolfoponce.spinning.databinding.ItemCustomFixedSizeLayout3Binding
import com.adolfoponce.spinning.databinding.ItemCustomFixedSizeLayout4Binding
import com.adolfoponce.spinning.domain.model.CategoriesModel
import com.adolfoponce.spinning.domain.model.DayMontWeekModel
import com.adolfoponce.spinning.domain.model.RecipesModel
import com.adolfoponce.spinning.presentation.ui.feed.adapter.FeedAdapter
import com.adolfoponce.spinning.presentation.ui.select_place.adapter.ListaClasesPorDiaAdapter
import com.adolfoponce.spinning.presentation.ui.settingStores.CategoriesStoreFragmentDirections
import com.adolfoponce.spinning.utils.ui.carrousel.listener.CarouselListener
import java.text.SimpleDateFormat
import java.util.*
import kotlin.collections.ArrayList

class PreviewPlaceFragment  : Fragment() {

    private var _binding: FragmentPreviewPlaceBinding? = null
   // private val homeViewModel by activityViewModels<HomeViewModel>()
    lateinit var adapter: ListaClasesPorDiaAdapter
    var localData:ArrayList<RecipesModel> = arrayListOf()


    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentPreviewPlaceBinding.inflate(inflater, container, false)
        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.carousel4.carouselListener = object : CarouselListener {
            override fun onCreateViewHolder(
                layoutInflater: LayoutInflater,
                parent: ViewGroup
            ): ViewBinding {
                return ItemCustomFixedSizeLayout3Binding.inflate(
                    layoutInflater,
                    parent,
                    false
                )
            }
            override fun onBindViewHolder(
                binding: ViewBinding,
                item: Any,
                position: Int
            ) {
                val currentBinding = binding as ItemCustomFixedSizeLayout3Binding
                if(item is DayMontWeekModel) {
                    var data  = item as DayMontWeekModel
                    currentBinding.monthPlace.text = data.month
                    currentBinding.dayPlace.text = data.day
                    currentBinding.dayOfWeekPlace.text = data.dayOfWeek
                }
            }
        }
adapter =ListaClasesPorDiaAdapter(requireActivity(), arrayListOf(CategoriesModel("",""),CategoriesModel("",""))){
    var action = PreviewPlaceFragmentDirections.actionReservePlaceFragmentToReservePlaceFragment2()
    findNavController().navigate(action)
}
        binding.listHorariosPearDay.adapter = adapter
        binding.listHorariosPearDay.layoutManager = LinearLayoutManager(requireContext(),LinearLayoutManager.VERTICAL,false)

        val listFour = mutableListOf<DayMontWeekModel>()
        val four = listOf(
            "Diciembre",
            "https://images.unsplash.com/photo-1618346136472-090de27fe8b4?w=1080",
            "https://images.unsplash.com/photo-1544179516-b0878e1cbe48?w=1080",
            "https://images.unsplash.com/photo-1620236104164-d2e71d7f4b1f?w=1080",
            "https://images.unsplash.com/photo-1470104240373-bc1812eddc9f?w=1080",
            "https://images.unsplash.com/photo-1619901373505-bb71126e5fbb?w=1080",
        )
        for (item in getDataList()) {
            listFour.add(
                DayMontWeekModel(
                    day = item.day,
                    month = item.month,
                    dayOfWeek = item.dayOfWeek
                )
            )
        }
         binding.carousel4.setData(listFour)
        observeEvents()
    }

    fun filterData(query:String){
        var items_filtered :ArrayList<RecipesModel>? = arrayListOf()

      //  adapter.updateList(items_filtered as ArrayList<RecipesModel>)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }


    private fun observeEvents() {
    }

    private fun getDataList(): java.util.ArrayList<DayMontWeekModel> {
        var lista = java.util.ArrayList<DayMontWeekModel>()
        val calendar = GregorianCalendar.getInstance()
        calendar.firstDayOfWeek = Calendar.SUNDAY
        calendar.minimalDaysInFirstWeek = 1

        if (Build.VERSION.SDK_INT <= Build.VERSION_CODES.M) {
            calendar.add(Calendar.DAY_OF_YEAR, -1)
        }
        for(i in calendar.get(Calendar.DAY_OF_MONTH) downTo 1){ //TODO el 5 Esta Hardcodeado a la semana del 1 de Febrero del 2022
                var customWeek =createWeekObject(i,calendar.get(Calendar.YEAR))
                lista.add(customWeek)
        }
        return lista
    }

    fun createWeekObject(customWeek:Int, customYear:Int ) : DayMontWeekModel{
        var WEEK = customWeek

        val cal = GregorianCalendar.getInstance()

        cal.firstDayOfWeek = Calendar.MONDAY
        cal.minimalDaysInFirstWeek = 0
        cal.clear()
        cal[Calendar.YEAR] = customYear

        val formatter = SimpleDateFormat("MMMM")
        val startDate = cal.time
        val domingo = formatter.format(startDate)

        val formatterDayWeek = SimpleDateFormat("E")
        val dayweek = formatterDayWeek.format(startDate)
        Log.e("DATA_WEEK","-->"+WEEK.toString() +"/" + domingo+"/"+dayweek)
        return DayMontWeekModel(WEEK.toString(), domingo,dayweek)
    }
}
