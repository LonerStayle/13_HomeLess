package com.example.a13_homeless

import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentPagerAdapter
import androidx.fragment.app.FragmentStatePagerAdapter
import androidx.recyclerview.widget.RecyclerView
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.example.a13_homeless.View.dest.FragmentIsseus

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