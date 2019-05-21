package com.Halttuetta

import android.content.Intent
import android.content.Intent.getIntent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_show.*
import org.jetbrains.anko.toast

class ShowActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_show)
        val word1 = intent.getSerializableExtra("word") as Word
        var test = word1?.name
        if (test != null) {
            toast("성공")
        }
        else{
            toast("안넘어옴")
        }
        tv_show1.text = word1?.name

        tv_show2.text = word1?.explain

    }

}

