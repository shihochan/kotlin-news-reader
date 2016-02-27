package com.shihochan.kotlin_news_reader.ui.activity

import android.content.res.Configuration
import android.net.Uri
import android.os.Bundle
import android.support.customtabs.CustomTabsIntent
import android.support.v4.widget.DrawerLayout
import android.support.v7.app.ActionBarDrawerToggle
import android.support.v7.widget.Toolbar
import android.view.MenuItem
import butterknife.bindView
import com.shihochan.kotlin_news_reader.R
import com.shihochan.kotlin_news_reader.ui.fragment.MainFragment
import com.shihochan.kotlin_news_reader.util.RxBusProvider
import com.shihochan.kotlin_news_reader.util.event.OpenChromeTabsEvent
import com.shihochan.kotlin_news_reader.util.ext.setContentFragment
import com.trello.rxlifecycle.components.support.RxAppCompatActivity
import rx.android.schedulers.AndroidSchedulers

/**
 * Created by Yuki Shiho on 2016/02/21.
 */
class MainActivity : RxAppCompatActivity() {

    private val toolBar: Toolbar by bindView(R.id.toolbar)
    private val drawerLayout: DrawerLayout by bindView(R.id.drawer_layout)
    private val drawerToggle: ActionBarDrawerToggle by lazy {
        ActionBarDrawerToggle(this, drawerLayout, toolBar,
                R.string.drawer_open, R.string.drawer_close)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        setSupportActionBar(toolBar)
        supportActionBar?.title = getString(R.string.drawer_home)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        drawerToggle.isDrawerIndicatorEnabled = true

        setContentFragment(R.id.container, MainFragment.newInstance())
    }

    override fun onResume() {
        super.onResume()

        RxBusProvider.bus.toObservable()
                .compose(bindToLifecycle())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe({
                    if (it is OpenChromeTabsEvent) {
                        CustomTabsIntent.Builder()
                                .setShowTitle(true)
                                .setStartAnimations(this, R.anim.slide_to_left, R.anim.scale_to_back)
                                .setExitAnimations(this, R.anim.scale_to_front, R.anim.slide_to_right)
                                .build().launchUrl(this, Uri.parse(it.url))
                    }
                })

    }

    override fun onPostCreate(savedInstanceState: Bundle?) {
        super.onPostCreate(savedInstanceState)
        drawerLayout.setDrawerListener(drawerToggle)
        drawerToggle.syncState()
    }

    override fun onConfigurationChanged(newConfig: Configuration?) {
        super.onConfigurationChanged(newConfig)
        drawerToggle.onConfigurationChanged(newConfig)
    }

    override fun onOptionsItemSelected(item: MenuItem?): Boolean {
        if (drawerToggle.onOptionsItemSelected(item))
            return true
        else
            return super.onOptionsItemSelected(item)
    }
}
