package com.aligkts.noteapp.utils

import android.view.View
import androidx.core.view.isGone
import androidx.core.view.isVisible
import androidx.databinding.BindingAdapter

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
    @BindingAdapter("hiddenIf")
    fun hiddenIf(view: View, shouldHidden: Boolean) {
        view.isGone = shouldHidden
    }
}