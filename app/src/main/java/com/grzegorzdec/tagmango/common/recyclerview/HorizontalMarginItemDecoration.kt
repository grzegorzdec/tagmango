package com.grzegorzdec.tagmango.common.recyclerview

import android.graphics.Rect
import android.view.View
import androidx.recyclerview.widget.RecyclerView

class HorizontalMarginItemDecoration(private val space: Int) : RecyclerView.ItemDecoration() {
    override fun getItemOffsets(
        outRect: Rect, view: View,
        parent: RecyclerView, state: RecyclerView.State
    ) {
        with(outRect) {

            if (parent.getChildAdapterPosition(view) == 0) {
                left = space
            }
            top = space
            right = space
            bottom = space
        }
    }
}