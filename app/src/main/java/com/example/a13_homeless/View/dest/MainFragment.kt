package com.example.a13_homeless.View.dest

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import com.example.a13_homeless.R
import com.example.a13_homeless.TabPageAdapter
import com.example.a13_homeless.databinding.FragmentMainBinding
import com.google.android.material.tabs.TabLayoutMediator


class MainFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? = DataBindingUtil.inflate<FragmentMainBinding>(
        inflater, R.layout.fragment_main,
        container, false
    ).run {

        viewPager.adapter = TabPageAdapter(this@MainFragment)

        TabLayoutMediator(tabLayout,viewPager){
            tab, position ->
            when (position) {
                0 -> tab.text = "USERS"
                1 -> tab.text = "ISSEUS"
            }
        }.attach()

        root
    }

}
