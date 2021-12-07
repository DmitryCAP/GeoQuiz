package com.example.MechanicTesting

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.kotlin_lesson1.R

class NameAdapter(private val nameList: List<NameList>) : RecyclerView.Adapter<NameViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NameViewHolder {
        val itemView =
            LayoutInflater.from(parent.context)
                .inflate(R.layout.name_list_item, parent, false)
        return NameViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: NameViewHolder, position: Int) {
        val name = nameList[position]
        holder.bind(name)
    }

    override fun getItemCount(): Int {
        return nameList.size
    }
}