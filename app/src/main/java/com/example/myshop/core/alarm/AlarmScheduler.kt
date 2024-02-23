package com.example.myshop.core.alarm

import android.app.PendingIntent

interface AlarmScheduler {
    fun createPendingIntent(): PendingIntent

    fun schedule()
}