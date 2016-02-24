package com.shihochan.kotlin_news_reader

import android.app.Application
import com.bumptech.glide.Glide
import com.bumptech.glide.integration.okhttp.OkHttpUrlLoader
import com.bumptech.glide.load.model.GlideUrl
import com.jakewharton.threetenabp.AndroidThreeTen
import com.squareup.okhttp.OkHttpClient
import java.io.InputStream
import javax.inject.Inject

/**
 * Created by Yuki Shiho on 2016/02/21.
 */
class MainApp : Application() {

    companion object {
        @JvmStatic lateinit var appComponent: AppComponent
    }

    @Inject lateinit var okHttpClient: OkHttpClient

    override fun onCreate() {
        super.onCreate()
        appComponent = DaggerAppComponent.builder()
                .appModule(AppModule(this))
                .build()
        appComponent.inject(this)

        AndroidThreeTen.init(this)

        Glide.get(this).register(GlideUrl::class.java, InputStream::class.java,
                OkHttpUrlLoader.Factory(okHttpClient))
    }

    override fun onTrimMemory(level: Int) {
        super.onTrimMemory(level)
        Glide.get(this).trimMemory(level)
    }
}
