package com.example.spinneractivity

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.TextView

data class SpinnerAdapter( var arrayList: ArrayList<String>) : BaseAdapter(){
    override fun getCount(): Int {
        return arrayList.size
    }

    override fun getItem(position: Int): Any {
        return arrayList[position]
    }

    override fun getItemId(position: Int): Long {
        return position.toLong()
    }

    override fun getView(p0: Int, p1: View?, p2: ViewGroup?): View {
        var initView = LayoutInflater.from(p2?.context).inflate(R.layout.spinner_items, p2,false)
        var tvTitle = initView.findViewById<TextView>(R.id.tvTitle)
        tvTitle.setText(arrayList[p0])
        return initView
    }

}
