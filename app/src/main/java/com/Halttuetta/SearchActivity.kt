package com.Halttuetta

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.ViewGroup
import android.widget.Button
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_intro.*
import kotlinx.android.synthetic.main.activity_list.*
import kotlinx.android.synthetic.main.activity_search.*
import kotlinx.android.synthetic.main.activity_show.*
import java.util.*

class SearchActivity : AppCompatActivity() {//검색 액티비티

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_search)

        val word = intent.getSerializableExtra("root") as Word

        bt_search.setOnClickListener {
            ll_search.removeAllViews()//검색 리스트 초기화

            var searchWord = java.lang.String.valueOf(et_search.text)//edittext에서 검색할 단어를 받아온다

            Search(word, searchWord)//word에서 입력된 단어를 찾는다
        }

        bt_searchback.setOnClickListener {
            val intent = Intent(this, IntroActivity::class.java)
            intent.putExtra("root", word)
            startActivity(intent)
        }

    }


    //함수 구현
    fun SearchWord(word: Word, List: Vector<Word>, key: String) {
        if (word.getname()!!.contains(key)) {
            List.add(word)
        }

        if (word.getchildlist().size != 0) {
            for (i in 0 until word.getchildlist().size) {
                SearchWord(word.getchildlist()[i], List, key)
            }
        }
    }

    fun Search(root: Word, key: String) {//검색 함수

        val List = Vector<Word>()//찾은 단어를 저장 할 Vecter 선언

        if (key == "") {
            Toast.makeText(applicationContext, "검색 할 단어를 입력해 주세요", Toast.LENGTH_SHORT).show()

        } else {
            for (i in 0 until root.getchildlist().size) {//단어를 찾아 List에 넣는다
                SearchWord(root.getchildlist()[i], List, key)
            }

            if (List.size == 0) {//만약 List 사이즈가 0이라면==단어가 없다면
                Toast.makeText(applicationContext, "찾는 단어가 없습니다.", Toast.LENGTH_SHORT).show()
                return//찾는 단어가 없으므로 종료
            }


            for (k in 0 until List.size) {//List에서 단어를 받아 버튼을 만들어 준다
                val btn = Button(this)

                btn.layoutParams = ViewGroup.LayoutParams(
                    ViewGroup.LayoutParams.MATCH_PARENT,
                    ViewGroup.LayoutParams.WRAP_CONTENT
                )

                btn.text = List[k].getname()
                var word = List[k]

                btn.setOnClickListener {
                    if (word.getexplain() != "") {
                        val intent = Intent(this, ShowActivity::class.java)
                        intent.putExtra("root", word)
                        startActivity(intent)
                    } else {
                        val intent = Intent(this, ListActivity::class.java)
                        intent.putExtra("root", word)
                        startActivity(intent)
                    }
                    finish()
                }
                ll_search.addView(btn)
            }
        }

    }

    override fun onBackPressed() {

        Toast.makeText(applicationContext, "비활성화", Toast.LENGTH_SHORT).show()

    }
}
