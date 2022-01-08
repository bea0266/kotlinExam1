package com.bscexample.exam1

import android.app.Activity
import android.os.Bundle
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import android.widget.ArrayAdapter
import android.widget.LinearLayout
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.bscexample.exam1.databinding.ListBinding


class ListActivity : AppCompatActivity() {

    val data = mutableListOf<Hero>()
    var adapter = CustomAdapter()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ListBinding.inflate(layoutInflater)
        setContentView(binding.root)






        binding.recyclerview.adapter = adapter
        binding.recyclerview.layoutManager = LinearLayoutManager(this)
        var helper : DBHelper = execHelper()
        getHeroes(helper)

        binding.btnMain.setOnClickListener {
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

            adapter.loadData(cursor.getString(0), cursor.getString(1), cursor.getString(2))


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