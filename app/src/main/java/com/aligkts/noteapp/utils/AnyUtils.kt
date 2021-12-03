package com.aligkts.noteapp.utils

/**
 * Created by Ali Göktaş on 03,December,2021
 */

fun <T, R> safeLet(p1: T?, p2: R?, block: (T, R) -> Unit) {
    if (p1 != null && p2 != null) block(p1, p2)
}