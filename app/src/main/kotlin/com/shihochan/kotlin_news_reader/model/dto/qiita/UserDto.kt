package com.shihochan.kotlin_news_reader.model.dto.qiita

/**
 * Created by Yuki Shiho on 2016/02/25.
 */
data class UserDto(
        val id: String,
        val name: String,
        val description: String,
        val profile_image_url: String,
        val website_url: String,
        val followers_count: Long,
        val followees_count: Long
)
