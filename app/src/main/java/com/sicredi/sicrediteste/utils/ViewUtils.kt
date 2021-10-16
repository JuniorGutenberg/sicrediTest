package com.sicredi.sicrediteste.utils

import android.content.Context
import android.util.Log
import com.sicredi.sicrediteste.utils.dialog.CustomLoading
import java.lang.Exception

class ViewUtils {
    companion object{
        private var customLoading: CustomLoading? = null

        fun loading(context: Context){
            try {
                dismissLoading()
                customLoading = CustomLoading(context)
                customLoading!!.show()
            }catch (e: Exception){
                Log.e("Error Loading: ", e.message.toString())
            }
        }

        fun dismissLoading() {
            try {
                customLoading?.dismiss()
            } catch (e: Exception) {
                Log.e("Error Dismiss: ", e.message.toString())
            } finally {
                customLoading = null
            }
        }
    }
}