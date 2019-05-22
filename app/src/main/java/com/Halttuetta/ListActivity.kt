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

        val root = intent.getSerializableExtra("root") as Word
        val childNum = intent.getSerializableExtra("num")
        //hierarchyTag.text = root?.getchildlist()?.get(childNum as Int)?.getchildlist()!![0].getchildlist()!![0].getname()


        if (root.getchildlist()[childNum as Int]?.getchildlist()!!.size != 0) {//2층의 자식이 없다면, 3층까지 있는 단어
            for (j in 0 until root.getchildlist()[childNum as Int]?.getchildlist()!!.size) {
                for (k in 0 until root.getchildlist()[childNum]?.getchildlist()!!.size) {
                    val btn = Button(this)

                    btn.layoutParams = ViewGroup.LayoutParams(
                        ViewGroup.LayoutParams.WRAP_CONTENT,
                        ViewGroup.LayoutParams.WRAP_CONTENT
                    )
                    btn.text = root.getchildlist()?.get(childNum)?.getchildlist()?.get(k)?.getname()

                    btn.setOnClickListener {
                        val intent = Intent(this, ListActivity::class.java)
                        intent.putExtra("root", root)
                        //intent.putExtra("num", 2)
                        startActivity(intent)
                    }
                    ll1_list.addView(btn)
                }
            }

        } else {
            var giveName = root.getchildlist()[childNum]?.getchildlist()!![j].getchildlist()[j].getname()
            var giveExplain = root.getchildlist()[childNum]?.getchildlist()!![j].getchildlist()[j].getexplain()

            val intent = Intent(this, ShowActivity::class.java)
            intent.putExtra("root", root)
            intent.putExtra("giveName", giveName)
            intent.putExtra("giveExplain", giveExplain)
            startActivity(intent)
        }
    }


}
}
