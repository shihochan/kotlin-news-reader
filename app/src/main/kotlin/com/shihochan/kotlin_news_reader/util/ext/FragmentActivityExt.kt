package com.shihochan.kotlin_news_reader.util.ext

import android.support.v4.app.Fragment
import android.support.v4.app.FragmentActivity

/**
 * Created by Yuki Shiho on 2016/02/23.
 */

fun FragmentActivity.setContentFragment(containerViewId: Int, fragment: Fragment?): Fragment? {
    val f: Fragment? = supportFragmentManager?.findFragmentById(containerViewId)
    f?.let { return@setContentFragment f }
    supportFragmentManager?.beginTransaction()?.add(containerViewId, fragment)?.commit()
    return fragment
}
