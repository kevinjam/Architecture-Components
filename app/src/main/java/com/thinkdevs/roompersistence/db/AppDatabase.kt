package com.thinkdevs.roompersistence.db

import android.arch.persistence.room.Database
import android.arch.persistence.room.Room
import android.arch.persistence.room.RoomDatabase
import android.content.Context
import com.thinkdevs.roompersistence.UserDao
import com.thinkdevs.roompersistence.model.User

@Database(entities = [(User::class)], version = 1)
abstract class AppDatabase : RoomDatabase(){

    abstract fun userDao(): UserDao

    companion object {
        private var INSTANCE : AppDatabase? = null

        fun getInstance(context: Context): AppDatabase?{
            synchronized(AppDatabase::class){
                INSTANCE = Room.databaseBuilder(context.applicationContext, AppDatabase::class.java, "production")
                        .allowMainThreadQueries() // test purpose
                        .build()

            }
            return INSTANCE

        }


        fun destroyInstance(){
            INSTANCE = null
        }

    }


}