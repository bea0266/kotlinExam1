package com.bscexample.exam1

import android.app.Activity
import android.os.Bundle
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import android.widget.ArrayAdapter
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.list.*

class ListActivity : AppCompatActivity() {

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

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        val inflater : MenuInflater = menuInflater
        inflater.inflate(R.menu.list_menu, menu)
        return true

    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.menu_del -> {
                Toast.makeText(applicationContext, "삭제 메뉴 클릭", Toast.LENGTH_SHORT).show()

            }
            R.id.menu_to_main -> {
                Toast.makeText(applicationContext, "메인 메뉴 클릭", Toast.LENGTH_SHORT).show()

            }
        }

        return super.onOptionsItemSelected(item)
    }


}