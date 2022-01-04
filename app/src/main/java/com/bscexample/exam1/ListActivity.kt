package com.bscexample.exam1

import android.app.Activity
import android.os.Bundle
import android.widget.ArrayAdapter
import kotlinx.android.synthetic.main.list.*

class ListActivity : Activity() {

    val data = ArrayList<Hero>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.list)




        var adapter : CustomAdapter = CustomAdapter(data)
        listview.adapter = adapter

        var helper : DBHelper = execHelper()
        getHeroes(helper)

        btnMain.setOnClickListener {
            finish()
        }


    }

    private fun execHelper() : DBHelper {


        val helper : DBHelper = DBHelper(applicationContext, "game", null, 1 )

        return helper

    }

    private fun getHeroes(helper:DBHelper){

        val rdb = helper.readableDatabase
        val cursor = rdb.rawQuery("SELECT * FROM hero", null)
        while(cursor.moveToNext()){

            data.add(Hero(cursor.getString(0), cursor.getString(1), cursor.getString(2)))

        }

        rdb.close()

    }
}