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
        var word = intent.extras.get("word") as? Word
        //var name = word?.name
        //var name = intent.extras.get("word") as? Word
        //var explain = word?.explain
        //var explain = intent.extras.get("word") as? Word
        tv_show1.text = intent.getStringExtra(word?.name)

        tv_show2.text = intent.getStringExtra(word?.explain)
        //tv_show2.text = intent.getStringExtra("설명들")
        /* "nameKey"라는 이름의 key에 저장된 값이 있다면
           textView의 내용을 "nameKey" key에서 꺼내온 값으로 바꾼다 */


    }

}
//class ShowActivity : AppCompatActivity() {
//
//    override fun onCreate(savedInstanceState: Bundle?) {
//        super.onCreate(savedInstanceState)
//        setContentView(R.layout.activity_show)
//        if (intent.hasExtra("wordName")) {
//            tv_show1.text = intent.getStringExtra("wordName")
//            tv_show2.text = intent.getStringExtra("설명들")
//            /* "nameKey"라는 이름의 key에 저장된 값이 있다면
//               textView의 내용을 "nameKey" key에서 꺼내온 값으로 바꾼다 */
//
//        } else {
//            toast("전달된 메세지가 없습니다.")
//        }
//    }
//
//}

