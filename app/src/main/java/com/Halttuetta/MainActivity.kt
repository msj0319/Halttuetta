package com.Halttuetta

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.ViewGroup
import android.view.ViewGroup.LayoutParams.WRAP_CONTENT
import android.widget.Button
import com.Halttuetta.Project.CreateTree
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val root = Word()
        CreateTree(root)



        //val root = intent.getSerializableExtra("root") as Word
        val childNum = intent.getSerializableExtra("child")
        if(childNum==0){

        }
        for (k in 0 until root.getchildlist().size) {//2층 갯수만큼 반복
            for (j in 0 until root?.getchildlist()?.get(k)?.getchildlist()!!.size) {
                if (root?.getchildlist()?.get(k)?.getchildlist() == null) {//2층의 자식이 null이면
                    for (i in 0 until root?.getchildlist()?.get(k)?.getchildlist()!!.size) {
                        val btn = Button(this)

                        btn.layoutParams = ViewGroup.LayoutParams(WRAP_CONTENT, WRAP_CONTENT)
                        btn.text = root.getchildlist()?.get(i)?.getname()

                        btn.setOnClickListener {
                            val intent = Intent(this, ShowActivity::class.java)
                            intent.putExtra("root", root)
                            intent.putExtra("child", i)
                            startActivity(intent)
                        }
                        ll1.addView(btn)

                    }
                    return
                }
                else{
                    val btn = Button(this)

                    btn.layoutParams = ViewGroup.LayoutParams(WRAP_CONTENT, WRAP_CONTENT)
                    btn.text = root.getchildlist()?.get(j)?.getname()

                    btn.setOnClickListener {
                        val intent = Intent(this, MainActivity::class.java)
                        intent.putExtra("root", root)
                        intent.putExtra("child", j)
                        startActivity(intent)
                    }
                    ll1.addView(btn)
                }

                if (root?.getchildlist()?.get(k)?.getchildlist()?.get(j)?.getchildlist() == null) {//3층의 자식이 null이면
                    for (i in 0 until root?.getchildlist()?.get(k)?.getchildlist()?.get(j)?.getchildlist()!!.size) {


                        val btn = Button(this)

                        btn.layoutParams = ViewGroup.LayoutParams(WRAP_CONTENT, WRAP_CONTENT)
                        btn.text = root.getchildlist()?.get(i)?.getname()

                        btn.setOnClickListener {
                            val intent = Intent(this, ShowActivity::class.java)
                            intent.putExtra("root", root)
                            intent.putExtra("child", i)
                            startActivity(intent)
                        }
                        ll1.addView(btn)


                    }
                    return
                }
                else{
                    val btn = Button(this)

                    btn.layoutParams = ViewGroup.LayoutParams(WRAP_CONTENT, WRAP_CONTENT)
                    btn.text = root.getchildlist()?.get(j)?.getname()

                    btn.setOnClickListener {
                        val intent = Intent(this, MainActivity::class.java)
                        intent.putExtra("root", root)
                        intent.putExtra("child", j)
                        startActivity(intent)
                    }
                    ll1.addView(btn)
                }
            }

        }
//        for (k in 0 until root.getchildlist().size){//2층 갯수만큼 반복
//            for (j in 0 until root?.getchildlist()?.get(k)?.getchildlist()!!.size){//2층의 자식 갯수만큼 반복
//                if(root?.getchildlist()?.get(k)?.getchildlist()?.get(j)?.getchildlist()==null){//3의 자식이 없다면
//                    for (i in 0 until root?.getchildlist()?.get(k)?.getchildlist()!!.size) {
//                        val btn = Button(this)
//
//                        btn.layoutParams = ViewGroup.LayoutParams(WRAP_CONTENT, WRAP_CONTENT)
//                        btn.text = root.getchildlist()?.get(i)?.getname()
//
//                        btn.setOnClickListener {
//                            val intent = Intent(this, ShowActivity::class.java)
//                            intent.putExtra("root", root)
//                            intent.putExtra("child",i)
//                            startActivity(intent)
//                        }
//                        ll1.addView(btn)
//
//                    }
//                }
//                else{
//                    for (i in 0 until root?.getchildlist()?.get(k)?.getchildlist()?.get(j)?.getchildlist()!!.size) {
//                        val btn = Button(this)
//
//                        btn.layoutParams = ViewGroup.LayoutParams(WRAP_CONTENT, WRAP_CONTENT)
//                        btn.text = root.getchildlist()?.get(i)?.getname()
//
//                        btn.setOnClickListener {
//                            val intent = Intent(this, ShowActivity::class.java)
//                            intent.putExtra("root", root)
//                            intent.putExtra("child",i)
//                            startActivity(intent)
//                        }
//                        ll1.addView(btn)
//
//                    }
//                }
//            }
//        }


        /*
        for (i in 0 until root.getchildlist().size) {
            val btn = Button(this)

            btn.layoutParams = ViewGroup.LayoutParams(WRAP_CONTENT, WRAP_CONTENT)
            btn.text = root.getchildlist()?.get(i)?.getname()

            btn.setOnClickListener {
                val intent = Intent(this, ShowActivity::class.java)
                intent.putExtra("root", root)
                intent.putExtra("child",i)
                startActivity(intent)
            }
            ll1.addView(btn)

        }*/


    }


}






