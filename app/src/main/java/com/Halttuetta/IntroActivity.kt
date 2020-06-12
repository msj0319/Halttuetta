package com.Halttuetta

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.ViewGroup
import android.view.ViewGroup.LayoutParams.MATCH_PARENT
import android.view.ViewGroup.LayoutParams.WRAP_CONTENT
import android.widget.Button
import kotlinx.android.synthetic.main.activity_intro.*
import kotlinx.android.synthetic.main.activity_list.*

class IntroActivity : AppCompatActivity() {//첫번째 액티비티

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_intro)

        var root = intent.getSerializableExtra("root") as Word //트리 가져오기


        for (k in 0 until root.getchildlist().size) {//2층 갯수만큼 반복
            val btn = Button(this)

            btn.layoutParams = ViewGroup.LayoutParams(MATCH_PARENT, WRAP_CONTENT)//버튼 크기 설정
            var word = root.getchildlist()[k]//k번째 원소를 가져온다
            btn.text = word.getname()

            btn.setOnClickListener {//버튼마다 이벤트 리스너를 달아준다
                if (word.getchildlist().size == 0) {//자식의 수가 0이라면 == 단어라면
                    val intent = Intent(this, ShowActivity::class.java)
                    intent.putExtra("root", word)
                    startActivity(intent)
                } else {//계층이라면
                    val intent = Intent(this, ListActivity::class.java)
                    intent.putExtra("root", word)
                    startActivity(intent)
                }
            }
            ll1.addView(btn)
        }

        search_list.setOnClickListener {//검색버튼에 이벤트 리스너를 달아준다
            val intent = Intent(this, SearchActivity::class.java)
            intent.putExtra("root", root)
            startActivity(intent)
        }

        addBtn_intro.setOnClickListener {//추가버튼 생성
            val intent = Intent(this, AddActivity::class.java)
            intent.putExtra("root", root)
            startActivity(intent)
            finish()
        }

    }


}

