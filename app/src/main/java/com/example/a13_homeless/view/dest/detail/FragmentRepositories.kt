package com.example.a13_homeless.view.dest.detail

import android.os.Bundle
import androidx.lifecycle.Observer
import com.example.a13_homeless.R
import com.example.a13_homeless.view.viewbase.FragmentBase
import com.example.a13_homeless.databinding.FragmentRepositoriesBinding
import com.example.a13_homeless.view.adapter.DetailTabPageAdapter
import com.example.a13_homeless.view.adapter.RepoAdapter
import com.example.a13_homeless.view.usersearch.UserSearch

class FragmentRepositories : FragmentBase<FragmentRepositoriesBinding>(R.layout.fragment_repositories) {

    private val args by lazy{arguments?.getString(UserSearch.USER_SEARCH)?:""}

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        setAdapter()
        observer()
        showList()
    }

    private fun setAdapter() {
            binding.recyclerViewRepos.adapter = RepoAdapter()
    }

    private fun observer() {
        viewModel.RepoList.observe(viewLifecycleOwner, Observer {
            (binding.recyclerViewRepos.adapter as RepoAdapter).run {
                repos = it
                notifyDataSetChanged()
            }
        })
    }

    private fun showList() {
        viewModel.getRepoList(args)
    }
}