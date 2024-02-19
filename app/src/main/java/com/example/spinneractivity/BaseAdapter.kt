package com.example.spinneractivity

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.TextView
import com.google.android.filament.View

class BaseAdapter(var arrayList: ArrayList<ArrayModel>)  : BaseAdapter(){
    override fun getCount(): Int {
        return arrayList.size
    }

    override fun getItem(position: Int): Any {
        return arrayList[position]

    }

    override fun getItemId(position: Int): Long {
        return position.toLong()
    }

    override fun getView(
        position: Int,
        convertView: android.view.View?,
        parent: ViewGroup?
    ): android.view.View {
        var initView = LayoutInflater.from(parent?.context).inflate(R.layout.spinner_items, parent,false)
        var tvTitle = initView.findViewById<TextView>(R.id.tvTitle)
        tvTitle.setText(arrayList[position].name)
        return initView
    }

}
