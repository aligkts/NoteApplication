package com.aligkts.noteapp.ui.common.base

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.annotation.CallSuper
import androidx.annotation.LayoutRes
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter

/**
 * Created by Ali Göktaş on 01,December,2021
 */

abstract class BaseListAdapter<VB : ViewDataBinding, T : ListAdapterItem>(
    diffCallback: DiffUtil.ItemCallback<T> = ListAdapterItemDiffCallback()
) : ListAdapter<T, BaseViewHolder<VB>>(diffCallback) {

    private val removedItems = arrayListOf<T>()

    lateinit var binding: VB

    @LayoutRes
    protected abstract fun getLayoutId(position: Int): Int

    protected abstract fun bind(binding: VB, item: T, position: Int)

    override fun onCreateViewHolder(
        parent: ViewGroup,
        @LayoutRes viewType: Int
    ): BaseViewHolder<VB> {
        binding = DataBindingUtil.inflate(
            LayoutInflater.from(parent.context),
            viewType,
            parent,
            false
        )

        return BaseViewHolder(binding)
    }

    override fun getItemViewType(position: Int): Int = getLayoutId(position)

    override fun onBindViewHolder(holder: BaseViewHolder<VB>, position: Int) {
        bind(holder.binding, getItem(position), position)
    }

    @CallSuper
    override fun submitList(list: List<T>?) {
        submit(list, false)
    }

    private fun submit(list: List<T>?, isLocalSubmit: Boolean) {
        if (!isLocalSubmit) removedItems.clear()
        super.submitList(list)
    }

    fun removeItem(position: Int): T? {
        val item = currentList[position]
        if (position > itemCount) return null
        removedItems.add(item)
        val list = currentList - removedItems
        if (list.isEmpty()) removedItems.clear()
        submit(list, true)
        return item
    }
}