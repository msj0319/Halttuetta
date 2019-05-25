package com.Halttuetta

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.ViewGroup
import android.widget.Button
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.activity_show.*
import org.jetbrains.anko.toast

class ShowActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_show)
        var word: Words? = null
        var statuscode=intent.getIntExtra("statuscode",0)

        if(statuscode == 3) {
            word = intent.getSerializableExtra("word") as Words

            tv_show1.text = word.name
            tv_show2.text = word.explain

        }
    }

}

