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
        var word = intent.getSerializableExtra("root") as Word // word객체 액티비티에서 가져오기
        tv_show1.text = word.getname()
        tv_show2.text = word.getexplain()

    }
}

