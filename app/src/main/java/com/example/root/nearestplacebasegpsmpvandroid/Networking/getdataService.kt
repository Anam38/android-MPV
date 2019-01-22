package com.example.root.nearestplacebasegpsmpvandroid.Networking

import com.example.root.nearestplacebasegpsmpvandroid.model.ResultGetData
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface getdataService {

    @GET("nearbysearch/json")
    fun ambilData(
        @Query("location") location: String,
        @Query("type") type: String,
        @Query("keyword") keyword: String,
        @Query("radius") radius: String,
        @Query("key") key: String

    ) : Call<ResultGetData>
}
