package com.aligkts.noteapp

import android.app.Application
import dagger.hilt.android.HiltAndroidApp
import timber.log.Timber

/**
 * Created by Ali Göktaş on 01,December,2021
 */
@HiltAndroidApp
class NoteApp : Application() {

    override fun onCreate() {
        super.onCreate()
        if (BuildConfig.DEBUG) {
            Timber.plant(object : Timber.DebugTree() {
                override fun createStackElementTag(element: StackTraceElement) =
                    "noteAppLog:(${super.createStackElementTag(element)}" +
                            ":${element.fileName}" +
                            ":${element.lineNumber})"

            })
        }
    }
}