//package com.example.presentation.ui.activity
//
//import android.content.Intent
//import android.os.Bundle
//import androidx.appcompat.app.AppCompatActivity
//import by.kirich1409.viewbindingdelegate.viewBinding
//import com.example.presentation.R
//import com.example.presentation.databinding.ActivitySplashScreenBinding
//import dagger.hilt.android.AndroidEntryPoint
//
//@AndroidEntryPoint
//class SplashScreenActivity : AppCompatActivity(R.layout.activity_splash_screen) {
//
//    private val binding by viewBinding(ActivitySplashScreenBinding::bind)
//
//    override fun onCreate(savedInstanceState: Bundle?) {
//        super.onCreate(savedInstanceState)
//        setContentView(binding.root)
//
//        binding.image.alpha = 0f
//        binding.image.animate().setDuration(1500).alpha(1f).withEndAction {
//            val i = Intent(this, MainActivity::class.java)
//            startActivity(i)
//            overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out)
//        }
//    }
//}