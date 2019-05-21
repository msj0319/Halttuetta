package com.Halttuetta

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.ViewGroup
import android.widget.Button
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.activity_show.*
import org.jetbrains.anko.toast

class ShowActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_show)
        val root = intent.getSerializableExtra("root") as Word
        val childNum = intent.getSerializableExtra("child")
        //for (i in 0 until root.getchildlist().size) {
        //if (childNum==i){
        tv_show1.text = root?.getchildlist()?.get(childNum as Int)?.getname()
        //tv_show2.text = root?.getchildlist()?.get(i)?.getchildlist()?.get(i)?.getname()



        for (j in 0 until root.getchildlist()?.get(childNum as Int)?.getchildlist()?.size!!) {//자식 수 만큼 반복
            val btn = Button(this)

            btn.layoutParams = ViewGroup.LayoutParams(
                ViewGroup.LayoutParams.WRAP_CONTENT,
                ViewGroup.LayoutParams.WRAP_CONTENT
            )
            btn.text = root?.getchildlist()?.get(j)?.getchildlist()?.get(j)?.getname()//자식의 이름 받아온다

            btn.setOnClickListener {
                val intent = Intent(this, ShowActivity::class.java)
                intent.putExtra("root", root)
                intent.putExtra("child", j)
                startActivity(intent)
            }
            ll1.addView(btn)

        }
        //}


        //}


        /*
        if (one != null) {
            toast("성공")
        }
        else{
            toast("안넘어옴")
        }
        tv_show1.text = one

        tv_show2.text = two*/

    }

}

