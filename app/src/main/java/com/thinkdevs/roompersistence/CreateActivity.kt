package com.thinkdevs.roompersistence

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import kotlinx.android.synthetic.main.create_activty.*

class CreateActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.create_activty)

        save_users.setOnClickListener {

            println(firstname.text.toString())


        }


    }
}