package com.aligkts.noteapp.ui.common.base

/**
 * Created by Ali Göktaş on 01,December,2021
 */

interface ListAdapterItem {
    val id: Long

    override fun equals(other: Any?): Boolean
}