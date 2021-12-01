package com.aligkts.noteapp.utils

import androidx.navigation.NavController
import androidx.navigation.NavDirections
import androidx.navigation.Navigator
import timber.log.Timber

/**
 * Created by Ali Göktaş on 01,December,2021
 */
fun NavController.navigateSafe(
    directions: NavDirections,
    extras: Navigator.Extras? = null,
) {
    if (currentDestination?.getAction(directions.actionId) != null) {
        if (extras != null) {
            navigate(directions, extras)
        } else {
            navigate(directions)
        }

    } else {
        Timber.w(Throwable("trying to navigate to a unknown destination"))
    }
}