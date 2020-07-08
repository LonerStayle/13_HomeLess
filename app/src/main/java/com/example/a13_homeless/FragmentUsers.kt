package com.example.a13_homeless

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import com.example.a13_homeless.databinding.FragmentUsersBinding


class FragmentUsers : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? =
        DataBindingUtil.inflate<FragmentUsersBinding>(inflater, R.layout.fragment_users,
            container,false).run {


            root
        }

}
