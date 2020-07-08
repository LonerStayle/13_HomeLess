package com.example.a13_homeless.View.dest

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import com.example.a13_homeless.R
import com.example.a13_homeless.databinding.FragmentRepositoriesBinding

class FragmentRepositories : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? = DataBindingUtil.inflate<FragmentRepositoriesBinding>(
        inflater,
        R.layout.fragment_repositories,
        container,
        false
    ).run {


        root
    }
}