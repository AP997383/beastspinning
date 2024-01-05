package com.adolfoponce.spinning.presentation.ui.login

import android.graphics.Color
import android.os.Build
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.adolfoponce.spinning.R
import com.adolfoponce.spinning.databinding.FragmentFeedBinding
import com.adolfoponce.spinning.databinding.FragmentLoginBinding
import com.adolfoponce.spinning.domain.model.DayMontWeekModel
import com.adolfoponce.spinning.domain.model.RecipesModel
import com.adolfoponce.spinning.presentation.ui.feed.adapter.FeedAdapter
import com.adolfoponce.spinning.presentation.ui.profile.ZCCBottomSheetDialogShare
import com.github.alexzhirkevich.customqrgenerator.vector.createQrVectorOptions
import com.github.alexzhirkevich.customqrgenerator.vector.style.QrVectorBallShape
import com.github.alexzhirkevich.customqrgenerator.vector.style.QrVectorColor
import com.github.alexzhirkevich.customqrgenerator.vector.style.QrVectorFrameShape
import com.github.alexzhirkevich.customqrgenerator.vector.style.QrVectorLogoPadding
import com.github.alexzhirkevich.customqrgenerator.vector.style.QrVectorLogoShape
import com.github.alexzhirkevich.customqrgenerator.vector.style.QrVectorPixelShape
import java.text.SimpleDateFormat
import java.util.*
import kotlin.collections.ArrayList

class LoginFragment  : Fragment() {


    private var _binding: FragmentLoginBinding? = null
   // private val homeViewModel by activityViewModels<HomeViewModel>()
    lateinit var adapter: FeedAdapter
    var localData:ArrayList<RecipesModel> = arrayListOf()

    private var seats = (
                    "/_AAA" +
                    "/AAAA" +
                    "/UUAA" +
                    "/AAAA" +
                    "/_UAA"
            )


    private var title = listOf(
        "/", "", "B1", "C1", "D1",
        "/", "A1", "B2", "C2", "D2",
        "/", "A2", "B3", "C3", "D3",
        "/", "A3", "B4", "C4", "D4",
        "/", "C1", "B5", "C5", "C5",
        "/", "D1", "B6", "C6", "D3", "D4",
        "/", "E1", "E2", "", "E3", "E4",
        "/", "F1", "F2", "", "F3", "F4",
        "/", "G1", "G2", "", "G3", "G4",
        "/", "C1", "C2", "", "C3", "C4",
        "/", "D1", "D2", "", "D3", "D4",
        "/", "E1", "E2", "", "E3", "E4",
        "/", "F1", "F2", "", "F3", "F4",
        "/", "G1", "G2", "", "G3", "G4",
        "/", "H1", "H2", "H3", "H4", "H5"
    )


    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentLoginBinding.inflate(inflater, container, false)
        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
               with(binding){
                   buttonLoginCreateAccount.setOnClickListener {
                       findNavController().navigate(R.id.action_loginFragment_to_registerFragment)
                   }
               }
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
        Log.e("DATA_WEEK","-->"+WEEK.toString() +"/" + domingo)
        return DayMontWeekModel(WEEK.toString(), domingo,"")
    }
}
