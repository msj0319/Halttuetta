package com.Halttuetta

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.Halttuetta.Hide.Companion.ShowHide
import kotlinx.android.synthetic.main.activity_show.*


class ShowActivity : AppCompatActivity() {//보여주기 액티비티

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_show)

        var word = intent.getSerializableExtra("root") as Word
        var count = 0//숨기기 기능 구현을 위한 변수

        tv_show1.text = word.getname()
        tv_show2.text = word.getexplain()

        Hide.setOnClickListener {
            if (count % 2 == 0) {
                ShowHide(tv_show2)
                Hide.text = "보이기"
                count++
            } else if (count % 2 == 1) {
                ShowHide(tv_show2)
                Hide.text = "가리기"
                count--
            }
        }

        Delete.setOnClickListener {//삭제 구현
            var word_delete = delete.deleteStrong(word)!!

            word.addlist(word_delete)

            val intent = Intent(this, ListActivity::class.java)
            intent.putExtra("root", word_delete)

            startActivity(intent)

        }

        pre_show.setOnClickListener {//보여주기 버튼리스너
            val intent = Intent(this, ListActivity::class.java)
            intent.putExtra("root", word.getparent())
            startActivity(intent)
            finish()
        }


        Modify.setOnClickListener {//수정하기 버튼리스너
            val intent = Intent(this, ModifyActivity::class.java)
            intent.putExtra("root", word)

            startActivity(intent)
            finish()
        }


    }

    override fun onBackPressed() {

        Toast.makeText(applicationContext, "비활성화", Toast.LENGTH_SHORT).show()

    }


}


