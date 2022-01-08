package com.bscexample.exam1

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.os.PersistableBundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import com.bscexample.exam1.databinding.ResultBinding


class ResultActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ResultBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val name : String? = intent.getStringExtra("name")
        val pos : String? = intent.getStringExtra("pos")
        val line : String? = intent.getStringExtra("line")

        binding.tvResult.setText("챔피언(${name})이 생성되었습니다.")
        binding.tvPos.setText("포지션 : ${pos}")
        binding.tvLine.setText("라인 : ${line}")

        binding.btnReturn.setOnClickListener {

            setResult(RESULT_OK, intent)
            finish()
        }

        binding.btnList.setOnClickListener {

            val intent : Intent = Intent(applicationContext, ListActivity::class.java)
            startActivity(intent)
        }

    }



}