package com.Halttuetta

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.ViewGroup
import android.view.ViewGroup.LayoutParams.MATCH_PARENT
import android.view.ViewGroup.LayoutParams.WRAP_CONTENT
import android.widget.Button
import kotlinx.android.synthetic.main.activity_intro.*

class IntroActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_intro)

        var root = intent.getSerializableExtra("root") as Word //초기 DB


        for (k in 0 until root.getchildlist().size) {//2층 갯수만큼 반복
            val btn = Button(this)

            btn.layoutParams = ViewGroup.LayoutParams(MATCH_PARENT, WRAP_CONTENT)
            var word = root.getchildlist()[k]
            btn.text = word.getname()

            btn.setOnClickListener {
                if (word.getchildlist().size == 0) {
                    val intent = Intent(this, ShowActivity::class.java)
                    intent.putExtra("root", word)
                    startActivity(intent)
                } else {
                    val intent = Intent(this, ListActivity::class.java)
                    intent.putExtra("root", word)
                    startActivity(intent)
                }
            }
            ll1.addView(btn)
        }

        search_list.setOnClickListener {
            val intent = Intent(this, SearchActivity::class.java)
            intent.putExtra("root", root)
            startActivity(intent)
        }

    }


}

