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

        WordAddSubmit(word)//단어 추가 함수 호출

        pre_add.setOnClickListener {
            if (word.getparent()?.getparent() == null) {//첫 화면이라면
                val intent = Intent(this, IntroActivity::class.java)
                intent.putExtra("root", word)
                startActivity(intent)
                finish()
            } else {//중간 계층이라면
                val intent = Intent(this, ListActivity::class.java)
                intent.putExtra("root", word.getparent())
                startActivity(intent)
                finish()
            }
        }

    }


    //함수 구현
    fun WordAddSubmit(word: Word) {
        Submit_btn.setOnClickListener {
            var name = WordNameEdit?.text.toString()//이름을 받아온다
            var explain = WordExplainEdit?.text.toString()//설명을 받아온다


            if (name == "" && explain == "") {//둘다 빈칸이라면
                Toast.makeText(applicationContext, "다시 입력해 주세요", Toast.LENGTH_SHORT).show()

            } else if (name == "") {
                Toast.makeText(applicationContext, "이름을 입력해 주세요", Toast.LENGTH_SHORT).show()
            } else {


                if (explain == "") {//계층이라면 설명에 데이터를 넣지 않는다
                    var addWord0 = Word(name, "", word)//사용자에게 입력받은 이름 객체화
                    word.addlist(addWord0)//word에 추가

                    val intent = Intent(this, ListActivity::class.java) //메인에다 보낼 단어 객체 보내기
                    intent.putExtra("root", word)

                    startActivity(intent)
                    finish()
                } else {
                    var addWord0 = Word(name, explain, word)//사용자에게 입력받은 이름 설명 객체화
                    word.addlist(addWord0)//word에 추가

                    val intent = Intent(this, ListActivity::class.java) //메인에다 보낼 단어 객체 보내기
                    intent.putExtra("root", word)

                    startActivity(intent)
                    finish()
                }

            }


        }
    }

    override fun onBackPressed() {

        Toast.makeText(applicationContext, "비활성화", Toast.LENGTH_SHORT).show()

    }
}