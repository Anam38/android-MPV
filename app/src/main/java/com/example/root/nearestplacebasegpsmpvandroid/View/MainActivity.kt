package com.example.root.nearestplacebasegpsmpvandroid.View

import android.os.Build
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.util.Log.d
import android.widget.Toast
import com.example.root.nearestplacebasegpsmpvandroid.Presenter.PlacePresenter
import com.example.root.nearestplacebasegpsmpvandroid.Presenter.PlaceView
import com.example.root.nearestplacebasegpsmpvandroid.R
import com.example.root.nearestplacebasegpsmpvandroid.URL.GPSTracker
import com.example.root.nearestplacebasegpsmpvandroid.adapter.MyItemRecyclerViewAdapter
import com.example.root.nearestplacebasegpsmpvandroid.model.ResultsItem
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), PlaceView {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val presenter = PlacePresenter(this)

        val gps = GPSTracker(this)

        if (gps.checkPermission(this)) {
            if (gps.canGetLocation()) {

                val lat = gps.latitude
                val lon = gps.longitude
                val locations = "$lat,$lon"

                presenter.loadData(
                    locations,
                    "cruise",
                    "restaurant",
                    getString(R.string.key)
                )
            }
        }else{
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                requestPermissions(arrayOf(android.Manifest.permission.ACCESS_FINE_LOCATION,android.Manifest.permission.ACCESS_COARSE_LOCATION),2)
            }
        }
    }


    override fun onResult(data: List<ResultsItem>) {
        d("daya", data.toString())
        recyclearview.adapter = MyItemRecyclerViewAdapter(data)
        recyclearview.layoutManager = LinearLayoutManager(this)
    }

    override fun onError() {
        Toast.makeText(this, "gagal", Toast.LENGTH_SHORT).show()
    }
}
