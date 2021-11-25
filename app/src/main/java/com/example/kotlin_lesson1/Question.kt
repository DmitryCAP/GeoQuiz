package com.example.kotlin_lesson1

import androidx.annotation.StringRes

data class Question(@StringRes val textResId:Int, val answer: Int)