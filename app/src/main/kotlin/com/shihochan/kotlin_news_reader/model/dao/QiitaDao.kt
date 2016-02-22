package com.shihochan.kotlin_news_reader.model.dao

import com.shihochan.kotlin_news_reader.model.HatenaRestAdapter
import com.shihochan.kotlin_news_reader.model.api.Qiita
import com.shihochan.kotlin_news_reader.model.dto.QiitaDto
import retrofit.RestAdapter
import rx.Subscription
import rx.android.schedulers.AndroidSchedulers
import rx.functions.Action1
import javax.inject.Inject
import javax.inject.Singleton

/**
 * Created by Yuki Shiho on 2016/02/21.
 */
@Singleton
class QiitaDao
@Inject
constructor(@HatenaRestAdapter private var hatenaRestAdapter: RestAdapter) {

    fun getHotEntry(
            onNext: Action1<List<QiitaDto>>,
            onError: Action1<Throwable>): Subscription {
        return hatenaRestAdapter
                .create(Qiita::class.java)
                .getItems(100)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(onNext, onError)
    }
}
