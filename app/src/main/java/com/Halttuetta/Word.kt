package com.Halttuetta

import android.content.Context
import android.content.Intent
import java.io.Serializable
import java.util.*

data class Word(
    var name : String? = null,
    var explain : String? = null,
    var parent : Word? = null,
    var childlist : Vector<Word>? = null


):Serializable


//}class Word constructor(_name:String,_explain : String,_parent : Word?,_childlist : Vector<Word>?):Serializable{
//    var name : String
//    var explain : String
//    var parent : Word?
//    var childlist : Vector<Word>?
//
//    init {
//        name = _name
//        explain = _explain
//        parent = _parent
//        childlist = _childlist
//    }
//}
//fun conveyWord(context: Context?, word: Word): Intent {
//    val intent = Intent(context, ShowActivity::class.java)
//    intent.putExtra("word", word)
//    return intent
//}