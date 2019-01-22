package com.example.root.nearestplacebasegpsmpvandroid.Presenter

import android.util.Log.d
import com.example.root.nearestplacebasegpsmpvandroid.Networking.ConfigNetwork
import com.example.root.nearestplacebasegpsmpvandroid.model.ResultGetData
import com.example.root.nearestplacebasegpsmpvandroid.model.ResultsItem
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class PlacePresenter(val view: PlaceView) {

    fun loadData(location : String, keyword: String, type : String, key :String){

        ConfigNetwork.getservice().ambilData(location,type,keyword,"2000",key).enqueue(object : Callback<ResultGetData>{
            override fun onFailure(call: Call<ResultGetData>, t: Throwable) {
                    d("waaaww",t.message)

            }

            override fun onResponse(call: Call<ResultGetData>, response: Response<ResultGetData>) {
                if(response.isSuccessful){

                    val data = response.body()?.results

                    view.onResult(data as List<ResultsItem>)
                }else{
                    view.onError()
                }
            }
        })
    }
}