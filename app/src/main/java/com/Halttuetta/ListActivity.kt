package com.Halttuetta

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.ViewGroup
import android.widget.Button
import kotlinx.android.synthetic.main.activity_list.*
import kotlinx.android.synthetic.main.activity_main.*

class ListActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_list)

        val word = intent.getSerializableExtra("root") as Word

        for (k in 0 until word.getchildlist().size) {//2층 갯수만큼 반복
            val btn = Button(this)

            btn.layoutParams = ViewGroup.LayoutParams(
                ViewGroup.LayoutParams.WRAP_CONTENT,
                ViewGroup.LayoutParams.WRAP_CONTENT
            )
            var word = word.getchildlist()[k]
            btn.text = word.getname()


            btn.setOnClickListener {
                if (word.getchildlist().size == 0) {
                    val intent = Intent(this, ShowActivity::class.java)
                    intent.putExtra("root", word)//루트의 자식의 0번 1번 2번의 word를 버튼에 넘긴다
                    //intent.putExtra("num", k)
                    startActivity(intent)
                } else {
                    val intent = Intent(this, ListActivity::class.java)
                    intent.putExtra("root", word)//루트의 자식의 0번 1번 2번의 word를 버튼에 넘긴다
                    //intent.putExtra("num", k)
                    startActivity(intent)
                }
            }
            ll1_list.addView(btn)
        }
        addBtn1.setOnClickListener {
            val intent = Intent(this, AddActivity::class.java)
            intent.putExtra("root", word)
            startActivity(intent)
        }
    }
}
