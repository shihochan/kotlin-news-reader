package com.shihochan.kotlin_news_reader.model.api

import com.shihochan.kotlin_news_reader.model.dto.QiitaDto
import retrofit.http.GET
import retrofit.http.Query
import rx.Observable

/**
 * Created by Yuki Shiho on 2016/02/21.
 */
interface Qiita {

    @GET("/items")
    fun getItems(@Query("per_page") perPage: Int): Observable<List<QiitaDto>>
}
