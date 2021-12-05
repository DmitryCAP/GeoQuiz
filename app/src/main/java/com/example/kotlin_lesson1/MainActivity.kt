package com.example.kotlin_lesson1

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import org.w3c.dom.Text

private var RESULT_TEST = "Mail"

var resultTest: Int = 0


class MainActivity : AppCompatActivity() {
lateinit var resultTestView: String
    lateinit var sendResultButton: Button

    private lateinit var Button1: Button
    private lateinit var Button2: Button
    private lateinit var Button3: Button
    private lateinit var nextButton: Button
    private lateinit var questionTextView: TextView
    private val questionBank = listOf(
        Question(R.string.question1, 1),
        Question(R.string.question2, 2),
        Question(R.string.question3, 1),
        Question(R.string.question4, 2),
        Question(R.string.question5, 2),

        )
    private var currentIndex = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)




        sendResultButton = findViewById(R.id.send_result_button)

        sendResultButton.setOnClickListener {

            val sendMailIntent: Intent = Intent(this, SendMailActivity::class.java)

            sendMailIntent.putExtra(RESULT_TEST, "количество правильных ответов: $resultTest")

            startActivity(sendMailIntent)
        }
//        resultTestView =
//        resultTestView = "количество правильных ответов: $resultTest"

        Button1 =
            findViewById(R.id.button1)
        Button2 =
            findViewById(R.id.button2)
        Button3 =
            findViewById(R.id.button3)

        nextButton =
            findViewById(R.id.next_button)
        questionTextView =
            findViewById(R.id.question_text_view)
        Button1.setOnClickListener { view: View ->
            checkAnswer(1)
        }
        Button2.setOnClickListener { view: View ->
            checkAnswer(2)
        }
        Button3.setOnClickListener { view: View ->
            checkAnswer(3)
        }
        nextButton.setOnClickListener {

            if (currentIndex < 4) {
                Button1.isClickable = true
                Button2.isClickable = true
                Button3.isClickable = true

                currentIndex = (currentIndex + 1)
                updateQuestion()
            }
            else
                nextButton.isClickable = false
        }
        val questionTextResId = questionBank[currentIndex].textResId
        updateQuestion()

    }

    private fun updateQuestion() {
        val questionTextResId = questionBank[currentIndex].textResId
        questionTextView.setText(questionTextResId)

    }

    private fun checkAnswer(userAnswer: Int) {


        val correctAnswer =
            questionBank[currentIndex].answer
        val messageResId = if (userAnswer == correctAnswer) {
            Button1.isClickable = false
            Button2.isClickable = false
            Button3.isClickable = false
            resultTest += 1

            R.string.correct_toast

        } else {
            Button1.isClickable = false
            Button2.isClickable = false
            Button3.isClickable = false

            R.string.incorrect_toast
        }
        Toast.makeText(
            this, messageResId,
            Toast.LENGTH_SHORT
        )

            .show()


    }

}
