package com.Halttuetta

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.activity_show.*
import org.jetbrains.anko.toast
import java.lang.String

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
            //var word = intent.getSerializableExtra("root") as Word
            //var word0=word.getparent()
            var word_delete=delete.deleteStrong(word)!!

            word.addlist(word_delete)

            val intent = Intent(this,ListActivity::class.java) //메인에다 보낼 단어 객체 보내기
            intent.putExtra("root", word_delete)

            startActivity(intent)
            //finish()

            //super.onDestroy()
        }
        pre_show.setOnClickListener{
            val intent = Intent(this, ListActivity::class.java)
            intent.putExtra("root", word.getparent())
            startActivity(intent)
            finish()
        }
        //수정하기 버튼 클릭시 리스너
        Modify.setOnClickListener{
            val intent = Intent(this, ModifyActivity::class.java)
            intent.putExtra("root", word)


            startActivity(intent)
            finish()
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
    override fun onBackPressed() {

        Toast.makeText(applicationContext, "비활성화", Toast.LENGTH_SHORT).show()

    }




}


