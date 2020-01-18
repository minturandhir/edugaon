package com.example.retrofitexample

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.content.Intent
import kotlinx.android.synthetic.main.activity_college_detail.*


class CollegeDetailActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_college_detail)

        val rIntent = intent
        //println("::: " + rIntent?.getStringExtra("collegeType"))

        collegeName.text = rIntent?.getStringExtra("collegeName")
        collegeType.text = rIntent?.getStringExtra("collegeType")
        state.text = rIntent?.getStringExtra("state")
    }
}
