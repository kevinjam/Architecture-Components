package com.thinkdevs.roompersistence.db

import android.os.Handler
import android.os.HandlerThread

class DbUserThread(threadName:String) : HandlerThread(threadName){
    private lateinit var userWorker :Handler

    override fun onLooperPrepared() {
        super.onLooperPrepared()
        userWorker = Handler(looper)
    }

    fun postTask(task:Runnable){
        userWorker.post(task)
    }
}