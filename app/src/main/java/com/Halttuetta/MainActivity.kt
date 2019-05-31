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

        CreateTree(root)//기초 트리 생성

        startButton.setOnClickListener {//화면을 터치하면 다음 화면으로 넘어간다

            if (root != null) {
                Toast.makeText(applicationContext, "단어 불러오기 성공!", Toast.LENGTH_SHORT).show()
            } else {
                Toast.makeText(applicationContext, "단어 불러오기 실패", Toast.LENGTH_SHORT).show()
            }


            val intent = Intent(this, IntroActivity::class.java)
            intent.putExtra("root", root)//IntroActivity에 root 객체 보내기기
            startActivity(intent)
            finish()
        }

    }


}
