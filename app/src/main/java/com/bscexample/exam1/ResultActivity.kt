package com.bscexample.exam1

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.os.PersistableBundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.result.*

class ResultActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.result)
        val name : String? = intent.getStringExtra("name")
        val pos : String? = intent.getStringExtra("pos")
        val line : String? = intent.getStringExtra("line")

        tvResult.setText("챔피언(${name})이 생성되었습니다.")
        tvPos.setText("포지션 : ${pos}")
        tvLine.setText("라인 : ${line}")

        btnReturn.setOnClickListener {

            setResult(RESULT_OK, intent)
            finish()
        }

        btnList.setOnClickListener {

            val intent : Intent = Intent(applicationContext, ListActivity::class.java)
            startActivity(intent)
        }

    }



}