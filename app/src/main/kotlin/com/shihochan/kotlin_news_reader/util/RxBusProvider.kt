package com.shihochan.kotlin_news_reader.util

/**
 * Created by Yuki Shiho on 2016/02/27.
 */
class RxBusProvider {

    companion object {
        final val bus: RxBus = RxBus()

        fun get()  = bus
    }
}
