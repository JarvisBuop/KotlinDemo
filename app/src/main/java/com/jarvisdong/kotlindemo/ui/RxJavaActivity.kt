package com.jarvisdong.kotlindemo.ui

import android.util.Log
import com.jarvisdong.kotlindemo.R
import io.reactivex.Observable
import io.reactivex.ObservableEmitter
import io.reactivex.ObservableOnSubscribe
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import kotlinx.android.synthetic.main.item_common.view.*

/**
 * Created by JarvisDong on 2018/12/20.
 *
 * @Description:
 * @see:
 */

class RxJavaActivity : SimpleListActivity() {
    companion object {
        var TAG = RxJavaActivity::class.java.name
    }

    override fun getItemLayout(): Int {
        return R.layout.item_common
    }

    override fun onBindViewHolder(holder: CommonHolder, position: Int) {
        var pair = mDataLists.get(position) as Pair<Int, String>
        holder.apply {
            itemView.item_title.text = pair.second

            itemView.setOnClickListener {
                when (position) {
                    0 -> {
                        test1()
                    }
                    1 -> {

                    }
                }

            }
        }
    }

    private fun test1() {
        Observable.create(ObservableOnSubscribe<String> { emitter: ObservableEmitter<String> ->
            Log.e(TAG, "Thread1 " + Thread.currentThread().name)
            emitter.onNext("1")
            emitter.onNext("2")
            emitter.onNext("3")
            emitter.onComplete()
        }).map({ t ->
            Log.e(TAG, "Thread2 " + Thread.currentThread().name)
            //return@map Integer.parseInt(t)
            Integer.parseInt(t)
        }).subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe({ t ->
                    Log.e(TAG, "Thread3 " + Thread.currentThread().name)
                    Log.e(TAG, "onNext " + t + " type " + t.javaClass)
                }, { t ->
                    Log.e(TAG, "onError " + t)
                }, {
                    Log.e(TAG, "onComplete")
                }, {
                    Log.e(TAG, "onSubscribe")
                })
    }

    override fun loadData() {
        var index: Int = 0
        mDataLists.add(Pair<Int, String>(index++, "scheduler-1"))
        mDataLists.add(Pair<Int, String>(index++, "scheduler"))
        mDataLists.add(Pair<Int, String>(index++, "scheduler"))
        mAdapter?.notifyDataSetChanged()
    }


}
