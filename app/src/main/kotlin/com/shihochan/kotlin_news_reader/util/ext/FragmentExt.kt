package com.shihochan.kotlin_news_reader.util.ext

import android.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.support.v4.app.Fragment as SupportFragment

/**
 * Created by Yuki Shiho on 2016/02/23.
 */

fun SupportFragment.inflate(layoutResId: Int, inflater: LayoutInflater?, container: ViewGroup?): View? {
    return inflater?.inflate(layoutResId, container, false)
}

fun Fragment.inflate(layoutResId: Int, inflater: LayoutInflater?, container: ViewGroup?): View? {
    return inflater?.inflate(layoutResId, container, false)
}
