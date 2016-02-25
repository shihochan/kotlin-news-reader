package com.shihochan.kotlin_news_reader.ui.adapter

import com.shihochan.kotlin_news_reader.model.dto.qiita.ArticleDto
import com.shihochan.kotlin_news_reader.ui.adapter.binder.FeedOneColumnBinder
import com.yqritc.recyclerviewmultipleviewtypesadapter.ListBindAdapter

/**
 * Created by Yuki Shiho on 2016/02/24.
 */
class QiitaFeedAdapter : ListBindAdapter() {

    private val binder: FeedOneColumnBinder
        get() = getDataBinder(0)

    init {
        addAllBinder(FeedOneColumnBinder(this))
    }

    fun addAll(contents: List<ArticleDto>) {
        binder.addAll(contents)
    }

    fun clearAll() {
        binder.clear()
    }
}