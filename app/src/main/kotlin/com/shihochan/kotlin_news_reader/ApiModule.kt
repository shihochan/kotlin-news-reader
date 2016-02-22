package com.shihochan.kotlin_news_reader

import com.google.gson.Gson
import com.shihochan.kotlin_news_reader.model.ApiConverter
import com.shihochan.kotlin_news_reader.model.HatenaRestAdapter
import com.shihochan.kotlin_news_reader.model.Endpoint
import com.squareup.okhttp.OkHttpClient
import dagger.Module
import dagger.Provides
import retrofit.RestAdapter
import retrofit.client.Client
import retrofit.client.OkClient
import retrofit.converter.Converter
import retrofit.converter.GsonConverter
import java.net.CookieHandler
import javax.inject.Singleton

/**
 * Created by Yuki Shiho on 2016/02/21.
 */
@Module class ApiModule {

    @Provides @Singleton @HatenaRestAdapter
    fun provideHatenaRestAdapter(client: Client): RestAdapter {
        return RestAdapter.Builder()
                .setEndpoint(Endpoint.qiita)
                .setClient(client)
                .setLogLevel(RestAdapter.LogLevel.BASIC)
                .build()
    }

    @Provides @Singleton @ApiConverter
    fun provideConverter(): Converter {
        return GsonConverter(Gson())
    }

    @Provides @Singleton
    fun provideClient(okHttpClient: OkHttpClient): Client {
        return OkClient(okHttpClient)
    }

    @Provides @Singleton
    fun provideOkHttpClient(): OkHttpClient {
        val okHttpClient = OkHttpClient()
        okHttpClient.cookieHandler = CookieHandler.getDefault()
        return okHttpClient
    }
}
