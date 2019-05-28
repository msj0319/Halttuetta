package com.Halttuetta

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.Halttuetta.Project.CreateTree
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var root = Word()
        var nadan = Word()// 나만의 단어장

        CreateTree(root)

        startButton.setOnClickListener {
            val intent = Intent(this,IntroActivity::class.java) //메인에다 보낼 단어 객체 보내기
            intent.putExtra("root", root)

            startActivity(intent)
            finish()
        }

    }

}
