package com.aligkts.noteapp.utils

import android.view.View
import android.widget.ImageView
import androidx.core.view.isVisible
import androidx.databinding.BindingAdapter
import com.bumptech.glide.Glide

/**
 * Created by Ali Göktaş on 02,December,2021
 */
object ViewBindingAdapter {
    @JvmStatic
    @BindingAdapter("visibleIf")
    fun visibleIf(view: View, shouldVisible: Boolean) {
        view.isVisible = shouldVisible
    }

    @JvmStatic
    @BindingAdapter("app:imageUrl")
    fun setImageUrl(imageView: ImageView, imageUrl: String?) {
        imageUrl?.let {
            Glide.with(imageView.context)
                .load(imageUrl)
                .into(imageView)
        }
    }
}