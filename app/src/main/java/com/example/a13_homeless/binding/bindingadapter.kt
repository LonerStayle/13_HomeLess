package com.example.a13_homeless.binding

import android.widget.ImageView
import androidx.databinding.BindingAdapter
import com.bumptech.glide.Glide

@BindingAdapter("imageUrl")
fun bindingAdpater(view:ImageView,url:String) = Glide.with(view.context).load(url).into(view)