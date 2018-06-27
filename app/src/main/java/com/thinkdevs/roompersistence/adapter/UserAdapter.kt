package com.thinkdevs.roompersistence.adapter

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.thinkdevs.roompersistence.R
import com.thinkdevs.roompersistence.model.User

class UserAdapter(var user:List<User>) : RecyclerView.Adapter<UserAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
val view = LayoutInflater.from(parent.context).inflate(R.layout.item_user_row, parent, false)
       return ViewHolder(view)
    }

    override fun getItemCount(): Int {
        return user.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bindview(user[position])
    }

    class ViewHolder(itemView: View?) : RecyclerView.ViewHolder(itemView) {

        fun bindview(user:User){
            val firstname = itemView.findViewById<TextView>(R.id.firstname)
            val lastName = itemView.findViewById<TextView>(R.id.lastname)
            val email = itemView.findViewById<TextView>(R.id.email)

            firstname.text = user.firstName
            lastName.text = user.lastName
            email.text = user.email


        }

    }






}