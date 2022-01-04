package com.bscexample.exam1

import android.content.Intent
import android.database.sqlite.SQLiteDatabase
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.activity.result.ActivityResultLauncher
import androidx.activity.result.contract.ActivityResultContract
import androidx.activity.result.contract.ActivityResultContracts
import kotlinx.android.synthetic.main.activity_main.*
private lateinit var getResult: ActivityResultLauncher<Intent>
class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)



        getResult = registerForActivityResult(ActivityResultContracts.StartActivityForResult()) {
            if(it.resultCode == RESULT_OK) {

                Toast.makeText(applicationContext, "챔피언이 생성되었습니다.", Toast.LENGTH_SHORT).show()


            }

        }


        btnCreate.setOnClickListener {

            var name: String = edtName.getText().toString()
            var pos: String = edtPos.getText().toString()
            var line: String = edtLine.getText().toString()

            var hero: Hero = Hero(name, pos, line)
            hero.printInfo()

            var helper : DBHelper = execHelper(name, pos, line)
            insertHero(helper, name, pos, line)
            moveToResultActivity(name, pos, line)


        }


    }


    private fun moveToResultActivity(name: String, pos: String, line: String){



        val intent : Intent = Intent(applicationContext, ResultActivity::class.java)
        intent.putExtra("name", name)
        intent.putExtra("pos", pos)
        intent.putExtra("line", line)

        getResult.launch(intent)

    }
    private fun execHelper(name: String, pos: String, line: String) : DBHelper {


        val helper : DBHelper = DBHelper(applicationContext, "game", null, 1 )

        return helper

    }

    private fun insertHero(dbHelper: DBHelper , name: String, pos: String, line: String){

        var wdb : SQLiteDatabase = dbHelper.writableDatabase
        wdb.execSQL("INSERT INTO hero (name, pos, line) VALUES ('${name}', '${pos}', '${line}');")
        Log.d("exec-insert-sql", "success" )

        wdb.close()

    }





}