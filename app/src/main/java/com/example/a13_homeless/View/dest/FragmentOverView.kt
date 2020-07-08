package com.example.a13_homeless.View.dest

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import com.example.a13_homeless.R
import com.example.a13_homeless.databinding.FragmentOverViewBinding

class FragmentOverView : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? = DataBindingUtil.inflate<FragmentOverViewBinding>(
        inflater,
        R.layout.fragment_over_view,
        container,
        false
    ).run {

        root
    }

}
