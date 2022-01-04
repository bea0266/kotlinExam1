package com.bscexample.exam1

import android.text.Layout
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import kotlinx.android.synthetic.main.hero_list_item.view.*

class CustomAdapter(var data : ArrayList<Hero>) : BaseAdapter() {


    override fun getCount(): Int {

        return data.size
    }

    override fun getItem(position: Int): Any {

        return data.get(position)
    }

    override fun getItemId(position: Int): Long {

        return position.toLong()
    }

    override fun getView(position: Int, view: View?, parent: ViewGroup?): View {

        var converterView = view
        if(converterView == null) converterView = LayoutInflater.from(parent?.context)
            .inflate(R.layout.hero_list_item, parent, false)

        val item: Hero = data[position]
        converterView!!.tvName.setText(item.name)
        converterView!!.tvPos.setText(item.pos)
        converterView!!.tvLine.setText(item.line)

        return converterView


    }
}