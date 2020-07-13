package com.example.a13_homeless.View.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.a13_homeless.R
import com.example.a13_homeless.databinding.ViewholderUserBinding
import com.example.a13_homeless.api.dataholder.User
import com.example.a13_homeless.databinding.ViewholderIssueBinding
import kotlinx.android.synthetic.main.fragment_users.view.*


class IssuesAdapter(
    var issueList:List<String> = listOf()
) : RecyclerView.Adapter<IssuesAdapter.ViewHolder>() {

    inner class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val binding = DataBindingUtil.bind<ViewholderIssueBinding>(view)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder =
        ViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.viewholder_issue, parent, false)
        )

    override fun getItemCount(): Int = issueList.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

        holder.binding?.apply {
            issueText = issueList[position]
        }
    }
}
