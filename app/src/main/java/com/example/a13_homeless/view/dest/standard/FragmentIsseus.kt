package com.example.a13_homeless.view.dest.standard

import android.os.Bundle
import androidx.fragment.app.viewModels
import com.example.a13_homeless.R
import com.example.a13_homeless.view.viewbase.FragmentBase
import com.example.a13_homeless.databinding.FragmentIsseusBinding
import com.example.a13_homeless.view.adapter.IssuesAdapter
import com.example.a13_homeless.viewmodel.UserViewModel
import dagger.hilt.android.AndroidEntryPoint

/**
 * TODO: 모두 온크레이트 뷰로 옮길것임
 */
class FragmentIsseus : FragmentBase<FragmentIsseusBinding>(R.layout.fragment_isseus) {


    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        setAdapter()
    }

    private fun setAdapter() {

        val stringList: List<String> = listOf("[이슈] 2020-07-13 이슈 잔뜩발생 ")
        binding.recyclerViewIssues.adapter = IssuesAdapter(stringList)
    }

}
