package com.Halttuetta

import android.content.Context
import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.ViewGroup
import android.widget.Button
import android.widget.LinearLayout
import android.widget.LinearLayout.LayoutParams
import android.widget.LinearLayout.LayoutParams.WRAP_CONTENT
import kotlinx.android.synthetic.main.activity_main.*
import org.jetbrains.anko.toast

class MainActivity : AppCompatActivity() {

    var context : Context? = null
    var cnt:Int=0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        item1.setOnClickListener {
            //toast("눌렀어")
            val intent:Intent = Intent(this, ShowActivity::class.java)
            startActivity(intent)
        }



        bt1.setOnClickListener {
            val btn = Button(this)
            // setting layout_width and layout_height using layout parameters
            btn.layoutParams = LayoutParams(WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT)
            btn.text = "Dynamic Button"
            // add Button to LinearLayout
            //for(i in 1..3) {
                ll1.addView(btn)
            //}
        }
        // creating the button




    }





}
