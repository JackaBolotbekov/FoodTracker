package com.example.presentation.ui.fragments.login

import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import by.kirich1409.viewbindingdelegate.viewBinding
import com.example.domain.models.SaveUserParams
import com.example.presentation.R
import com.example.presentation.base.BaseFragment
import com.example.presentation.databinding.FragmentLogInBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class LogInFragment : BaseFragment<FragmentLogInBinding, LogInViewModel>(R.layout.fragment_log_in) {

    override val binding by viewBinding(FragmentLogInBinding::bind)
    override val viewModel: LogInViewModel by viewModels()
//    private lateinit var userParams: SaveUserParams


    override fun initialize() {
        initial()
    }

    override fun setupListeners() {
        setOnClickListeners()
    }

    private fun initial() {
//        userParams.booleanLogIn = true
    }

    private fun setOnClickListeners() = with(binding) {
        val text = etLogin.text
        btnSkip.setOnClickListener {
            if (text.length >= 5) {
                findNavController().navigate(R.id.action_logInFragment_to_homeFragment)
            } else if (text.isEmpty()) {
                etLogin.error = "Заолните поле"
            }
            else {
                etLogin.error = "Слишком короткое имя"
            }
        }
    }
}