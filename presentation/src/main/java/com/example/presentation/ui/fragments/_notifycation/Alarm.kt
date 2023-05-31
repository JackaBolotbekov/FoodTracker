package com.example.presentation.ui.fragments._notifycation

import android.app.AlarmManager
import android.app.PendingIntent
import android.content.Context
import android.content.Intent
import android.os.Build
import java.util.*

fun setAlarm(context: Context) {
    val alarmManager = context.getSystemService(Context.ALARM_SERVICE) as AlarmManager
    val intent = Intent(context, AlarmService::class.java)
    val pendingIntent = PendingIntent.getService(context, 0, intent, 0)

    val calendar = Calendar.getInstance()
    calendar.set(Calendar.HOUR_OF_DAY, AlarmService.HOUR_OF_DAY)
    calendar.set(Calendar.MINUTE, AlarmService.MINUTE)
    calendar.set(Calendar.SECOND, 0)
    calendar.set(Calendar.MILLISECOND, 0)

    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
        alarmManager.setExactAndAllowWhileIdle(
            AlarmManager.RTC_WAKEUP,
            calendar.timeInMillis,
            pendingIntent
        )
    } else {
        alarmManager.setExact(
            AlarmManager.RTC_WAKEUP,
            calendar.timeInMillis,
            pendingIntent
        )
    }
}