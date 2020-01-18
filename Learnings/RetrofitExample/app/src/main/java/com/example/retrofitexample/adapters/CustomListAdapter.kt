package com.example.retrofitexample.adapters

import android.app.Activity
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import com.example.retrofitexample.R
import com.example.retrofitexample.model.Record
import kotlinx.android.synthetic.main.list_view_item.view.*


class CustomListAdapter(private val activity: Activity, private val colleges: List<Record>) : BaseAdapter() {

    override fun getView(p0: Int, p1: View?, p2: ViewGroup?): View {
        val layoutInflater:LayoutInflater =
            activity.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater;
        val view:View = layoutInflater.inflate(R.layout.list_view_item,null,false);

        view.college_name.text = colleges.get(p0).collegeName
        return view;
    }

    override fun getItem(p0: Int): Any {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun getItemId(p0: Int): Long {
        return 0;
    }

    override fun getCount(): Int {
        return colleges.size;
    }

}

