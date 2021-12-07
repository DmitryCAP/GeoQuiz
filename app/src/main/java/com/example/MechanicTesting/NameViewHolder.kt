package com.example.MechanicTesting

import android.view.View
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.example.kotlin_lesson1.R

private var NAME_CHOOSE = "Name"


class NameViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

    private val nameTextView: TextView = itemView.findViewById(R.id.name_text_view)

    fun bind(name: NameList) {

        nameTextView.text = "${name.position}. ${name.lastName} ${name.firstName}"

        itemView.setOnClickListener {


            Toast.makeText(itemView.context, nameTextView.text, Toast.LENGTH_SHORT).show()

        }

    }
}
