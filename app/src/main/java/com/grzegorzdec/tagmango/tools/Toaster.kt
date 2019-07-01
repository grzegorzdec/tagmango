package com.grzegorzdec.tagmango.tools

import android.content.Context
import android.widget.Toast
import androidx.annotation.StringRes

class Toaster(private val context: Context) {

    fun show(message: String) {
        Toast.makeText(context, message, Toast.LENGTH_LONG).show()
    }

    fun show(@StringRes resId: Int) {
        show(context.resources.getString(resId))
    }
}