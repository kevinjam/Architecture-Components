package com.thinkdevs.roompersistence

import android.arch.persistence.room.Database
import android.arch.persistence.room.RoomDatabase
import com.thinkdevs.roompersistence.model.User

@Database(entities = [(User::class)], version = 1)
abstract class AppDatabase : RoomDatabase(){

    abstract fun userDao():UserDao


}