package com.rickapp.util

import android.transition.Fade

private const val DELAY_TIME = 2000L

fun createFade(duration: Long = DELAY_TIME): Fade {

    return Fade().apply {
        this.duration = duration
    }
}