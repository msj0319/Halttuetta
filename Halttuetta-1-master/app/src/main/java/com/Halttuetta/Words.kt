package com.Halttuetta

import java.io.Serializable
import java.util.*

class Words(
    var name : String? ,
    var explain : String? ,
    var parent : Words? ,
    var childlist : Vector<Words>?
):Serializable
