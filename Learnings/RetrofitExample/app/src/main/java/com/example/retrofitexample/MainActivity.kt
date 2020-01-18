package com.example.retrofitexample

import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.AdapterView
import android.widget.ListView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.retrofitexample.adapters.CustomListAdapter
import com.example.retrofitexample.model.Colleges
import com.google.gson.GsonBuilder
import com.google.gson.JsonObject
import kotlinx.android.synthetic.main.activity_main.*
import org.json.JSONObject
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.*
import java.util.*
import android.content.Intent
import android.widget.TextView
import androidx.fragment.app.Fragment
import com.example.retrofitexample.fragments.DetailFragment
import com.example.retrofitexample.fragments.ListFragment


class MainActivity : AppCompatActivity(), ListFragment.ListContract {

    //Retrofit : This is a Liberary for calling API


    lateinit var detailFragment:DetailFragment;

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)



       /* submit.setOnClickListener(View.OnClickListener {
            callForSetCollege.enqueue(object: Callback<JSONObject>{
                override fun onResponse(call: Call<JSONObject>, response: Response<JSONObject>) {
                    Log.i("Message ", response.toString());
                    Toast.makeText(applicationContext,"Success " +response, Toast.LENGTH_LONG).show();
                }

                override fun onFailure(call: Call<JSONObject>, t: Throwable) {
                    Toast.makeText(applicationContext,"Failure " +t.message.toString(), Toast.LENGTH_LONG).show();
                }
            });
        })
*/
    }



    override fun onAttachFragment(fragment: Fragment) {
        super.onAttachFragment(fragment)
        if(fragment is ListFragment){
            fragment.setListener(this)
        }
    }

    override fun setSelectedData(collegeName: String, collegeType: String, stateName: String) {
        detailFragment = getSupportFragmentManager().findFragmentById(R.id.detailFragment) as DetailFragment
        detailFragment.setData(collegeName, collegeType, stateName)


    }
}

/*
* {records:[{"s_no_":01, "university_name":"IGNOU", "college_name":"TLC 0500", "college_type":"Training Inst", "state_name":"BIHAR", "district_name": "NALANDA"},
{"s_no_":01, "university_name":"IGNOU", "college_name":"TLC 0500", "college_type":"Training Inst", "state_name":"BIHAR", "district_name": "MUNGER"},
{"s_no_":02, "university_name":"IGNOU", "college_name":"TLC 0510", "college_type":"Training Inst", "state_name":"BIHAR", "district_name": "CHAPRA"},
{"s_no_":03, "university_name":"IGNOU", "college_name":"TLC 0512", "college_type":"Degree Inst", "state_name":"BIHAR", "district_name": "NAWADA"},
{"s_no_":04, "university_name":"IGNOU", "college_name":"TLC 0524", "college_type":"Degree Inst", "state_name":"BIHAR", "district_name": "MOTIHARI"}]}
* */