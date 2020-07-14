package com.example.a13_homeless.binding

import android.widget.ImageView
import android.widget.TextView
import androidx.annotation.ColorRes
import androidx.core.content.ContextCompat
import androidx.databinding.BindingAdapter
import com.bumptech.glide.Glide
import com.example.a13_homeless.R

@BindingAdapter("imageUrl")
fun imageUrl(view: ImageView, url: String?) = Glide.with(view.context).load(url).into(view)

@BindingAdapter("textColorChange")
fun textColorChange(view: TextView, language: String?) {

    @ColorRes
    val getColor = when (language) {
        "JavaScropt" -> R.color.color_blue
        "HTML" -> R.color.color_green
        "Kotlin" -> R.color.color_mint
        "Java" -> R.color.color_orange
        "TypeScript" -> R.color.color_pinkViolet
        "C++" -> R.color.color_red
        "C#  " -> R.color.color_skyBlue
        "Ruby" -> R.color.color_yellow
        else -> R.color.colorPrimary
    }

    view.setTextColor(ContextCompat.getColor(view.context,getColor))
}