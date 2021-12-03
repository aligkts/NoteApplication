package com.aligkts.noteapp.ui.common.base

import androidx.recyclerview.widget.DiffUtil

/**
 * Created by Ali Göktaş on 01,December,2021
 */

class ListAdapterItemDiffCallback<T : ListAdapterItem> : DiffUtil.ItemCallback<T>() {

    override fun areItemsTheSame(oldItem: T, newItem: T): Boolean {
        return oldItem.id == newItem.id
    }

    override fun areContentsTheSame(oldItem: T, newItem: T): Boolean {
        return oldItem == newItem
    }
}