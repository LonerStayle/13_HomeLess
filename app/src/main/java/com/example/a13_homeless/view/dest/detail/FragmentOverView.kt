package com.example.a13_homeless.view.dest.detail

import android.os.Bundle
import androidx.lifecycle.Observer
import com.example.a13_homeless.R
import com.example.a13_homeless.view.viewbase.FragmentBase
import com.example.a13_homeless.databinding.FragmentOverViewBinding
import com.example.a13_homeless.view.const.Contents

/**
 * TODO: args 적용이 안됨
 */
class FragmentOverView : FragmentBase<FragmentOverViewBinding>(R.layout.fragment_over_view) {

        private val args by lazy { Contents.userSearch }


    override fun FragmentOverViewBinding.setEventListener() {
        observer()
        showOverView()
    }

    private fun observer() {
        viewModel.userOverView.observe(viewLifecycleOwner, Observer {
            binding.userOverView = it

        })
    }
    private fun showOverView() {
        viewModel.getOverView(args)
    }
}
