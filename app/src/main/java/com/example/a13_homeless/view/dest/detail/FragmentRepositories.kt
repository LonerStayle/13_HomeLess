package com.example.a13_homeless.view.dest.detail

import android.os.Bundle
import androidx.lifecycle.Observer
import androidx.navigation.fragment.navArgs
import com.example.a13_homeless.R
import com.example.a13_homeless.view.viewbase.FragmentBase
import com.example.a13_homeless.databinding.FragmentRepositoriesBinding
import com.example.a13_homeless.view.adapter.RepoAndStarredAdapter
import com.example.a13_homeless.view.const.Contents

/**
 * TODO: args 적용이 안됨
 */
class FragmentRepositories :
    FragmentBase<FragmentRepositoriesBinding>(R.layout.fragment_repositories) {
        private val args by lazy {Contents.userSearch}


    override fun FragmentRepositoriesBinding.setEventListener() {
        setAdapter()
        observer()
        showList()
    }

    private fun setAdapter() {
        binding.recyclerViewRepos.adapter =
            RepoAndStarredAdapter(adapterMode = Contents.USER_REPO_ADAPTER)
    }

    private fun observer() {
        viewModel.repoList.observe(viewLifecycleOwner, Observer {
            (binding.recyclerViewRepos.adapter as RepoAndStarredAdapter).run {
                repos = it
                notifyDataSetChanged()
            }
        })
    }

    private fun showList() {
        viewModel.getRepoList(args)

    }
}