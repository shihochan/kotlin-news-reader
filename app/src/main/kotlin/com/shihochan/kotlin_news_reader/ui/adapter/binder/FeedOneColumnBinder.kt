package com.shihochan.kotlin_news_reader.ui.adapter.binder

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.shihochan.kotlin_news_reader.R
import com.shihochan.kotlin_news_reader.model.dto.qiita.ArticleDto
import com.shihochan.kotlin_news_reader.ui.view.FeedOneColumnView
import com.yqritc.recyclerviewmultipleviewtypesadapter.DataBindAdapter
import com.yqritc.recyclerviewmultipleviewtypesadapter.DataBinder
import java.util.*

/**
 * Created by Yuki Shiho on 2016/02/24.
 */
class FeedOneColumnBinder(dataBindAdapter: DataBindAdapter) : DataBinder<FeedOneColumnBinder.ViewHolder>(dataBindAdapter) {

    private var qiitaContents = ArrayList<ArticleDto>()

    override fun newViewHolder(parent: ViewGroup): ViewHolder? {
        val view = LayoutInflater.from(parent.context)
                .inflate(R.layout.view_feed_one_column, parent, false)
        return ViewHolder(view)
    }

    override fun bindViewHolder(holder: ViewHolder, position: Int) {
        val view = holder.itemView as FeedOneColumnView
        view.bindTo(qiitaContents[position])
    }

    override fun getItemCount(): Int {
        return qiitaContents.size
    }

    fun addAll(contents: List<ArticleDto>) {
        qiitaContents.addAll(contents)
        notifyBinderItemInserted(qiitaContents.size - 1)
    }

    fun clear() {
        qiitaContents.clear()
        notifyBinderDataSetChanged()
    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView)
}
