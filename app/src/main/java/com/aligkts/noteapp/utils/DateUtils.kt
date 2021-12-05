package com.aligkts.noteapp.utils

import java.text.SimpleDateFormat
import java.util.*

/**
 * Created by Ali Göktaş on 02,December,2021
 */

fun Date.formattedDate(): String {
    val sdf = SimpleDateFormat("dd/MM/yyyy", Locale.getDefault())
    return sdf.format(this)
}