package com.Halttuetta

import android.app.ProgressDialog.show
import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.ViewGroup
import android.view.ViewGroup.LayoutParams.WRAP_CONTENT
import android.widget.Button
import com.Halttuetta.Project.CreateTree
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.activity_show.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        var root = Word()
        var nadan = Word()// 나만의 단어장

        CreateTree(root)

        var word: Words? = null
        var statuscode =intent.getIntExtra("statuscode",0) //상태코드 0 초기화. 인텐트 보낼때 함께 보내기

        if(statuscode == 1) {  //ADD에서 보낸 단어 객체가 도착했다면. 버튼 이름을 추가한 단어이름으로 변경.
            val addedbtn = Button(this) //버튼 객체 생성
            addedbtn.layoutParams = ViewGroup.LayoutParams(WRAP_CONTENT, WRAP_CONTENT)

            word = intent.getSerializableExtra("word") as Words
            addedbtn.text = word.name

            //submit 버튼을 누른만큼 추가된 단어 버튼 출력해야함.
            //기존 단어를 보려고 할 때 단어정보가 출력이 안되는 버그.
            addedbtn.setOnClickListener {  //생성된 단어 버튼 클릭하면 ShowActivity 실행, 추가한 단어 정보 출력
                val intent = Intent(this, ShowActivity::class.java)
                intent.putExtra("word", word)
                intent.putExtra("statuscode",3)
                startActivity(intent)
            }
            ll1.addView(addedbtn)
        }

        for (k in 0 until root.getchildlist().size) {//2층 갯수만큼 반복
            val btn = Button(this)

            btn.layoutParams = ViewGroup.LayoutParams(WRAP_CONTENT, WRAP_CONTENT)
            var word = root.getchildlist()[k]
            btn.text = word.getname()

            btn.setOnClickListener {
                if(word.getchildlist().size==0) {
                    val intent = Intent(this, ShowActivity::class.java)
                    intent.putExtra("root", word)//루트의 자식의 0번 1번 2번의 word를 버튼에 넘긴다
                    //intent.putExtra("num", k)
                    startActivity(intent)
                }
                else{
                    val intent = Intent(this, ListActivity::class.java)
                    intent.putExtra("root", word)//루트의 자식의 0번 1번 2번의 word를 버튼에 넘긴다
                    //intent.putExtra("num", k)
                    startActivity(intent)
                }
            }
            ll1.addView(btn)
        }

        //추가 버튼 리스너
        addbtn.setOnClickListener {
            val addintent = Intent(this, AddActivity::class.java)
            startActivity(addintent)
        }
    }
}


//        for (k in 0 until root.getchildlist().size) {//2층 갯수만큼 반복
//            if (root?.getchildlist()?.get(k)?.getchildlist() == null) {//2층의 자식이 null이라면, 3층까지 있는 단어
//                for (i in 0 until root?.getchildlist().size) {
//                    val btn = Button(this)
//
//                    btn.layoutParams = ViewGroup.LayoutParams(WRAP_CONTENT, WRAP_CONTENT)
//                    btn.text = root.getchildlist()?.get(i)?.getname()
//
//                    btn.setOnClickListener {
//                        val intent = Intent(this, MainActivity::class.java)
//                        intent.putExtra("root", root)
//                        intent.putExtra("child", i)
//                        startActivity(intent)
//                    }
//                    ll1.addView(btn)
//                }
//                return
//            } else {//4층까지 있는 단어
//                for (i in 0 until root?.getchildlist()?.get(k)?.getchildlist()!!.size) {
//                    val intent = Intent(this, ShowActivity::class.java)
//                    intent.putExtra("root", root)
//                    intent.putExtra("child", i)
//                    startActivity(intent)
//
//
//                }
//            }
//        }
//    }
//}


