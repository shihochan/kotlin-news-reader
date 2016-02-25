package com.shihochan.kotlin_news_reader.model.dao

import com.shihochan.kotlin_news_reader.model.QiitaRestAdapter
import com.shihochan.kotlin_news_reader.model.api.Qiita
import com.shihochan.kotlin_news_reader.model.dto.qiita.ArticleDto
import retrofit.RestAdapter
import rx.Observable
import javax.inject.Inject
import javax.inject.Singleton

/**
 * Created by Yuki Shiho on 2016/02/21.
 */
@Singleton
class QiitaDao
@Inject
constructor(@QiitaRestAdapter private var qiitaRestAdapter: RestAdapter) {

    fun getHotEntry(count: Int): Observable<List<ArticleDto>> {
        return qiitaRestAdapter
                .create(Qiita::class.java)
                .getItems(count)
    }
}
