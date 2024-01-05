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
import androidx.recyclerview.widget.LinearLayoutManager
import com.adolfoponce.spinning.R
import com.adolfoponce.spinning.databinding.FragmentFeedBinding
import com.adolfoponce.spinning.databinding.FragmentRegisterBinding
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

class RegisterFragment  : Fragment() {


    private var _binding: FragmentRegisterBinding? = null
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
        _binding = FragmentRegisterBinding.inflate(inflater, container, false)
        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        adapter = FeedAdapter(requireContext(), arrayListOf()) {

        }
    }


    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }


}
