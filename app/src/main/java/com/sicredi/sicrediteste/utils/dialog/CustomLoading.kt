package com.sicredi.sicrediteste.utils.dialog

import android.app.Dialog
import android.content.Context
import com.sicredi.sicrediteste.R

class CustomLoading(context: Context) : Dialog(context) {
    init {
        init()
    }
    private fun init(){
        setContentView(R.layout.loading)
        setCancelable(false)
        setCanceledOnTouchOutside(false)
    }
}