package com.example.presentation.ui.fragments.login

import android.util.Log
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import by.kirich1409.viewbindingdelegate.viewBinding
import com.example.presentation.R
import com.example.presentation.base.BaseFragment
import com.example.presentation.databinding.FragmentLogInBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class LogInFragment : BaseFragment<FragmentLogInBinding, LogInViewModel>(R.layout.fragment_log_in) {

    override val binding by viewBinding(FragmentLogInBinding::bind)
    override val viewModel: LogInViewModel by viewModels()

    override fun setupListeners() {
        setOnClickListeners()
    }

    private fun setOnClickListeners() = with(binding) {
        val editText = etLogin.text // если здесь написать toString.trim, то код неккоректно работает
        btnSkip.setOnClickListener {
            val text = etLogin.text.toString().trim()
            if (editText.length >= 2) {
                viewModel.userName = text
                Log.d("TextView", "text = $text")
                findNavController().navigate(R.id.action_logInFragment_to_homeFragment)
                viewModel.showLogIn = true
            } else if (editText.isEmpty()) {
                etLogin.error = getString(R.string.add_field)
            } else {
                etLogin.error = getString(R.string.small_name)
            }
        }
    }
}