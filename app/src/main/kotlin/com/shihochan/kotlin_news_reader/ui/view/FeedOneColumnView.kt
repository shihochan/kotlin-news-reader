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
import com.shihochan.kotlin_news_reader.model.dto.QiitaDto
import jp.wasabeef.glide.transformations.CropCircleTransformation

/**
 * Created by Yuki Shiho on 2016/02/24.
 */
class FeedOneColumnView
@JvmOverloads constructor(context: Context, attrs: AttributeSet? = null, defStyleAttr: Int = 0)
: CardView(context, attrs, defStyleAttr) {

    private val usrImg: ImageView by bindView(R.id.feed_one_column_usr_img)
    private val title: TextView by bindView(R.id.feed_one_column_title)
    private val content: TextView by bindView(R.id.feed_one_column_content)

    fun bindTo(item: QiitaDto) {

        Glide.with(context)
                .load("https://avatars1.githubusercontent.com/u/4586632?v=3&s=100")
                .bitmapTransform(CropCircleTransformation(context))
                .into(usrImg)

        title.text = item.title
        content.text = Html.fromHtml(item.body)
    }
}
