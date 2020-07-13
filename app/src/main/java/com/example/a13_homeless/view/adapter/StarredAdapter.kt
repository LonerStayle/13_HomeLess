package com.example.a13_homeless.view.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.a13_homeless.R
import com.example.a13_homeless.api.dataholder.UserRepo
import com.example.a13_homeless.databinding.ViewholderRepoBinding
import com.example.a13_homeless.databinding.ViewholderStarredBinding

class StarredAdapter(
    var starredList: List<UserRepo> = listOf()
) : RecyclerView.Adapter<StarredAdapter.ViewHolder>() {
    inner class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val binding = DataBindingUtil.bind<ViewholderStarredBinding>(view)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder =
        ViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.viewholder_starred, parent, false)
        )

    override fun getItemCount(): Int = starredList.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

        holder.binding?.apply {
            val repo = starredList[position]
            userStarred = repo
        }
    }
}