package com.example.presentation.ui.fragments._notifycation

import android.app.Service
import android.content.Intent
import android.os.IBinder
import android.util.Log
import com.google.firebase.firestore.FirebaseFirestore

class AlarmService : Service() {

    override fun onBind(intent: Intent?): IBinder? {
        return null
    }

    override fun onStartCommand(intent: Intent?, flags: Int, startId: Int): Int {

        stopSelf() // Остановка сервиса после выполнения операций
        return START_NOT_STICKY
    }

}