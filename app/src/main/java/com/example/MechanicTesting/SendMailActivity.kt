package com.example.MechanicTesting

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import com.example.kotlin_lesson1.R

private var RESULT_TEST = "Mail"
class SendMailActivity : AppCompatActivity() {
    lateinit var openMailButton: Button


    lateinit var textMail: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_send_mail)

        openMailButton = findViewById(R.id.open_mail_button)


        openMailButton.setOnClickListener {
            val mailLink = Uri.parse("https://yandex.mail.ru/messages#sentmsg")
            val openMailIntent = Intent(Intent.ACTION_VIEW, mailLink)
                //   startActivity(openMailIntent)

            textMail = findViewById(R.id.text_mail)
            val resultTestView: String? = intent.extras?.getString(RESULT_TEST, "0")
            textMail.text = resultTestView
        }
    }
}