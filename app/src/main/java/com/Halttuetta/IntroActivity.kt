package com.Halttuetta

import android.app.ProgressDialog.show
import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.ViewGroup
import android.view.ViewGroup.LayoutParams.MATCH_PARENT
import android.view.ViewGroup.LayoutParams.WRAP_CONTENT
import android.widget.Button
import android.widget.Toast
import com.Halttuetta.Project.CreateTree
import kotlinx.android.synthetic.main.activity_intro.*
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.activity_show.*

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
                if(word.getchildlist().size==0) {
                    val intent = Intent(this, ShowActivity::class.java)
                    intent.putExtra("root", word)//루트의 자식의 0번 1번 2번의 word를 버튼에 넘긴다
                    //intent.putExtra("num", k)
                    startActivity(intent)
                }
                else{
                    val intent = Intent(this, ListActivity::class.java)
                    intent.putExtra("root", word)//루트의 자식의 0번 1번 2번의 word를 버튼에 넘긴다
                    //intent.putExtra("num", k)
                    startActivity(intent)
                }
                //finish()
            }
            ll1.addView(btn)
        }

    }







}

