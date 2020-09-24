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
import com.example.a13_homeless.api.repository.GithubRepository
import com.example.a13_homeless.viewmodel.UserViewModel
import com.example.a13_homeless.viewmodel.UserViewModelFactory

abstract class FragmentBase<B : ViewDataBinding>(@LayoutRes private val layoutRes: Int) :
    Fragment() {
    protected val viewModel by lazy {
        val githubRepository =GithubRepository()
        ViewModelProvider(this,UserViewModelFactory(githubRepository)).get(
            UserViewModel::class.java
        )
    }
    protected lateinit var binding: B

    open fun B.setupViewModel() = Unit

    open fun B.setDatabinding() = Unit

    open fun B.setEventListener() = Unit

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? = DataBindingUtil.inflate<B>(
        inflater,
        layoutRes,
        container,
        false
    ).run {
        binding = this

        lifecycleOwner = viewLifecycleOwner

        setupViewModel()
        setDatabinding()
        setEventListener()

        root
    }
//    {
//        binding = DataBindingUtil.inflate<B>(inflater, layoutRes, container, false).apply {
//
//            lifecycleOwner = viewLifecycleOwner
//
//        }
//
//        setupViewModel()
//        setDatabinding()
//        setEventListener()
//
//        return binding.root
//    }
}