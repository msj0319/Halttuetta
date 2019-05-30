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

class SearchActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_search)

        val word = intent.getSerializableExtra("root") as Word

        bt_search.setOnClickListener {
            ll_search.removeAllViews()

            var searchWord = java.lang.String.valueOf(et_search.text)

            Search(word, searchWord)
        }

        bt_searchback.setOnClickListener {
            val intent = Intent(this, IntroActivity::class.java)
            intent.putExtra("root", word)//루트의 자식의 0번 1번 2번의 word를 버튼에 넘긴다
            //intent.putExtra("num", k)
            startActivity(intent)
        }

    }


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

    fun Search(root: Word, key: String) {
        //Key 값 받아야함

        val List = Vector<Word>()
        for (i in 0 until root.getchildlist().size) {

            SearchWord(root.getchildlist()[i], List, key)
        }

        if (List.size == 0) {
            Toast.makeText(applicationContext, "찾는 단어가 없습니다.", Toast.LENGTH_SHORT).show()
            return
        }

        //보여주기
        for (k in 0 until List.size) {
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

    override fun onBackPressed() {

        Toast.makeText(applicationContext, "비활성화", Toast.LENGTH_SHORT).show()

    }
}
