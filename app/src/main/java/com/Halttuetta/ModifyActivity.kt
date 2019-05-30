package com.Halttuetta

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_modify.*
import kotlinx.android.synthetic.main.activity_show.*
import kotlinx.android.synthetic.main.activity_show.Delete
import kotlinx.android.synthetic.main.activity_show.Hide
import kotlinx.android.synthetic.main.activity_show.tv_show1
import kotlinx.android.synthetic.main.activity_show.tv_show2
import kotlin.String as String1

class ModifyActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_modify)

        var word = intent.getSerializableExtra("root") as Word // word객체 액티비티에서 가져오기

        tv_show1.text = word.getname() // 이름칸에 해당 word의 이름 출력
        tv_show2.text = word.getexplain() // 설명칸에 해당 word의 설명 출력

        Delete.setOnClickListener {
            //취소버튼

            val intent = Intent(this, ShowActivity::class.java)
            intent.putExtra("root", word)

            startActivity(intent) //인텐트 실행
            finish()
        }

        Hide.setOnClickListener {
            //확인버튼
            val intent = Intent(this, ShowActivity::class.java)

            word.setName(String.valueOf(tv_show1.text)) //tv_show1.getText() 코틀린 상에서 해당 코드 동작시 캐스트오류(자료형 오류)발생, String.valueOf로 한번 더 감싸준다
            word.setExplain(String.valueOf(tv_show2.text))


            intent.putExtra("root", word)

            startActivity(intent)
        }
    }
}
