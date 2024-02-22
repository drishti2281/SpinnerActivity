package com.example.spinneractivity

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.Recycler

class RecyclerClass(var list : ArrayList<MessageDataClass>) : RecyclerView.Adapter<RecyclerClass.ViewHolder>() {
    class ViewHolder(var views: View): RecyclerView.ViewHolder(views) {