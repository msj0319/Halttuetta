package com.Halttuetta

import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_add.*
import kotlin.math.exp

class AddActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add)
        var word = intent.getSerializableExtra("root") as Word

        WordAddSubmit(word)

        pre_add.setOnClickListener {
            if (word.getparent()?.getparent() == null) {
                val intent = Intent(this, IntroActivity::class.java)
                intent.putExtra("root", word.getparent())
                startActivity(intent)
                finish()
            } else {
                val intent = Intent(this, ListActivity::class.java)
                intent.putExtra("root", word.getparent())
                startActivity(intent)
                finish()
            }
        }

    }

    fun WordAddSubmit(word: Word) {
        Submit_btn.setOnClickListener {
            var name = WordNameEdit?.text.toString()
            var explain = WordExplainEdit?.text.toString()


            if (name == "" && explain == "") {
                Toast.makeText(applicationContext, "다시 입력해 주세요", Toast.LENGTH_SHORT).show()
            } else {
                var addWord0 = Word(name, explain, word)
                word.addlist(addWord0)
                //사용자에게 입력받은 이름 설명 객체화

                val intent = Intent(this, ListActivity::class.java) //메인에다 보낼 단어 객체 보내기
                intent.putExtra("root", word)

                startActivity(intent)
                finish()
            }


        }
    }

    override fun onBackPressed() {

        Toast.makeText(applicationContext, "비활성화", Toast.LENGTH_SHORT).show()

    }
}