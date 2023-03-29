package com.example.presentation.base

import android.os.Bundle
import android.view.View
import androidx.annotation.LayoutRes
import androidx.fragment.app.Fragment
import androidx.viewbinding.ViewBinding

abstract class BaseFragment<VB : ViewBinding, VM : BaseViewModel>(@LayoutRes layoutId: Int) :
    Fragment(layoutId) {

    abstract val binding: VB
    abstract val viewModel: VM

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initialize()
        setupObserves()
        setupSubscribes()
        setupListeners()
    }

    protected open fun initialize() {
    }

    protected open fun setupObserves() {
    }

    protected open fun setupSubscribes() {
    }

    protected open fun setupListeners() {
    }
}