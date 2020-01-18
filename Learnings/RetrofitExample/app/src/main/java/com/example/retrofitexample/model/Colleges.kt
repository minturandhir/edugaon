package com.example.retrofitexample.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class Colleges {

    @SerializedName("records")
    @Expose
    var records: List<Record>? = null

}
