package com.example.kotlin_lesson1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.TextView
import android.widget.Toast

private const val TAG = "MainActivity"


class MainActivity : AppCompatActivity() {
    private lateinit var Button1: Button
    private lateinit var Button2: Button
    private lateinit var Button3: Button
        private lateinit var nextButton: Button
    private lateinit var questionTextView: TextView
    private val questionBank = listOf(
        Question(R.string.question1, 1),
        Question(R.string.question2, 2),
        Question(R.string.question3,1 ),
        Question(R.string.question4,2 ),
        Question(R.string.question5,2 ),

    )
    private var currentIndex = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Log.d(TAG, "onCreate(Bundle?) called")
        setContentView(R.layout.activity_main)
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
                currentIndex = (currentIndex + 1) %
                        questionBank.size
                updateQuestion()
            }
            val questionTextResId = questionBank[currentIndex].textResId
            updateQuestion()

        }
    override fun onStart() {
        super.onStart()
        Log.d(TAG, "onStart() called")
    }
    override fun onResume() {
        super.onResume()
        Log.d(TAG, "onResume() called")
    }
    override fun onPause() {
        super.onPause()
        Log.d(TAG, "onPause() called")
    }
    override fun onStop() {
        super.onStop()
        Log.d(TAG, "onStop() called")
    }
    override fun onDestroy() {
        super.onDestroy()
        Log.d(TAG, "onDestroy() called")
    }
        private fun updateQuestion() {
            val questionTextResId = questionBank[currentIndex].textResId
            questionTextView.setText(questionTextResId)

        }

        private fun checkAnswer(userAnswer: Int) {
            val correctAnswer =
                questionBank[currentIndex].answer
            val messageResId = if (userAnswer == correctAnswer) {
                R.string.correct_toast
            }
            else {
                R.string.incorrect_toast
            }
            Toast.makeText(
                this, messageResId,
                Toast.LENGTH_SHORT
            )
                .show()
        }
    }
