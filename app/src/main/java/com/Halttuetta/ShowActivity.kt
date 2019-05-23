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
        val word = intent.getSerializableExtra("root") as Word
        //val childNum = intent.getSerializableExtra("child")
        //val gaveName = intent.getSerializableExtra("giveName")as String
        //val gaveExplain = intent.getSerializableExtra("giveExplain")as String
        //for (i in 0 until root.getchildlist().size) {
        //if (childNum==i){
        tv_show1.text = word.getname()
        tv_show2.text = word.getexplain()






    }

}

