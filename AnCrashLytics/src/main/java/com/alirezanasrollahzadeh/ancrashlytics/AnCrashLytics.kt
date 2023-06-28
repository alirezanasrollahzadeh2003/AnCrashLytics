package com.alirezanasrollahzadeh.ancrashlytics

import android.content.Context
import android.os.Build
import android.util.Log
import com.alirezanasrollahzadeh.ancrashlytics.Services.ApiServices
import kotlinx.coroutines.DelicateCoroutinesApi
import kotlinx.coroutines.Dispatchers.IO
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import kotlinx.coroutines.newSingleThreadContext

/*Developed By Alireza Nasrollahzadeh*/


class AnCrashLytics constructor(val context:Context,val baseUrl : String): Thread.UncaughtExceptionHandler {
    private val defaultExceptionHandler: Thread.UncaughtExceptionHandler? =
        Thread.getDefaultUncaughtExceptionHandler()

    @OptIn(DelicateCoroutinesApi::class)
    override fun uncaughtException(thread: Thread, throwable: Throwable) {
        val request = ApiServices.invoke()
        GlobalScope.launch(newSingleThreadContext("IO")) {
            try {
                request.SendData(baseUrl,throwable.stackTraceToString() + "\n" + "Message : "
                        +throwable.message , Build.VERSION.RELEASE,
                    context.packageManager.getPackageInfo(context.packageName, 0).versionName.toString()
                )
            } catch (e: Exception) {
                Log.e("TAG", "Error: ${e.message}")
            }
            defaultExceptionHandler?.uncaughtException(thread, throwable)
        }
    }
    fun init(){
        Thread.setDefaultUncaughtExceptionHandler(this)
    }
}

