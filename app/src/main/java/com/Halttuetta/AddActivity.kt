package com.Halttuetta

import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_add.*

class AddActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add)

        WordAddSubmit()

    }
    fun WordAddSubmit(){
        Submit_btn.setOnClickListener {
            var name = WordNameEdit?.text.toString()
            var explain = WordExplainEdit?.text.toString()

            val word = Words(name,explain,null,null) //사용자에게 입력받은 이름 설명 객체화

            val intent2 = Intent(this,MainActivity::class.java) //메인에다 보낼 단어 객체 보내기
            intent2.putExtra("word",word)
            intent2.putExtra("statuscode",1)

//            var intent3 = Intent(this,ShowActivity::class.java) //Show에다 보낼 단어 객체 보내기
//            intent3.putExtra("word",word)
//            intent3.putExtra("num",2)

            startActivity(intent2)
            //startActivity(intent3)
        }
    }
}