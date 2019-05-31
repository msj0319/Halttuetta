package com.Halttuetta

open class delete : Word() {
    companion object {
        fun deleteStrong(Node: Word): Word? {

            Node.getparent()?.getchildlist()?.remove(Node)//단어를 삭제한다

            return Node.getparent()
        }
    }
}



