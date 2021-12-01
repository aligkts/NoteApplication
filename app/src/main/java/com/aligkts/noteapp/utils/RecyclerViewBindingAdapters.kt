package com.aligkts.noteapp.utils

import androidx.databinding.BindingAdapter
import androidx.databinding.ViewDataBinding
import androidx.recyclerview.widget.RecyclerView
import com.aligkts.noteapp.ui.common.base.BaseListAdapter
import com.aligkts.noteapp.ui.common.base.ListAdapterItem

/**
 * Created by Ali Göktaş on 01,December,2021
 */

object RecyclerViewBindingAdapters {

    @JvmStatic
    @Suppress("UNCHECKED_CAST")
    @BindingAdapter("submitList")
    fun submitList(view: RecyclerView, list: List<ListAdapterItem>?) {
        val adapter = view.adapter as BaseListAdapter<ViewDataBinding, ListAdapterItem>?
        adapter?.submitList(list?.let { ArrayList(it) })
    }

    @JvmStatic
    @BindingAdapter("adapter")
    fun setAdapter(view: RecyclerView, adapter: BaseListAdapter<ViewDataBinding, ListAdapterItem>?) {
        adapter?.let {
            view.adapter = it
        }
    }
}