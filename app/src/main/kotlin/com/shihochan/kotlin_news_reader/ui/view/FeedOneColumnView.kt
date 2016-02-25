package com.shihochan.kotlin_news_reader.ui.view

import android.content.Context
import android.support.v7.widget.CardView
import android.text.Html
import android.util.AttributeSet
import android.widget.ImageView
import android.widget.TextView
import butterknife.bindView
import com.bumptech.glide.Glide
import com.shihochan.kotlin_news_reader.R
import com.shihochan.kotlin_news_reader.model.dto.qiita.ArticleDto
import jp.wasabeef.glide.transformations.CropCircleTransformation

/**
 * Created by Yuki Shiho on 2016/02/24.
 */
class FeedOneColumnView
@JvmOverloads constructor(context: Context, attrs: AttributeSet? = null, defStyleAttr: Int = 0)
: CardView(context, attrs, defStyleAttr) {

    private val usrImg: ImageView by bindView(R.id.feed_one_column_usr_img)
    private val usrId: TextView by bindView(R.id.feed_one_column_usr_id)
    private val title: TextView by bindView(R.id.feed_one_column_title)
    private val content: TextView by bindView(R.id.feed_one_column_content)
    private val createdAt: TextView by bindView(R.id.feed_one_column_created_at)

    fun bindTo(item: ArticleDto) {

        Glide.with(context)
                .load(item.user.profile_image_url)
                .bitmapTransform(CropCircleTransformation(context))
                .into(usrImg)

        usrId.text = item.user.id
        title.text = item.title
        content.text = Html.fromHtml(item.body)
        createdAt.text = item.created_at
    }
}