// for (j in 0 until root?.getchildlist()?.get(k)?.getchildlist()!!.size) {
//
// else{
// val btn = Button(this)
//
// btn.layoutParams = ViewGroup.LayoutParams(WRAP_CONTENT, WRAP_CONTENT)
// btn.text = root.getchildlist()?.get(j)?.getname()
//
// btn.setOnClickListener {
// val intent = Intent(this, MainActivity::class.java)
// intent.putExtra("root", root)
// intent.putExtra("child", j)
// startActivity(intent)
// }
// ll1.addView(btn)
// }
//
// if (root?.getchildlist()?.get(k)?.getchildlist()?.get(j)?.getchildlist() == null) {//3층의 자식이 null이면
// for (i in 0 until root?.getchildlist()?.get(k)?.getchildlist()?.get(j)?.getchildlist()!!.size) {
//
//
// val btn = Button(this)
//
// btn.layoutParams = ViewGroup.LayoutParams(WRAP_CONTENT, WRAP_CONTENT)
// btn.text = root.getchildlist()?.get(i)?.getname()
//
// btn.setOnClickListener {
// val intent = Intent(this, ShowActivity::class.java)
// intent.putExtra("root", root)
// intent.putExtra("child", i)
// startActivity(intent)
// }
// ll1.addView(btn)
//
//
// }
// return
// } else {
// val btn = Button(this)
//
// btn.layoutParams = ViewGroup.LayoutParams(WRAP_CONTENT, WRAP_CONTENT)
// btn.text = root.getchildlist()?.get(j)?.getname()
//
// btn.setOnClickListener {
// val intent = Intent(this, MainActivity::class.java)
// intent.putExtra("root", root)
// intent.putExtra("child", j)
// startActivity(intent)
// }
// ll1.addView(btn)
// }
// }
//
// }
// //        for (k in 0 until root.getchildlist().size){//2층 갯수만큼 반복
// //            for (j in 0 until root?.getchildlist()?.get(k)?.getchildlist()!!.size){//2층의 자식 갯수만큼 반복
// //                if(root?.getchildlist()?.get(k)?.getchildlist()?.get(j)?.getchildlist()==null){//3의 자식이 없다면
// //                    for (i in 0 until root?.getchildlist()?.get(k)?.getchildlist()!!.size) {
// //                        val btn = Button(this)
// //
// //                        btn.layoutParams = ViewGroup.LayoutParams(WRAP_CONTENT, WRAP_CONTENT)
// //                        btn.text = root.getchildlist()?.get(i)?.getname()
// //
// //                        btn.setOnClickListener {
// //                            val intent = Intent(this, ShowActivity::class.java)
// //                            intent.putExtra("root", root)
// //                            intent.putExtra("child",i)
// //                            startActivity(intent)
// //                        }
// //                        ll1.addView(btn)
// //
// //                    }
// //                }
// //                else{
// //                    for (i in 0 until root?.getchildlist()?.get(k)?.getchildlist()?.get(j)?.getchildlist()!!.size) {
// //                        val btn = Button(this)
// //
// //                        btn.layoutParams = ViewGroup.LayoutParams(WRAP_CONTENT, WRAP_CONTENT)
// //                        btn.text = root.getchildlist()?.get(i)?.getname()
// //
// //                        btn.setOnClickListener {
// //                            val intent = Intent(this, ShowActivity::class.java)
// //                            intent.putExtra("root", root)
// //                            intent.putExtra("child",i)
// //                            startActivity(intent)
// //                        }
// //                        ll1.addView(btn)
// //
// //                    }
// //                }
// //            }
// //        }
//
//
// /*
// for (i in 0 until root.getchildlist().size) {
// val btn = Button(this)
//
// btn.layoutParams = ViewGroup.LayoutParams(WRAP_CONTENT, WRAP_CONTENT)
// btn.text = root.getchildlist()?.get(i)?.getname()
//
// btn.setOnClickListener {
// val intent = Intent(this, ShowActivity::class.java)
// intent.putExtra("root", root)
// intent.putExtra("child",i)
// startActivity(intent)
// }
// ll1.addView(btn)
//
// }