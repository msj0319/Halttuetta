package com.Halttuetta

import android.view.View

class Hide {
    companion object {
        fun ShowHide(view: View) {
            view.visibility =
                if (view.visibility == View.VISIBLE) {
                    //hide.text = "보이기"
                    View.INVISIBLE
                } else {
                    //hide.text = "가리기"
                    View.VISIBLE
                }
        }
    }
}