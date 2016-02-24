package com.shihochan.kotlin_news_reader.ui.fragment

import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import butterknife.bindView
import com.shihochan.kotlin_news_reader.AppComponent
import com.shihochan.kotlin_news_reader.MainApp
import com.shihochan.kotlin_news_reader.R
import com.shihochan.kotlin_news_reader.model.dao.QiitaDao
import com.shihochan.kotlin_news_reader.model.dto.QiitaDto
import com.shihochan.kotlin_news_reader.ui.adapter.QiitaFeedAdapter
import com.shihochan.kotlin_news_reader.util.FeedOneColumnItemDecoration
import com.shihochan.kotlin_news_reader.util.ext.inflate
import com.trello.rxlifecycle.components.support.RxFragment
import rx.android.schedulers.AndroidSchedulers
import timber.log.Timber
import javax.inject.Inject

/**
 * Created by Yuki Shiho on 2016/02/23.
 */
class MainFragment : RxFragment() {

    val component: AppComponent by lazy {
        MainApp.appComponent
    }
    private val adapterQiita: QiitaFeedAdapter = QiitaFeedAdapter()

    @Inject lateinit var qiitaDao: QiitaDao

    private val recyclerView: RecyclerView by bindView(R.id.recycler_view)

    companion object {
        @JvmStatic fun newInstance(): MainFragment {
            return MainFragment()
        }
    }

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        component.inject(this)
        return inflate(R.layout.fragment_main, inflater, container)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        recyclerView.adapter = adapterQiita
        recyclerView.layoutManager = LinearLayoutManager(activity)
        recyclerView.addItemDecoration(FeedOneColumnItemDecoration(activity))

        qiitaDao.getHotEntry(20)
            .observeOn(AndroidSchedulers.mainThread())
            .compose(bindToLifecycle<List<QiitaDto>>())
            .subscribe({
                adapterQiita.addAll(it)
            }, {
                Timber.e(it, it.message)
            })
    }

    override fun onDestroyView() {
        adapterQiita.clearAll()
        super.onDestroyView()
    }
}
