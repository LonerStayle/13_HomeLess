package com.example.a13_homeless.view.dest.detail

import android.os.Bundle
import com.example.a13_homeless.R
import com.example.a13_homeless.view.viewbase.FragmentBase
import com.example.a13_homeless.databinding.FragmentStarredBinding
import com.example.a13_homeless.view.adapter.RepoAndStarredAdapter
import com.example.a13_homeless.view.const.Contents
import androidx.lifecycle.Observer

/**
 * TODO: args 적용이 안됨
 */

class FragmentStarred : FragmentBase<FragmentStarredBinding>(R.layout.fragment_starred) {

    private val args by lazy{arguments?.getString(Contents.USER_SEARCH)?:""}

    override fun FragmentStarredBinding.setEventListener() {
        setAdapter()
        observer()
        showList()
    }

    private fun setAdapter() {
        binding.recyclerViewStarred.adapter = RepoAndStarredAdapter(adapterMode =
        Contents.USER_STARRED_ADAPTER)
    }

    private fun observer() {
        viewModel.starredList.observe(viewLifecycleOwner, Observer {
            (binding.recyclerViewStarred.adapter as RepoAndStarredAdapter).run {
                repos = it
                notifyDataSetChanged()
            }
        })
    }

    private fun showList() {
        viewModel.getStarred(args)
    }

}
