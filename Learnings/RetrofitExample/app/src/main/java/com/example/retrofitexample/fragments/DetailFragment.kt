package com.example.retrofitexample.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.retrofitexample.R
import kotlinx.android.synthetic.main.activity_college_detail.*

class DetailFragment: Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        var view = inflater.inflate(R.layout.layout_detail_fragment,container,false)
        return view
    }

    fun setData(name:String, type:String,stateName:String){
        collegeName.text = name
        collegeType.text = type
        state.text = stateName
    }
}