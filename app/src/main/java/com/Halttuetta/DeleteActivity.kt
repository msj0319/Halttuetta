package com.Halttuetta

open class delete : Word() {
    companion object {
        fun deleteStrong(Node: Word): Word? {

            Node.getparent()?.getchildlist()?.remove(Node)

            return Node.getparent()
        }
    }
}



