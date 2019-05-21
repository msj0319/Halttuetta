package com.Halttuetta

import java.util.*

internal class Word {
    private var name: String? = null
    private var explain: String? = null
    private var parent: Word? = null
    private val childlist = Vector<Word>()

    fun addlist(Node: Word) {
        this.childlist.add(Node)
        return
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

        val level2_word1_word1 = Word("C프로그래밍", level1_word1)
        level1_word1.addlist(level2_word1_word1)
        val level2_word1_word2 = Word("컴퓨터의기원", level1_word1)
        level1_word1.addlist(level2_word1_word2)                     //1학년에서 갈라지는 2개의 가지 (C프로그래밍, 컴퓨터의 기원)

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

        val level2_word1_word1_word1 = Word("if문", "설명", level2_word1_word1)
        level2_word1_word1.addlist(level2_word1_word1_word1)
        val level2_word1_word1_word2 = Word("for문", "설명", level2_word1_word1)
        level2_word1_word1.addlist(level2_word1_word1_word2)                  //C프로그래밍 가지 (if문, 설명) Show함수 할 때 사용할것임(말단 노드란 뜻임)

        println(root.getchildlist().get(0).getname())
    }
//
//    @JvmStatic
//    fun main(args: Array<String>) {
//        val sc = Scanner(System.`in`)             //원래는  이름, 설명 받아서 새로운 Node만들도록
//        val Root = Word()
//        Project.CreateTree(Root)
//
//    }

}