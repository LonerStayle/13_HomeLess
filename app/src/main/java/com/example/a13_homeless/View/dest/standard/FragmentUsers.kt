package com.example.a13_homeless.View.dest.standard

import android.os.Bundle
import com.example.a13_homeless.R
import com.example.a13_homeless.View.adapter.UsersAdapter
import com.example.a13_homeless.View.viewbase.FragmentBase
import com.example.a13_homeless.databinding.FragmentUsersBinding


class FragmentUsers :FragmentBase<FragmentUsersBinding>(R.layout.fragment_users) {


    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        setRecyclerViewAdapter()
    }

    fun setRecyclerViewAdapter() {
        binding.apply {
            recycelrVIewUserList.adapter = UsersAdapter()
        }
    }
}
