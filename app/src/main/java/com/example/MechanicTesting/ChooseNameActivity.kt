package com.example.MechanicTesting

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.kotlin_lesson1.R

class ChooseNameActivity : AppCompatActivity() {

    lateinit var chooseNameRecyclerview: RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_choose_name)

        val nameList: List<NameList> = listOf(
            NameList(1, "Дроздов", "Дмитрий"),
            NameList(2, "Дроздов", "Дмитрий"),
            NameList(3, "Дроздов", "Дмитрий"),
            NameList(4, "Дроздов", "Дмитрий"),
            NameList(5, "Дроздов", "Дмитрий"),
            NameList(6, "Дроздов", "Дмитрий"),
            NameList(7, "Дроздов", "Дмитрий"),
            NameList(8, "Дроздов", "Дмитрий"),
            NameList(9, "Дроздов", "Дмитрий"),
            NameList(10, "Дроздов", "Дмитрий")
        )
        chooseNameRecyclerview = findViewById(R.id.name_list_recycler_view)
        chooseNameRecyclerview.layoutManager =
            LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)

        chooseNameRecyclerview.adapter = NameAdapter(nameList)
        chooseNameRecyclerview.addItemDecoration(
            DividerItemDecoration(
                this,
                DividerItemDecoration.VERTICAL
            )
        )
    }
}