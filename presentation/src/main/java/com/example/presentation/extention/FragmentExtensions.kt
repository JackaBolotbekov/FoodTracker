package com.example.presentation.extention

import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
import com.example.presentation.R

fun Fragment.mainNavController() = requireActivity().findNavController(R.id.nav_host_fragment)