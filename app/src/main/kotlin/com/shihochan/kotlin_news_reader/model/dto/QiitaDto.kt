package com.shihochan.kotlin_news_reader.model.dto

/**
 * Created by Yuki Shiho on 2016/02/21.
 */
data class QiitaDto(
        val id: String,
        val body: String,
        val title: String,
        val created_at: String,
        val updated_at: String
)
