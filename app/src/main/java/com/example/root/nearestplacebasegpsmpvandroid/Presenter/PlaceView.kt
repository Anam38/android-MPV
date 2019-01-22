package com.example.root.nearestplacebasegpsmpvandroid.Presenter

import com.example.root.nearestplacebasegpsmpvandroid.model.ResultsItem

interface PlaceView {

    fun onResult(data: List<ResultsItem>)

    fun onError()
}