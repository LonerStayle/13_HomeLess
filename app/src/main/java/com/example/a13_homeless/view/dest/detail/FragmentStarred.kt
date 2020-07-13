package com.example.a13_homeless.view.dest.detail

import android.os.Bundle
import com.example.a13_homeless.R
import com.example.a13_homeless.view.viewbase.FragmentBase
import com.example.a13_homeless.databinding.FragmentStarredBinding
import com.example.a13_homeless.view.adapter.RepoAdapter
import com.example.a13_homeless.view.usersearch.UserSearch
import androidx.lifecycle.Observer
import com.example.a13_homeless.view.adapter.StarredAdapter

class FragmentStarred : FragmentBase<FragmentStarredBinding>(R.layout.fragment_starred) {


    private val args by lazy{arguments?.getString(UserSearch.USER_SEARCH)?:""}

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        setAdapter()
        observer()
        showList()
    }

    private fun setAdapter() {
        binding.recyclerViewStarred.adapter = RepoAdapter()
    }

    private fun observer() {
        viewModel.starredList.observe(viewLifecycleOwner, Observer {
            (binding.recyclerViewStarred.adapter as StarredAdapter).run {
                starredList = it
                notifyDataSetChanged()
            }
        })
    }

    private fun showList() {
        viewModel.getStarred(args)
    }

}
