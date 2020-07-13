package com.example.a13_homeless.view.dest.standard

import android.os.Bundle
import android.widget.Toast
import androidx.core.os.bundleOf
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.NavController
import androidx.navigation.Navigation
import androidx.navigation.fragment.findNavController
import com.example.a13_homeless.R
import com.example.a13_homeless.view.adapter.TabPageAdapter
import com.example.a13_homeless.view.viewbase.FragmentBase
import com.example.a13_homeless.databinding.FragmentMainBinding
import com.example.a13_homeless.view.usersearch.UserSearch
import com.example.a13_homeless.viewmodel.UserViewModel
import com.google.android.material.tabs.TabLayoutMediator
import kotlinx.android.synthetic.main.fragment_main.*
import androidx.lifecycle.Observer


class MainFragment : FragmentBase<FragmentMainBinding>(R.layout.fragment_main) {

    lateinit var navController: NavController

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        setupToolbar()
        setViewPagerAdapter()

        navController = Navigation.findNavController(requireActivity(), R.id.navHostFragment)
    }

    private fun setViewPagerAdapter() {
        binding.apply {
            viewPager.adapter =
                TabPageAdapter(this@MainFragment)

            TabLayoutMediator(tabLayout, viewPager) { tab, position ->
                when (position) {
                    0 -> tab.text = "USERS"
                    1 -> tab.text = "ISSEUS"
                }
            }.attach()
        }
    }

    private fun setupToolbar() = with(binding.toolbar) {
        title = "검색기능 추가예정"
        setNavigationIcon(R.drawable.ic_arrow_back_black_24dp)
        setNavigationOnClickListener {
           requireActivity().finish()
        }
    }




}
