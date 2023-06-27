package com.adolfoponce.spinning.presentation.ui.settingStores

import android.Manifest
import android.content.pm.PackageManager
import android.os.Bundle
import androidx.navigation.findNavController
import androidx.activity.viewModels
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import com.adolfoponce.spinning.R
import com.adolfoponce.spinning.YapeApp
import com.adolfoponce.spinning.databinding.ActivityMainBinding
import com.adolfoponce.spinning.databinding.ActivitySettingsStoreBinding
import com.adolfoponce.spinning.domain.repository.HomeRepository
import com.adolfoponce.spinning.presentation.base.BaseViewModelActivity
import com.adolfoponce.spinning.presentation.di.DaggerActivitiesComponent
import com.adolfoponce.spinning.presentation.di.factory.HomeViewModelFactory
import com.adolfoponce.spinning.presentation.model.HomeViewModel
import javax.inject.Inject

class SettingsStoreActivity : BaseViewModelActivity<HomeViewModel>() {

    private lateinit var binding: ActivitySettingsStoreBinding
    var PERMISSIONS_REQUEST_ACCESS_FINE_LOCATION = 1
    var locationPermissionGranted:Boolean=false

    @Inject
    lateinit var homeRepository: HomeRepository

    val homeViewModel by viewModels<HomeViewModel> {
        HomeViewModelFactory(
            homeRepository,
            this,
            intent.extras,
        )
    }



    override val baseViewModel: HomeViewModel
        get() = homeViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        initInjection()
        super.onCreate(savedInstanceState)
        binding = ActivitySettingsStoreBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val navController = findNavController(R.id.nav_host_fragment_content_main)
       getLocationPermission()

    }

    override fun onRequestPermissionsResult(requestCode: Int,
                                            permissions: Array<String>,
                                            grantResults: IntArray) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)
        locationPermissionGranted = false
        when (requestCode) {
            PERMISSIONS_REQUEST_ACCESS_FINE_LOCATION -> {
                if (grantResults.isNotEmpty() &&
                    grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                    locationPermissionGranted = true
                }else{
                    /*DialogPermissionsGPS(object : DialogPermissionsGPS.onRequestLocationListener{
                        override fun onRequestLocation() {
                            getLocationPermission()
                        }

                    }).show(this.supportFragmentManager,"")*/
                }
            }
        }
    }

    private fun getLocationPermission() {
        if (ContextCompat.checkSelfPermission(this.applicationContext,
                Manifest.permission.ACCESS_FINE_LOCATION)
            == PackageManager.PERMISSION_GRANTED) {
            locationPermissionGranted = true
        } else {
            ActivityCompat.requestPermissions(this, arrayOf(Manifest.permission.ACCESS_FINE_LOCATION),PERMISSIONS_REQUEST_ACCESS_FINE_LOCATION)
        }
    }


    private fun initInjection() {
        val component = DaggerActivitiesComponent.builder()
            .applicationComponent(YapeApp.applicationComponent)
            .build()

        component.inject(this)
    }
}