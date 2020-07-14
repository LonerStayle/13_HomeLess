package com.example.a13_homeless.view.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.a13_homeless.R
import com.example.a13_homeless.api.dataholder.UserRepo
import com.example.a13_homeless.databinding.ViewholderRepoandstarredBinding
import com.example.a13_homeless.view.const.Contents

class RepoAndStarredAdapter(
    var repos: List<UserRepo> = listOf(),
    var adapterMode: Int
) : RecyclerView.Adapter<RepoAndStarredAdapter.ViewHolder>() {
    inner class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val binding = DataBindingUtil.bind<ViewholderRepoandstarredBinding>(view)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder =
        ViewHolder(
            LayoutInflater.from(parent.context)
                .inflate(R.layout.viewholder_repoandstarred, parent, false)
        )

    override fun getItemCount(): Int = repos.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

        holder.binding?.apply {
            val repo = repos[position]

            eitherNameOrFullName =
                if (adapterMode == Contents.USER_REPO_ADAPTER)
                    repo.name
                else
                    repo.fullName

            userRepo = repo
        }
    }
}