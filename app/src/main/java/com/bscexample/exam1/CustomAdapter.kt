package com.bscexample.exam1

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bscexample.exam1.databinding.HeroRecyclerItemBinding


class CustomAdapter : RecyclerView.Adapter<CustomAdapter.Holder>() {


    var data = mutableListOf<Hero>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Holder {
        val binding = HeroRecyclerItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return Holder(binding)
    }

    override fun getItemCount(): Int {
        return data.size
    }

    override fun onBindViewHolder(holder: Holder, position: Int) {
        val hero = data.get(position)
        holder.setHero(hero)
    }

    fun loadData(name: String, pos: String, line: String) {
        val hero = Hero(name, pos, line)
        data.add(hero)


    }

    class Holder(val binding: HeroRecyclerItemBinding): RecyclerView.ViewHolder(binding.root) {

        fun setHero(hero: Hero)
        {
            binding.tvName.text= hero.name
            binding.tvPos.text=hero.pos
            binding.tvLine.text=hero.line
        }

    }






}