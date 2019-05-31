package com.Halttuetta

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.ViewGroup
import android.widget.Button
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_list.*
import kotlinx.android.synthetic.main.activity_main.*

class ListActivity : AppCompatActivity() {//리스트 액티비티

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_list)

        val word = intent.getSerializableExtra("root") as Word

        if (word.getname() == null) {//타이틀을 달아준다
            hierarchyTag.text = "Main"
        } else {
            hierarchyTag.text = word.getname()
        }


        for (k in 0 until word.getchildlist().size) {//단어 목록을 버튼으로 달아준다
            val btn = Button(this)

            btn.layoutParams = ViewGroup.LayoutParams(
                ViewGroup.LayoutParams.MATCH_PARENT,
                ViewGroup.LayoutParams.WRAP_CONTENT
            )
            var word = word.getchildlist()[k]

            btn.text = word.getname()

            btn.setOnClickListener {
                if (word.getexplain() != "") {//설명이 있다면==단어라면
                    val intent = Intent(this, ShowActivity::class.java)
                    intent.putExtra("root", word)
                    startActivity(intent)
                } else {//계층이라면
                    val intent = Intent(this, ListActivity::class.java)
                    intent.putExtra("root", word)
                    startActivity(intent)
                }
                finish()
            }
            ll1_list.addView(btn)
        }
        addBtn1.setOnClickListener {//추가버튼 생성
            val intent = Intent(this, AddActivity::class.java)
            intent.putExtra("root", word)
            startActivity(intent)
            finish()
        }

        pre_list.setOnClickListener {//이전 버튼 생성
            if (word.getparent()?.getparent() == null) {//만약 부모의 부모가 없다면==첫 화면
                val intent = Intent(this, IntroActivity::class.java)
                intent.putExtra("root", word.getparent())
                startActivity(intent)
                finish()
            } else {//중간 계층이라면
                val intent = Intent(this, ListActivity::class.java)
                intent.putExtra("root", word.getparent())
                startActivity(intent)
                finish()
            }

        }
    }

    override fun onBackPressed() {//뒤로가기 버튼 비활성화

        Toast.makeText(applicationContext, "비활성화", Toast.LENGTH_SHORT).show()

    }

}
