package com.thinkdevs.roompersistence

import android.arch.persistence.room.Room
import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.thinkdevs.roompersistence.model.User
import kotlinx.android.synthetic.main.create_activty.*

class CreateActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.create_activty)


        val db = Room.databaseBuilder(applicationContext, AppDatabase::class.java, "production")
                .allowMainThreadQueries()
                .build()

        save_users.setOnClickListener {

            println(firstname.text.toString())
            val user = User(0,firstname.text.toString(), last_name.text.toString(), email.text.toString())
            db.userDao().inserAll(user)

            startActivity(Intent(this, MainActivity::class.java))






        }


    }
}