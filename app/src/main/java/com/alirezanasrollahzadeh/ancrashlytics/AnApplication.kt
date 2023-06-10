package com.alirezanasrollahzadeh.ancrashlytics

import android.app.Application

/*Developed By Alireza Nasrollahzadeh*/


class AnApplication : Application() {
    override fun onCreate() {
        super.onCreate()
        AnCrashLytics(this,baseUrl = "http://192.168.1.53/AlirezaNasrollahzadeh/index.php").init()
    }
}