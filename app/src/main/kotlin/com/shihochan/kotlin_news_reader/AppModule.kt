package com.shihochan.kotlin_news_reader

import dagger.Module
import dagger.Provides

/**
 * Created by Yuki Shiho on 2016/02/21.
 */
@Module
class AppModule(private val mainApp: MainApp) {

    @Provides
    fun provideApp(): MainApp {
        return mainApp
    }
}
