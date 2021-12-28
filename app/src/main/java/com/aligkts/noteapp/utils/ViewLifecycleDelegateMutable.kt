package com.aligkts.noteapp.utils

import androidx.fragment.app.Fragment
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LifecycleObserver
import androidx.lifecycle.OnLifecycleEvent
import kotlin.properties.ReadWriteProperty
import kotlin.reflect.KProperty

/**
 * Created by Ali Göktaş on 01,December,2021
 */
class ViewLifecycleDelegateMutable<T> : ReadWriteProperty<Fragment, T>, LifecycleObserver {

    private var value: T? = null
    private var isObserverAdded = false

    override fun getValue(
        thisRef: Fragment,
        property: KProperty<*>,
    ): T {
        return value!!
    }

    override fun setValue(thisRef: Fragment, property: KProperty<*>, value: T) {
        if (!isObserverAdded) {
            thisRef.viewLifecycleOwner.lifecycle.addObserver(this)
            isObserverAdded = true
        }
        this.value = value
    }

}