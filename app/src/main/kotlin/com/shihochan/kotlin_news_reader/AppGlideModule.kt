package com.shihochan.kotlin_news_reader

import android.content.Context
import com.bumptech.glide.Glide
import com.bumptech.glide.GlideBuilder
import com.bumptech.glide.load.DecodeFormat
import com.bumptech.glide.load.engine.cache.LruResourceCache
import com.bumptech.glide.module.GlideModule

/**
 * In Glide 3.5, Glide.isSetup() and Glide.setup() are deprecated.
 * The best way to do this is to use GlideModules to do this kind of configuration lazily.
 * {@see https://github.com/bumptech/glide/wiki/Configuration}
 *
 * Created by Yuki Shiho on 2016/02/24.
 */
class AppGlideModule : GlideModule {

    override fun applyOptions(context: Context, builder: GlideBuilder) {
        builder.setMemoryCache(LruResourceCache(30 * 1024 * 1024))
                .setDecodeFormat(DecodeFormat.PREFER_ARGB_8888)
    }

    override fun registerComponents(context: Context, glide: Glide) {
        // Register components it's done in Application class
    }
}