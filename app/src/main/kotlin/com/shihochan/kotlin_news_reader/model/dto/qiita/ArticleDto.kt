package com.shihochan.kotlin_news_reader.model.dto.qiita

/**
 * Created by Yuki Shiho on 2016/02/21.
 */
data class ArticleDto(
        val id: String,
        val body: String,
        val title: String,
        val url: String,
        val created_at: String,
        val updated_at: String,
        val tags: List<TagDto>,
        val user: UserDto
)
