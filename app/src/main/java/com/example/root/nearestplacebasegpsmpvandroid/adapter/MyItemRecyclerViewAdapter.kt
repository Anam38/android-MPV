package com.example.root.nearestplacebasegpsmpvandroid.adapter

import android.provider.Settings.Global.getString
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import com.example.root.nearestplacebasegpsmpvandroid.R


import com.example.root.nearestplacebasegpsmpvandroid.model.ResultsItem
import com.squareup.picasso.Picasso

import kotlinx.android.synthetic.main.fragment_item.view.*


class MyItemRecyclerViewAdapter(
    private val mValues: List<ResultsItem>
) : RecyclerView.Adapter<MyItemRecyclerViewAdapter.ViewHolder>() {



    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.fragment_item, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = mValues[position]
        holder.mIdView.text = item.name
        holder.mContentView.text = item.rating.toString()
        Picasso.get()
            .load("https://maps.googleapis.com/maps/api/place/photo?maxwidth=400&photoreference="+item.photos?.get(0)?.photoReference+"&key=AIzaSyAWJgZTtBhJSDAqiTwIFJeYIDQ7Ym-I_YQ")
            .error(R.drawable.dfbsdgfnb)
            .into(holder.mLogo)

    }

    override fun getItemCount(): Int = mValues.size

    inner class ViewHolder(val mView: View) : RecyclerView.ViewHolder(mView) {
        val mIdView: TextView = mView.item_number
        val mContentView: TextView = mView.content
        val mLogo : ImageView = mView.logo

        override fun toString(): String {
            return super.toString() + " '" + mContentView.text + "'"
        }
    }
}
