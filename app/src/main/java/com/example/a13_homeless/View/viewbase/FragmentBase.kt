package com.example.a13_homeless.View.viewbase

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.LayoutRes
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.fragment.app.Fragment

abstract class FragmentBase<B : ViewDataBinding>(@LayoutRes private val layoutRes: Int) :
    Fragment() {

    lateinit var binding: B
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