package com.thinkdevs.roompersistence

import android.arch.persistence.room.Room
import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.support.v7.app.AppCompatActivity
import com.thinkdevs.roompersistence.db.AppDatabase
import com.thinkdevs.roompersistence.db.DbUserThread
import com.thinkdevs.roompersistence.model.User
import kotlinx.android.synthetic.main.create_activty.*

class CreateActivity : AppCompatActivity() {
    var db :AppDatabase?= null
    private lateinit var dbworkerThread:DbUserThread
    private val mUiHandler = Handler()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.create_activty)

        dbworkerThread = DbUserThread("dbWorkerThread")
        dbworkerThread.start()

        db = AppDatabase.getInstance(this)

        save_users.setOnClickListener {

            val task = Runnable {
                val user = User(0,firstname.text.toString(), last_name.text.toString(), email.text.toString())
                db!!.userDao().inserAll(user)

            }

            dbworkerThread.postTask(task)

            println(firstname.text.toString())


            startActivity(Intent(this, MainActivity::class.java))






        }


    }
}