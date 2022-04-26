package com.example.physicswallahassignment.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.physicswallahassignment.R
import com.example.physicswallahassignment.models.ApiResponseItem

class MyAdapter(private val context: Context, private val teacherList: List<ApiResponseItem>) :
    RecyclerView.Adapter<MyAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyAdapter.ViewHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.list_item, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.collegeName.text = teacherList[position].qualification[0]
        holder.teacherName.text = teacherList[position].name
        holder.subject.text = teacherList[position].subjects[0]
        Glide.with(context).load(teacherList[position].profileImage).into(holder.profileImage)
    }

    override fun getItemCount(): Int {
        return teacherList.size
    }

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val subject: TextView = itemView.findViewById(R.id.subject)
        val teacherName: TextView = itemView.findViewById(R.id.name)
        val collegeName: TextView = itemView.findViewById(R.id.college)
        val profileImage: ImageView = itemView.findViewById(R.id.list_image)
    }

}