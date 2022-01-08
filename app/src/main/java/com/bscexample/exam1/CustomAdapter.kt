package com.bscexample.exam1

import android.content.Context
import android.text.Layout
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.TextView
import com.bscexample.exam1.databinding.HeroListItemBinding


class CustomAdapter(val context: Context, var data : ArrayList<Hero>) : BaseAdapter() {


    override fun getCount(): Int {

        return data.size
    }

    override fun getItem(position: Int): Any {

        return data.get(position)
    }

    override fun getItemId(position: Int): Long {

        return position.toLong()
    }

    override fun getView(position: Int, convertview: View?, parent: ViewGroup?): View {

        val view: View = LayoutInflater.from(context).inflate(R.layout.hero_list_item, null)
        val tvName = view.findViewById<TextView>(R.id.tvName)
        val tvPos = view.findViewById<TextView>(R.id.tvPos)
        val tvLine = view.findViewById<TextView>(R.id.tvLine)
        val item: Hero = data[position]
        tvName.text = item.name
        tvPos.text = item.pos
        tvLine.text = item.line

        return view



    }
}