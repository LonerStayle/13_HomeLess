package com.example.a13_homeless.view.dest.detail

import android.os.Bundle
import androidx.activity.addCallback
import androidx.navigation.NavArgs
import androidx.navigation.findNavController
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.example.a13_homeless.R
import com.example.a13_homeless.view.adapter.DetailTabPageAdapter
import com.example.a13_homeless.view.viewbase.FragmentBase
import com.example.a13_homeless.databinding.FragmentDetailBinding
import com.example.a13_homeless.view.usersearch.UserSearch
import com.google.android.material.tabs.TabLayoutMediator


class FragmentDetail : FragmentBase<FragmentDetailBinding>(R.layout.fragment_detail) {

  private val args by lazy {FragmentDetailArgs.fromBundle(requireArguments())}

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        setViewPagerAdapter()
        setToolbar()
        backButton()
    }

    private fun setViewPagerAdapter() {
        binding.apply {
            viewPagerDetail.adapter = DetailTabPageAdapter(this@FragmentDetail)

            TabLayoutMediator(tabLayoutDetail, viewPagerDetail) { tab, position ->
                when (position) {
                    0 -> tab.text = "OVER VIEW"
                    1 -> tab.text = "Repositories"
                    2 -> tab.text = "Starred"
                }
            }
        }

    }

    private fun setToolbar() = with(binding.toolbarDetail) {

        title = args.userSearch
        setNavigationIcon(R.drawable.ic_arrow_back_black_24dp)
        setNavigationOnClickListener {
            findNavController().navigate(R.id.action_detail_to_standard)

        }

    }
    private fun backButton() {
        requireActivity().onBackPressedDispatcher.addCallback(this) {
            findNavController().navigate(R.id.action_detail_to_standard)
        }
    }
}
