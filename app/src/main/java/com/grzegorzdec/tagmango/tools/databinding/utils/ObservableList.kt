package com.grzegorzdec.tagmango.tools.databinding.utils

import androidx.databinding.ObservableArrayList
import androidx.databinding.ObservableList

fun <T> observableListOf(vararg items: T): ObservableList<T> {
    return ObservableArrayList<T>().apply {
        addAll(items)
    }
}

fun <T> List<T>.toObservableList(): ObservableList<T> {
    return ObservableArrayList<T>().apply {
        addAll(this@toObservableList)
    }
}