package com.thinkdevs.roompersistence

import android.arch.persistence.room.Dao
import android.arch.persistence.room.Insert
import android.arch.persistence.room.OnConflictStrategy.REPLACE
import android.arch.persistence.room.Query
import com.thinkdevs.roompersistence.model.User

@Dao
interface UserDao {

    @Query("SELECT * FROM user")
    fun getallUsers(): List<User>

    @Insert(onConflict = REPLACE)
    fun inserAll(user:User)
}