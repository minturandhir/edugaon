package com.example.retrofitexample.fragments

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import android.widget.ListView
import androidx.fragment.app.Fragment
import com.example.retrofitexample.R
import com.example.retrofitexample.adapters.CustomListAdapter
import com.example.retrofitexample.model.Colleges
import com.google.gson.GsonBuilder
import org.json.JSONObject
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST

class ListFragment: Fragment() {

    lateinit var retrofit:Retrofit;
    val BASE_URL:String = "http://demo8014883.mockable.io/";
    var collegeList: ListView? = null;
    var result: Colleges?= null;

    val service:GetDataService = getRetrofitInstance().create(GetDataService::class.java);
    val callGet = service.getColleges();

    val callForSetCollege = service.setCollege("{\"collegeName\":\"IGNOU\",\"collegeId\": \"001\"}");

    lateinit var mListener:ListContract;

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        var view = inflater.inflate(R.layout.layout_list_fragment,container,false)
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {

        collegeList = view.findViewById(R.id.college_list);

        collegeList?.setOnItemClickListener(AdapterView.OnItemClickListener { parent, view, position, id ->

            mListener.setSelectedData(
                result?.records?.get(position)?.collegeName.toString(),
                result?.records?.get(position)?.collegeType.toString(),
                result?.records?.get(position)?.stateName.toString())

        })
        init()
    }


    fun init(){
        callGet.enqueue(object : Callback<Colleges> {
            override fun onResponse(call: Call<Colleges>, response: Response<Colleges>) {
                result = response.body();
                setListDate(result!!)
            }

            override fun onFailure(call: Call<Colleges>, t: Throwable) {
                Log.i("MainActivity :: ", "Something went wrong" + t.message);
            }
        });
    }

    /**
     * Method used to get the instance of Retrofit
     * @return
     * */
    fun  getRetrofitInstance(): Retrofit {
        val gson = GsonBuilder()
            .setLenient()
            .create()
        val lenientFactory = GsonConverterFactory.create(gson)

        retrofit =  retrofit2.Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(lenientFactory)
            .build();
        return retrofit;
    }

    fun setListener(listContract: ListContract) {
        mListener = listContract
    }

    /**
     * Interface to call API
     * */

    interface GetDataService {
        @GET("college")
        fun getColleges(): Call<Colleges>

        @POST("setCollege")
        fun setCollege(@Body collegeDetail:String): Call<JSONObject>;
    }

    interface ListContract{
       fun setSelectedData(collegeName:String, collegeType:String, stateName:String);
    }

    fun setListDate(colleges: Colleges){
        val adapter = CustomListAdapter(this.activity!!, colleges!!.records!!)
        collegeList?.adapter = adapter
    }
}