package com.shihochan.kotlin_news_reader.util

import android.content.Context
import android.graphics.Rect
import android.support.v7.widget.RecyclerView
import android.view.View
import com.shihochan.kotlin_news_reader.R

/**
 * Created by Yuki Shiho on 2016/02/25.
 */
class FeedOneColumnItemDecoration(context: Context) : RecyclerView.ItemDecoration() {

    private val marginPx: Int

    init {
        marginPx = context.resources.getDimensionPixelSize(R.dimen.margin_s)
    }

    override fun getItemOffsets(outRect: Rect, view: View, parent: RecyclerView,
                                state: RecyclerView.State?) {
        val itemPos = (view.layoutParams as RecyclerView.LayoutParams).viewAdapterPosition

        if (itemPos == 0)
            outRect.set(marginPx, marginPx, marginPx, marginPx)
        else
            outRect.set(marginPx, 0, marginPx, marginPx)
    }
}
