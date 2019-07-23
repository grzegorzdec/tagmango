package com.grzegorzdec.tagmango.common.recyclerview

import android.os.Handler
import android.os.Looper
import androidx.recyclerview.widget.DiffUtil


class ListBinder<E>(private val diffCallBack: AbstractDiffCallback<E>) {
    private var current: List<E> = ArrayList()
    private var onDataChangeListener: OnDataChangeListener? = null

    internal interface OnDataChangeListener {
        fun onChange(diffResult: DiffUtil.DiffResult)
    }

    internal fun setOnDataChangeListener(onDataChangeListener: OnDataChangeListener) {
        this.onDataChangeListener = onDataChangeListener
    }

    fun notifyDataChange(data: List<E>?) {
        Handler(Looper.getMainLooper()).post {
            val diffResult = calculateDiff(data)
            if (onDataChangeListener != null) {
                onDataChangeListener!!.onChange(diffResult)
            }
        }
    }

    private fun calculateDiff(data: List<E>?): DiffUtil.DiffResult {
        val newList = ArrayList(data)
        diffCallBack.setData(current, newList)
        val diffResult = DiffUtil.calculateDiff(diffCallBack)
        current = newList
        return diffResult
    }
}