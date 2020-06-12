package com.Halttuetta

import android.content.Intent
import java.io.Serializable
import java.util.*

open class Word : Serializable {
    private var name: String? = null
    private var explain: String? = null
    private var parent: Word? = null
    private val childlist = Vector<Word>()

    fun addlist(Node: Word) {
        this.childlist.add(Node)
        return
    }

    fun getparent(): Word? {
        return this.parent
    }


    fun getchildlist(): Vector<Word> {
        return this.childlist
    }

    fun getname(): String? {
        return this.name
    }

    fun getexplain(): String? {
        return this.explain
    }

    //이름 설정
    fun setName(name: String) {
        this.name = name
    }

    //설명 설정
    fun setExplain(explain: String) {
        this.explain = explain
    }


    constructor() {}
    constructor(name: String, parent: Word) {                  //이름만 있는경우(부모 계층)
        this.name = name
        this.explain = ""
        this.parent = parent
    }

    constructor(name: String, explain: String, parent: Word) {         //이름,설명만 있는경우(말단노드)
        this.name = name
        this.explain = explain
        this.parent = parent
    }
}

internal class Create {
    fun create(name: String, explain: String, parent: Word) {  //부모 노드도 가져와야함 parent가 부모노드
        val Node = Word(name, explain, parent)
        parent.addlist(Node)

    }
}


object Project {
    internal fun CreateTree(root: Word) {                  //어플 실행 전 트리를 구축하는 함수
        val level1_word1 = Word("1학년", root)
        root.addlist(level1_word1)
        val level1_word2 = Word("2학년", root)
        root.addlist(level1_word2)
        val level1_word3 = Word("3학년", root)
        root.addlist(level1_word3)                     //root에서 갈라지는 3개의 가지들 (1학년,2학년,3학년)
        //1층
        val level2_word1_word1 = Word("C프로그래밍", level1_word1)
        level1_word1.addlist(level2_word1_word1)
        val level2_word1_word2 = Word("컴퓨터의기원", level1_word1)
        level1_word1.addlist(level2_word1_word2)                     //1학년에서 갈라지는 2개의 가지 (C프로그래밍, 컴퓨터의 기원)
        //2층
        val level2_word2_word1 = Word("자료구조", level1_word2)
        level1_word2.addlist(level2_word2_word1)
        val level2_word2_word2 = Word("이산수학", level1_word2)
        level1_word2.addlist(level2_word2_word2)
        val level2_word2_word3 = Word("데이터베이스", level1_word2)
        level1_word2.addlist(level2_word2_word3)                     //2학년에서 갈라지는 3개의 가지 (자료구조, 이산수학, 데이터베이스)

        val level2_word3_word1 = Word("운영체제", level1_word3)
        level1_word3.addlist(level2_word3_word1)
        val level2_word3_word2 = Word("컴퓨터네트워크", level1_word3)
        level1_word3.addlist(level2_word3_word2)                           //3학년에서 갈라지는 2개의 가지(운영체제, 컴퓨터네트워크)
        //3층
        val level2_word1_word1_word1 = Word(
            "if문", "1. \"제어문\" 이란 무엇인가?\n" +
                    " \n" +
                    "    \"제어문은 프로그램의 실행 흐름을 제어하는 문법입니다.\"\n" +
                    " \n" +
                    "    프로그램은 일반적으로 나열된 명령문을 순차적으로 실행합니다. 이렇게 순차적으로 수행하는것은\n" +
                    "    작업이 매우 단순하거나 예외가 없는 경우에는 사용에 문제가 없지만, 특정작업을 반복적으로 수행\n" +
                    "    해야하거나 예외를 처리해야하는 경우가 발생하면 매우 비효율적이게 됩니다. 그래서 좀더 효과적인\n" +
                    "    문장표현을 위해서 C/C++ 언어에서는 아래와 같이 두가지 형태의 제어문을 제공합니다.\n" +
                    " \n" +
                    "    1.1 \"조건문\" -  예외적 사항에 대처하기 위한 문법\n" +
                    " \n" +
                    "         조건문은 말그대로 특정 조건을 부여하고 해당 조건이 만족되면 지정한 문장을 수행하는 문법입니다.\n" +
                    "         일반적으로 조건은 수식으로 주어지며 이 수식의 진리값이 참(TRUE)이면 지정된 문장을 수행하게\n" +
                    "         됩니다. C/C++ 언어에서는 if, switch 와 같은 문법이 조건문에 해당합니다.\n" +
                    " \n" +
                    "    1.2 \"반복문\" -  반복적인 행위를 효과적으로 표한하기 위한 문법\n" +
                    " \n" +
                    "         일정한 형태의 작업이 반복적으로 수행해야하는 경우, 반복 조건을 부여하고 해당 조건이\n" +
                    "         만족할때까지 계속 특정문장이 수행되도록 하는 문법입니다. C/C++ 언어에서는 for, while,\n" +
                    "         do ~ while, goto 와 같은 문법이 반복문에 해당합니다.\n" +
                    " \n" +
                    " \n" +
                    "2. \"if 조건문\" 에 대하여...\n" +
                    " \n" +
                    "    C/C++ 언어에서 가장 자주 사용되는 제어문이 바로 if 문 입니다. if 문은 기본적으로 아래와 같은\n" +
                    "    형식으로 구성됩니다.\n" +
                    " \n" +
                    "    if ( 조건수식 )\n" +
                    "            조건 만족시 수행할 명령문;", level2_word1_word1
        )
        level2_word1_word1.addlist(level2_word1_word1_word1)
        val level2_word1_word1_word2 = Word(
            "for문",
            "컴퓨터 프로그래밍에서 for 루프는 반복문의 일종으로, 특정한 부분의 코드가 반복적으로 수행될 수 있도록 한다. for 루프는 while 루프와 같은 다른 반복문과는 달리 일반적으로 해당 루프에 연계된 루프 변수가 존재하며, 그 변수의 비교 및 증감을 위해서 별도의 문법을 할애한 점이 구분된다.\n" +
                    "\n" +
                    "for 루프의 이름은 영어 표현 “For …, do …”(…동안 …를 하라)에서 유래하였다. 포트란과 같은 언어에서는 for 대신 do 예약어를 사용하며 그 문법의 이름도 do 루프이지만, 이를 제외하고는 for 루프와 큰 차이가 없다.",
            level2_word1_word1
        )
        level2_word1_word1.addlist(level2_word1_word1_word2)                  //C프로그래밍 가지 (if문, 설명) Show함수 할 때 사용할것임(말단 노드란 뜻임)

    }


}
