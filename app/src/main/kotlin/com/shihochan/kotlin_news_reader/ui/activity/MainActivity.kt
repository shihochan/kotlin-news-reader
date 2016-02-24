package com.shihochan.kotlin_news_reader.ui.activity

import android.content.res.Configuration
import android.os.Bundle
import android.os.Handler
import android.support.v4.widget.DrawerLayout
import android.support.v7.app.ActionBarDrawerToggle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.Toolbar
import android.view.MenuItem
import android.view.View
import butterknife.bindView
import com.shihochan.kotlin_news_reader.R
import com.shihochan.kotlin_news_reader.ui.fragment.MainFragment
import com.shihochan.kotlin_news_reader.util.ext.setContentFragment
import me.zhanghai.android.materialprogressbar.MaterialProgressBar

/**
 * Created by Yuki Shiho on 2016/02/21.
 */
class MainActivity : AppCompatActivity() {

    private val toolBar: Toolbar by bindView(R.id.toolbar)
    private val progressBar: MaterialProgressBar by bindView(R.id.progressbar)
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

        Handler().postDelayed({ progressBar.visibility = View.GONE }, 5000)
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
