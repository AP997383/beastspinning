package com.adolfoponce.spinning.presentation.ui.profile

import android.content.Context
import android.graphics.Color
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import androidx.core.content.ContextCompat
import androidx.core.graphics.drawable.toBitmap
import androidx.fragment.app.DialogFragment
import com.adolfoponce.spinning.R
import com.adolfoponce.spinning.databinding.BottomSheetShareQrBinding
import com.github.alexzhirkevich.customqrgenerator.vector.QrCodeDrawable
import com.github.alexzhirkevich.customqrgenerator.vector.createQrVectorOptions
import com.github.alexzhirkevich.customqrgenerator.vector.style.QrVectorBallShape
import com.github.alexzhirkevich.customqrgenerator.vector.style.QrVectorColor
import com.github.alexzhirkevich.customqrgenerator.vector.style.QrVectorFrameShape
import com.github.alexzhirkevich.customqrgenerator.vector.style.QrVectorLogoPadding
import com.github.alexzhirkevich.customqrgenerator.vector.style.QrVectorLogoShape
import com.github.alexzhirkevich.customqrgenerator.vector.style.QrVectorPixelShape
import com.google.android.material.bottomsheet.BottomSheetBehavior
import com.google.android.material.bottomsheet.BottomSheetDialog
import com.google.android.material.bottomsheet.BottomSheetDialogFragment
import java.util.*

class ZCCBottomSheetDialogShare : BottomSheetDialogFragment() {
    private lateinit var vBinding: BottomSheetShareQrBinding
    private lateinit var mContext: Context
    private lateinit var mView: View
    private var businessCard = ""
    private val options by lazy {
        createQrVectorOptions {

            padding = .325f

            fourthEyeEnabled = true


            logo {
                drawable = ContextCompat
                    .getDrawable(requireActivity(), R.drawable.beast)
                size = .25f
                padding = QrVectorLogoPadding.Natural(.2f)
                shape = QrVectorLogoShape
                    .Circle
            }
            colors {
                dark = QrVectorColor
                    .Solid(Color.parseColor("#000000"))
            }
            shapes {
                darkPixel = QrVectorPixelShape
                    .RoundCorners(.5f)
                ball = QrVectorBallShape
                    .RoundCorners(.25f)
                frame = QrVectorFrameShape
                    .RoundCorners(.25f)
            }
        }
    }
    companion object {
        fun newInstance(context: Context, parseColor: Int) = ZCCBottomSheetDialogShare().apply {
            mContext = context
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setStyle(DialogFragment.STYLE_NORMAL, R.style.zc_style_fast_reservation)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        dialog?.setOnShowListener { dialog ->
            val d = dialog as BottomSheetDialog
            val bottomSheet = d.findViewById<View>(com.google.android.material.R.id.design_bottom_sheet) as FrameLayout
            val bottomSheetBehavior = BottomSheetBehavior.from(bottomSheet)
            bottomSheetBehavior.state = BottomSheetBehavior.STATE_EXPANDED
            bottomSheetBehavior.peekHeight = bottomSheet.height
        }

        vBinding = BottomSheetShareQrBinding.inflate(layoutInflater)
        vBinding.qrUser.setImageBitmap(
            QrCodeDrawable( { "ksjaksjaksjkajskajska" }, options)
                .toBitmap(1024, 1024),
        )
        mView = vBinding.root
        return mView
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        init()
    }

    private fun init() {
        isCancelable = true

    }





}