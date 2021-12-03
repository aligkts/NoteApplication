package com.aligkts.noteapp.utils

import android.app.Activity
import android.content.Context
import android.content.res.Resources
import android.graphics.Color
import android.net.ConnectivityManager
import android.net.NetworkCapabilities
import android.os.Build
import android.view.View
import android.view.inputmethod.InputMethodManager
import android.widget.Toast
import androidx.annotation.ColorRes
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment

/**
 * Created by Ali Göktaş on 01,December,2021
 */
@Suppress("unused")
fun Fragment.showToast(text: String?) = context?.showToast(text)

fun Context.showToast(text: String?) {
    Toast.makeText(this, text, Toast.LENGTH_LONG).apply { show() }
}

fun Context.loadColor(@ColorRes res: Int?): Int {
    return res?.let {
        try {
            ContextCompat.getColor(this, it)
        } catch (e: Resources.NotFoundException) {
            Color.BLACK
        }
    } ?: Color.BLACK
}

fun Fragment.getColorCompat(@ColorRes colorId: Int) =
    ContextCompat.getColor(requireContext(), colorId)

fun Context.isNetworkAvailable(): Boolean {
    val cm = getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
        val nw = cm.activeNetwork ?: return false
        val actNw = cm.getNetworkCapabilities(nw) ?: return false
        return when {
            actNw.hasTransport(NetworkCapabilities.TRANSPORT_WIFI) -> true
            actNw.hasTransport(NetworkCapabilities.TRANSPORT_CELLULAR) -> true
            actNw.hasTransport(NetworkCapabilities.TRANSPORT_ETHERNET) -> true
            actNw.hasTransport(NetworkCapabilities.TRANSPORT_BLUETOOTH) -> true
            else -> false
        }
    } else {
        @Suppress("DEPRECATION")
        val nwInfo = cm.activeNetworkInfo ?: return false
        @Suppress("DEPRECATION")
        return nwInfo.isConnected
    }
}

fun Context.hideKeyboard(view: View) {
    val inputMethodManager =
        getSystemService(Activity.INPUT_METHOD_SERVICE) as InputMethodManager
    inputMethodManager.hideSoftInputFromWindow(view.windowToken, 0)
}