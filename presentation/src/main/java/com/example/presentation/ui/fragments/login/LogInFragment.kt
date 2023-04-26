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

    private fun setOnClickListeners(    ) = with(binding) {
        val editText =
            etLogin.text // если здесь написать toString.trim, то код неккоректно работает
        val text = etLogin.text.toString().trim()
        btnSkip.setOnClickListener {
            if (editText.length >= 5) {
                viewModel.showLogIn = true
                findNavController().navigate(R.id.action_logInFragment_to_homeFragment)
            } else if (editText.isEmpty()) {
                etLogin.error = getString(R.string.add_field)
                Log.e("tag", editText.toString())
            } else {
                etLogin.error = getString(R.string.small_name)
            }
        }
    }
}