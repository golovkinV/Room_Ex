package com.example.room_ex.app

import android.app.Application
import com.example.data.DBProvider

class App: Application() {

    override fun onCreate() {
        super.onCreate()
        DBProvider.create(this)
    }
}