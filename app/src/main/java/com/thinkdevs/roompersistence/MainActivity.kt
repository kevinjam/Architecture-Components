package com.thinkdevs.roompersistence

import android.arch.persistence.room.Room
import android.content.Intent
import android.os.Bundle
import android.support.design.widget.Snackbar
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import com.thinkdevs.roompersistence.model.User

import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.content_main.*

class MainActivity : AppCompatActivity() {
//    var user =ArrayList<User>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setSupportActionBar(toolbar)
        val db = Room.databaseBuilder(applicationContext, AppDatabase::class.java, "production")
                .allowMainThreadQueries()
                .build()

        val users =db.userDao().getallUsers()




        recyclerView.layoutManager = LinearLayoutManager(this)
        val adapter = UserAdapter(users)
        recyclerView.adapter = adapter


        fab.setOnClickListener { view ->
            Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                    .setAction("Action", null).show()
            startActivity(Intent(this@MainActivity, CreateActivity::class.java))
        }
    }



}
