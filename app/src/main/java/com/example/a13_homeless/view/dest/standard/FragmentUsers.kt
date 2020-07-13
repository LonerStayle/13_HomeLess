package com.example.a13_homeless.view.dest.standard

import android.os.Bundle
import android.widget.Toast
import androidx.core.os.bundleOf
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.example.a13_homeless.R
import com.example.a13_homeless.view.adapter.UsersAdapter
import com.example.a13_homeless.view.viewbase.FragmentBase
import com.example.a13_homeless.databinding.FragmentUsersBinding
import com.example.a13_homeless.view.usersearch.UserSearch
import com.example.a13_homeless.viewmodel.UserViewModel


class FragmentUsers : FragmentBase<FragmentUsersBinding>(R.layout.fragment_users) {

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        setRecyclerViewAdapter()

        showList()
        setRecyclerViewAdapter()
        userListObserver()
        userObserve()
    }

    private fun setRecyclerViewAdapter() {
        binding.apply {
            recyclerVIewUserList.adapter = UsersAdapter(viewModel = viewModel)
        }
    }

    private fun showList() {
        viewModel.getUserList()
    }

    private fun userListObserver() {

        viewModel.userList.observe(viewLifecycleOwner, Observer {
            (binding.recyclerVIewUserList.adapter as UsersAdapter).run {
                userList = it
                notifyDataSetChanged()
            }
        })

    }

    private fun userObserve() {
        viewModel.userData.observe(viewLifecycleOwner, Observer {

            bundleOf(
                UserSearch.USER_SEARCH to it.login
            )

            findNavController().navigate(MainFragmentDirections.actionStandardToDetail(
                userSearch = it.login!!))
        })
    }
}

