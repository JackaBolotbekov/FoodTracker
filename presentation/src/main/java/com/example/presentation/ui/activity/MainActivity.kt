package com.example.presentation.ui.activity

import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.annotation.RequiresApi
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import by.kirich1409.viewbindingdelegate.viewBinding
import com.example.presentation.R
import com.example.presentation.databinding.ActivityMainBinding
import com.example.presentation.ui.fragments._notifycation.setAlarmService
import dagger.hilt.android.AndroidEntryPoint
import java.util.*

@AndroidEntryPoint
class MainActivity : AppCompatActivity(R.layout.activity_main) {

    private val binding by viewBinding(ActivityMainBinding::bind)
    private val viewModel: MainActivityViewModel by viewModels()
    private lateinit var navController: NavController

    @RequiresApi(Build.VERSION_CODES.O)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val progress = viewModel.progressKcal
        val userName = viewModel.userName
        setContentView(binding.root)
        setAlarmService(userName, progress)
        setupNavigation()
    }

    private fun setupNavigation() {
        val navHostFragment =
            supportFragmentManager.findFragmentById(R.id.nav_host_fragment) as NavHostFragment
        navController = navHostFragment.navController
        navController.navInflater.inflate(R.navigation.nav_graph)

        when (viewModel.showLogIn){
            true -> {
                navController.navigate(R.id.action_logInFragment_to_homeFragment)
            }
            else -> {
                navController.navigate(R.id.pagerFragment)
            }
        }
    }
}