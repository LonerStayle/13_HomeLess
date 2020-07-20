package com.example.a13_homeless.view.dest.standard

import android.os.Bundle
import android.util.Log
import androidx.core.os.bundleOf
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import com.example.a13_homeless.R
import com.example.a13_homeless.view.adapter.UsersAdapter
import com.example.a13_homeless.view.viewbase.FragmentBase
import com.example.a13_homeless.databinding.FragmentUsersBinding
import com.example.a13_homeless.view.const.Contents


class FragmentUsers : FragmentBase<FragmentUsersBinding>(R.layout.fragment_users) {


    override fun FragmentUsersBinding.setEventListener() {
        showList()
        setRecyclerViewAdapter()
        userListObserver()

    }

    /**
     * 람다 함수를 쓰는 이유
     */
    private fun setRecyclerViewAdapter() {

        binding.apply {
            recyclerVIewUserList.adapter = UsersAdapter(viewModel = viewModel) { user ->
                user?.let { user ->
                    user.login?.let { userID ->
                        findNavController().navigate(
                            MainFragmentDirections.actionStandardToDetail(userID)
                        )
                    }
                }
            }
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



}

