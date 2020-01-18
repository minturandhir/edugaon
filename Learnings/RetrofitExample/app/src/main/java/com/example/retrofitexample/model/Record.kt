package com.example.retrofitexample.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class Record {

    @SerializedName("s_no_")
    @Expose
    var sNo: String? = null
    @SerializedName("university_name")
    @Expose
    var universityName: String? = null
    @SerializedName("college_name")
    @Expose
    var collegeName: String? = null
    @SerializedName("college_type")
    @Expose
    var collegeType: String? = null
    @SerializedName("state_name")
    @Expose
    var stateName: String? = null
    @SerializedName("district_name")
    @Expose
    var districtName: String? = null

}
