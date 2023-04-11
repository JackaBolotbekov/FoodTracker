package com.example.presentation.ui.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import by.kirich1409.viewbindingdelegate.viewBinding
import com.example.domain.repository.SharedRepository
//import com.example.foodtracker.PreferencesHelper
import com.example.presentation.R
import com.example.presentation.databinding.ActivityMainBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity(R.layout.activity_main) {

    private val binding by viewBinding(ActivityMainBinding::bind)
    private lateinit var navController: NavController
//    private val userRepository by lazy(LazyThreadSafetyMode.NONE) {
//       SharedRepositoryImpl(userStorage = SharedPrefUserStorage(context = applicationContext))
//    }
//
//    private val getUserNameUseCase by lazy(LazyThreadSafetyMode.NONE) {
//        GetUserNameUseCase(userRepository)
//    }
//
//    private val saveUserNameUseCase by lazy(LazyThreadSafetyMode.NONE) {
//        SaveUserNameUseCase(userRepository)
//    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        setupNavigation()
    }

    private fun setupNavigation() {
        val navHostFragment =
            supportFragmentManager.findFragmentById(R.id.nav_host_fragment) as NavHostFragment
        navController = navHostFragment.navController
        navController.navInflater.inflate(R.navigation.nav_graph)

        when {
//            PreferencesHelper.showOnBoard -> {
//                navController.navigate(R.id.logInFragment)
//            }
            else -> {
                navController.navigate(R.id.pagerFragment)
            }
        }
    }
}
