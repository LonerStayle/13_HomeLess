package com.example.a13_homeless.view.viewbase

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.LayoutRes
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.example.a13_homeless.viewmodel.UserViewModel

abstract class FragmentBase<B : ViewDataBinding>(@LayoutRes private val layoutRes: Int) :
    Fragment() {
    protected val viewModel by lazy {
        ViewModelProvider(this).get(
            UserViewModel::class.java
        )
    }
    protected lateinit var binding: B

    open fun setupViewModel() = Unit

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate<B>(inflater, layoutRes, container, false).apply {

            lifecycleOwner = viewLifecycleOwner
            setupViewModel()

        }
        return binding.root
    }
}