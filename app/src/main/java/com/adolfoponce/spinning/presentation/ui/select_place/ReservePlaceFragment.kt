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
import androidx.viewbinding.ViewBinding
import com.adolfoponce.spinning.R
import com.adolfoponce.spinning.databinding.FragmentSelectPlaceBinding
import com.adolfoponce.spinning.databinding.ItemCustomFixedSizeLayout3Binding
import com.adolfoponce.spinning.databinding.ItemCustomFixedSizeLayout4Binding
import com.adolfoponce.spinning.domain.model.DayMontWeekModel
import com.adolfoponce.spinning.domain.model.RecipesModel
import com.adolfoponce.spinning.presentation.ui.feed.adapter.FeedAdapter
import com.adolfoponce.spinning.utils.ui.carrousel.listener.CarouselListener
import java.text.SimpleDateFormat
import java.util.*
import kotlin.collections.ArrayList

class ReservePlaceFragment  : Fragment() {

    private var _binding: FragmentSelectPlaceBinding? = null
   // private val homeViewModel by activityViewModels<HomeViewModel>()
    lateinit var adapter: FeedAdapter
    var localData:ArrayList<RecipesModel> = arrayListOf()

    private var seats = arrayListOf<String>(
        "/", "A", "A", "A", "A",
        "/", "A", "A", "A", "A",
        "/", "A", "A", "A", "A",
        "/", "A", "A", "A", "A",
        "/", "A", "A", "A", "A",
        "/", "A", "A", "A", "A"
    )

    private var title = listOf(
        "/", "", "1", "2", "3",
        "/", "4", "5", "6", "7",
        "/", "8", "9", "10", "11",
        "/", "12", "13", "14", "15",
        "/", "16", "17", "18", "19",
        "/", "20", "21", "22", "23", "24",
        "/", "20", "21", "22", "23", "24",
        "/", "20", "21", "22", "23", "24",
        "/", "20", "21", "22", "23", "24",
        "/", "20", "21", "22", "23", "24"
    )


    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentSelectPlaceBinding.inflate(inflater, container, false)
        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        var contador_por_fila = 0
        var numero_mayor =0
        var occurrences = Collections.frequency(seats, "/")
        for(letter:String in seats){
            if(letter.equals("/")) {
                if(numero_mayor < contador_por_fila)
                    numero_mayor = contador_por_fila
                contador_por_fila = 0
            }

            contador_por_fila ++

        }
        var size_elements = 5
        when(numero_mayor){
            1->size_elements =6
            2->size_elements =6
            3->size_elements =6
            4->size_elements =6
            5->size_elements =6
            6->size_elements =6
            7->size_elements =6
            8->size_elements =7
            9->size_elements =8
            10->size_elements =9
            11->size_elements =10
            12->size_elements =11
            13->size_elements =12
            else->size_elements =3

        }
        Log.e("SIZE_ELEMENTS","->>"+size_elements +"/"+numero_mayor)
        binding.layoutSeat.setSeatsLayoutString(seats)
            .isCustomTitle(true)
            .setCustomTitle(title)
            .setSeatLayoutPadding(2)
            .setSeatSizeBySeatsColumnAndLayoutWidth(size_elements, -1)
        binding.layoutSeat.show()


        binding.layoutSeat.getSeatView(2).apply {
            binding.layoutSeat.markAsTransparentSeat(this as TextView)
            this.setBackgroundResource(R.drawable.ic_teacher)
            this.setPadding(5)
        }

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
        return DayMontWeekModel(WEEK.toString(), domingo,"")
    }
}
