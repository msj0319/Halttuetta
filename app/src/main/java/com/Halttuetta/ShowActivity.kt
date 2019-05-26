package com.Halttuetta

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.activity_show.*
import org.jetbrains.anko.toast

class ShowActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_show)
        var word = intent.getSerializableExtra("root") as Word // word객체 액티비티에서 가져오기
        tv_show1.text = word.getname()
        tv_show2.text = word.getexplain()

        Hide.setOnClickListener {
            ShowHide(tv_show2)
        }

        Delete.setOnClickListener {
            var word = intent.getSerializableExtra("root") as Word
            //var word0=word.getparent()
            var word0=delete.deleteStrong(word)!!

            word.addlist(word0)

            val intent = Intent(this,ListActivity::class.java) //메인에다 보낼 단어 객체 보내기
            intent.putExtra("root", word0)
            startActivity(intent)

        }



    }

    fun ShowHide(view: View) {
        tv_show2.visibility =
            if (tv_show2.visibility == View.VISIBLE) {
                Hide.text = "보이기"
                View.INVISIBLE
            } else {
                Hide.text = "가리기"
                View.VISIBLE
            }
    }





}


