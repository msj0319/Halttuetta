package com.Halttuetta

import android.content.Context
import android.content.Intent
import java.io.Serializable
import java.util.*
import org.jetbrains.anko.db.NULL


open class delete  : Word() {


    companion object  {
        fun deleteStrong ( Node : Word) : Word? {


            //Node.parent_childlist()?.remove(Node)
            Node.getparent()?.getchildlist()?.remove(Node)

            return Node.getparent()

        }
    }
}



