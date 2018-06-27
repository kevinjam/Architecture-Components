package com.thinkdevs.roompersistence

import android.arch.persistence.room.Room
import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.support.design.widget.Snackbar
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.DividerItemDecoration
import android.support.v7.widget.LinearLayoutManager
import com.thinkdevs.roompersistence.adapter.UserAdapter
import com.thinkdevs.roompersistence.db.AppDatabase
import com.thinkdevs.roompersistence.db.DbUserThread

import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.content_main.*

class MainActivity : AppCompatActivity() {
 var db :AppDatabase?= null
    private lateinit var dbworkerThread:DbUserThread
    private val mUiHandler = Handler()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setSupportActionBar(toolbar)


        dbworkerThread = DbUserThread("dbWorkerThread")
        dbworkerThread.start()

        db = AppDatabase.getInstance(this)
        val users =db!!.userDao().getallUsers()




        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.addItemDecoration(DividerItemDecoration(recyclerView.context, DividerItemDecoration.VERTICAL))
        val adapter = UserAdapter(users)
        recyclerView.adapter = adapter


        fab.setOnClickListener { view ->
            startActivity(Intent(this@MainActivity, CreateActivity::class.java))
        }
    }

    override fun onDestroy() {
        AppDatabase.destroyInstance()
        dbworkerThread.quit()
        super.onDestroy()


    }



}
