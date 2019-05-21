package com.Halttuetta

import android.content.Context
import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.ViewGroup
import android.widget.Button
import android.widget.LinearLayout.LayoutParams
import android.widget.LinearLayout.LayoutParams.WRAP_CONTENT
import kotlinx.android.synthetic.main.activity_main.*
import org.jetbrains.anko.toast
import java.io.Serializable

class MainActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        /*val Root = Word()
        Project.CreateTree(Root)*/
        //테스트 변수//var qustn = arrayOf("aaa", "bbb", "ccc", "ddd", "eee", "FF", "GG", "HH", "II", "JJ", "KK")
        //val word = Word("c언어", "블라블라", null, null)//word 객체
        //테스트 for문
//        for (i in 0 until qustn.size) {
//            val btn = Button(this)
//
//            btn.layoutParams = LayoutParams(WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT)
//            btn.text = qustn[i]
//
//            btn.setOnClickListener {
//                toast("눌렀어")
//                //val intent = conveyWord(this,word)
//                val intent = Intent(this, ShowActivity::class.java)
//                intent.putExtra("word", word)
//                startActivity(intent)
//            }
//            ll1.addView(btn)
//
//        }
        search.setOnClickListener {
            val intent = Intent(this, ShowActivity::class.java)
            intent.putExtra("word", word)
            startActivity(intent)
        }


    }


}






