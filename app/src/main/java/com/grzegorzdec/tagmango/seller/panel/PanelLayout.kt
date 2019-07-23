package com.grzegorzdec.tagmango.seller.panel

import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import android.view.View
import androidx.cardview.widget.CardView
import androidx.databinding.BindingAdapter
import com.grzegorzdec.tagmango.R
import com.grzegorzdec.tagmango.common.animation.onAnimationEnd
import com.grzegorzdec.tagmango.databinding.LayoutPanelBinding
import com.grzegorzdec.tagmango.model.Client

class PanelLayout(attrs: AttributeSet, context: Context, defStyle: Int): CardView(context, attrs, defStyle) {

    init {
        LayoutInflater.from(context).inflate(R.layout.layout_panel, this, true)
    }

}

//@BindingAdapter("panelLayoutVisibility")
//fun panelLayoutVisibility(layout: PanelLayout, client: Client?) {
//    if(client == null) {
//        if (layout.visibility == View.VISIBLE) {
//            layout.animate()
//                .translationY(-layout.height.toFloat())
//                .onAnimationEnd { layout.visibility = View.GONE }
//                .start()
//        }
//    } else {
//        if (layout.visibility == View.GONE) {
//            layout.visibility = View.VISIBLE
//            layout.animate()
//                .translationY(0f)
//                .setListener(null)
//                .start()
//        }
//    }
//}