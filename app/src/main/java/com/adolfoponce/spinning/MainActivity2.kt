package com.adolfoponce.spinning

import android.os.Bundle
import android.view.Gravity
import android.view.Menu
import android.view.View
import androidx.activity.viewModels
import com.google.android.material.snackbar.Snackbar
import com.google.android.material.navigation.NavigationView
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.navigateUp
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import androidx.drawerlayout.widget.DrawerLayout
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.PopupMenu
import com.adolfoponce.spinning.databinding.ActivityMain2Binding
import com.adolfoponce.spinning.domain.repository.HomeRepository
import com.adolfoponce.spinning.presentation.base.SessionActivity
import com.adolfoponce.spinning.presentation.di.ActivitiesComponent
import com.adolfoponce.spinning.presentation.di.DaggerActivitiesComponent
import com.adolfoponce.spinning.presentation.di.factory.HomeViewModelFactory
import com.adolfoponce.spinning.presentation.model.HomeViewModel
import com.google.firebase.FirebaseApp
import javax.inject.Inject

class MainActivity2  : SessionActivity<HomeViewModel>() {
    @Inject
    lateinit var homeRepository: HomeRepository
    private lateinit var appBarConfiguration: AppBarConfiguration
    private lateinit var binding: ActivityMain2Binding
    val homeViewModel by viewModels<HomeViewModel> {
        ////private val homeViewModel by viewModels<HomeViewModel> {
        HomeViewModelFactory(
            homeRepository,
            this,
            intent.extras
        )
    }
    override val baseViewModel: HomeViewModel
        get() = homeViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        FirebaseApp.initializeApp(this);
        initInjection()
        super.onCreate(savedInstanceState)

        binding = ActivityMain2Binding.inflate(layoutInflater)
        setContentView(binding.root)
        //window.getDecorView().setLayoutDirection(View.LAYOUT_DIRECTION_RTL);
      //  setSupportActionBar(binding.appBarMain.toolbar)


        val drawerLayout: DrawerLayout = binding.drawerLayout
        val navView: NavigationView = binding.navView
        val navController = findNavController(R.id.nav_host_fragment_content_main)
       binding.bottomBarx.setupWithNavController(navController)
        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.
        appBarConfiguration = AppBarConfiguration(
            setOf(
                R.id.nav_home, R.id.nav_gallery, R.id.nav_slideshow
            ), drawerLayout
        )
        navView.right
       // setupActionBarWithNavController(navController, appBarConfiguration)
        navView.setupWithNavController(navController)

        binding.contentMain.openSideBar.setOnClickListener {
            drawerLayout.openDrawer(Gravity.LEFT)
        }
    }


    override fun onSupportNavigateUp(): Boolean {
        val navController = findNavController(R.id.nav_host_fragment_content_main)
        return navController.navigateUp(appBarConfiguration) || super.onSupportNavigateUp()
    }

    private fun initInjection() {
        val component = DaggerActivitiesComponent.builder()
            .applicationComponent(YapeApp.applicationComponent)
            .build()
        component.inject(this)
    }

}