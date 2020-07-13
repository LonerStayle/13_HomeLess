package com.example.a13_homeless.View.adapter

import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.example.a13_homeless.View.dest.detail.FragmentDetail
import com.example.a13_homeless.View.dest.detail.FragmentOverView
import com.example.a13_homeless.View.dest.detail.FragmentRepositories
import com.example.a13_homeless.View.dest.detail.FragmentStarred
import com.example.a13_homeless.View.dest.standard.FragmentUsers
import com.example.a13_homeless.View.dest.standard.FragmentIsseus

class DetailTabPageAdapter(fragment: Fragment) : FragmentStateAdapter(fragment) {

        companion object{
           const val INDEX_REPOSITORIES = 1
            const val INDEX_STARRED = 2
        }

    override fun getItemCount(): Int = 3

    override fun createFragment(position: Int): Fragment {

        return when (position) {
            INDEX_STARRED -> FragmentStarred()
            INDEX_REPOSITORIES -> FragmentRepositories()
            else -> FragmentOverView()
        }
    }

}