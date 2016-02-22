package com.shihochan.kotlin_news_reader

import android.app.Application

/**
 * Created by Yuki Shiho on 2016/02/21.
 */
class MainApp : Application() {

    companion object {
        @JvmStatic lateinit var appComponent: AppComponent
    }

    override fun onCreate() {
        super.onCreate()
        appComponent = DaggerAppComponent.builder()
                .appModule(AppModule(this))
                .build()
        appComponent.inject(this)
    }
}
