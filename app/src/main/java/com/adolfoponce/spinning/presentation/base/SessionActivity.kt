package com.adolfoponce.spinning.presentation.base
import android.os.Bundle
import android.util.Log
import java.text.SimpleDateFormat
import java.util.*

abstract class SessionActivity<T : BaseViewModel> : BaseViewModelActivity<T>() {



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onResume() {
        super.onResume()
    }

    override fun onUserInteraction() {
        super.onUserInteraction()
        val time = Calendar.getInstance().time
        val formatter = SimpleDateFormat("yyyy-MM-dd HH:mm:ss")
        val current = formatter.format(time)
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.e("TIME_CURRENT","-->CLEAR COUNTER")
    }




    open fun getDiferencia(fechaInicial: Date, fechaFinal: Date): Boolean {
        var diferencia = fechaFinal.time - fechaInicial.time
        val segsMilli: Long = 1000
        val minsMilli = segsMilli * 60
        val horasMilli = minsMilli * 60
        diferencia %= horasMilli
        val minutosTranscurridos = diferencia / minsMilli
        diferencia %= minsMilli
        val segsTranscurridos = diferencia / segsMilli
        Log.e("TIME_CURRENT","-->"+minutosTranscurridos +"/" + segsTranscurridos)
        if(minutosTranscurridos>10)
            return  true
       else return minutosTranscurridos==10L && segsTranscurridos > 1
    }




}