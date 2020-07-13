package com.example.a13_homeless.View.dest.standard

import android.os.Bundle
import androidx.navigation.NavController
import androidx.navigation.Navigation
import com.example.a13_homeless.R
import com.example.a13_homeless.View.adapter.TabPageAdapter
import com.example.a13_homeless.View.viewbase.FragmentBase
import com.example.a13_homeless.databinding.FragmentMainBinding
import com.google.android.material.tabs.TabLayoutMediator
import kotlinx.android.synthetic.main.fragment_main.*


class MainFragment : FragmentBase<FragmentMainBinding>(R.layout.fragment_main) {

    lateinit var navController: NavController

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        setupToolbar()
        setviewPagerAdapter()

        navController = Navigation.findNavController(requireActivity(), R.id.navHostFragment)
    }

    private fun setviewPagerAdapter() {
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
