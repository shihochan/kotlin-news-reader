package com.shihochan.kotlin_news_reader

import com.shihochan.kotlin_news_reader.ui.activity.MainActivity
import dagger.Component
import javax.inject.Singleton

/**
 * Created by Yuki Shiho on 2016/02/22.
 */
@Singleton
@Component(modules = arrayOf(AppModule::class, ApiModule::class))
interface AppComponent {

    fun inject(app: MainApp)

    fun inject(mainActivity: MainActivity)
}
