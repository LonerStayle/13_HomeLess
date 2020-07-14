package com.example.a13_homeless.view.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.a13_homeless.R
import com.example.a13_homeless.databinding.ViewholderUserBinding
import com.example.a13_homeless.api.dataholder.User
import com.example.a13_homeless.viewmodel.UserViewModel


class UsersAdapter(
    var userList: List<User> = listOf(),
var viewModel: UserViewModel
) : RecyclerView.Adapter<UsersAdapter.ViewHolder>() {

    inner class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val binding = DataBindingUtil.bind<ViewholderUserBinding>(view)

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder =
        ViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.viewholder_user, parent, false)
        )

    override fun getItemCount(): Int = userList.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.binding?.user = userList[position]

        holder.itemView.setOnClickListener {
            viewModel.userValueToDetail(holder.binding?.user)

        }


    }

}
