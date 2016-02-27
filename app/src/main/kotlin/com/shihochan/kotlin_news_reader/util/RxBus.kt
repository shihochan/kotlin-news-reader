package com.shihochan.kotlin_news_reader.util

import rx.Observable
import rx.subjects.PublishSubject
import rx.subjects.SerializedSubject
import rx.subjects.Subject

/**
 * Created by Yuki Shiho on 2016/02/27.
 */
class RxBus {

    private val bus : Subject<Any, Any> = SerializedSubject(PublishSubject.create())

    fun toObservable () : Observable<Any> = bus

    fun hasObservable() : Boolean = bus.hasObservers()

    fun send(any: Any) {
        bus.onNext(any)
    }
}
