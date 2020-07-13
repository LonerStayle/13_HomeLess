package com.example.a13_homeless.View.adapter

import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.example.a13_homeless.View.dest.standard.FragmentUsers
import com.example.a13_homeless.View.dest.standard.FragmentIsseus

class TabPageAdapter(fragment: Fragment) : FragmentStateAdapter(fragment) {

        companion object{
           const val INDEX_ISSEUS = 1
        }

    override fun getItemCount(): Int = 2

    override fun createFragment(position: Int): Fragment {

        return when (position) {
            INDEX_ISSEUS -> FragmentIsseus()
            else -> FragmentUsers()
        }
    }

}