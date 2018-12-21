package com.jarvisdong.kotlindemo.ui

import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.jarvisdong.kotlindemo.R
import kotlinx.android.synthetic.main.component_include_list_swipe.*

/**
 * Created by JarvisDong on 2018/12/20.
 * @Description:
 * @see:
 */
abstract class SimpleListActivity : BaseActivity() {
    protected var mDataLists = arrayListOf<Any>()
    protected var mAdapter : CommonAdapter? = null

    override fun getViewStubId(): Int {
        return R.layout.component_include_list_swipe
    }

    override fun initIntentData(): Boolean {
        initView()
        return true
    }

    private fun initView() {
        common_swipe.setOnRefreshListener {
            common_swipe.isRefreshing = false
        }

        common_recyclerview.layoutManager = LinearLayoutManager(mContext)
        mAdapter = CommonAdapter()
        common_recyclerview.adapter = mAdapter
    }

    override fun customOperate(savedInstanceState: Bundle?) {
        loadData()
    }


    inner class CommonAdapter : RecyclerView.Adapter<CommonHolder>() {
        override fun onBindViewHolder(holder: CommonHolder, position: Int) {
            this@SimpleListActivity.onBindViewHolder(holder,position)
        }

        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CommonHolder {
            var view = LayoutInflater.from(mContext).inflate(getItemLayout(), parent, false);
            return CommonHolder(view)
        }

        override fun getItemCount(): Int {
            return mDataLists.size
        }

    }

    inner class CommonHolder constructor(itemView: View?) : RecyclerView.ViewHolder(itemView)


    //-----------------------------------
    //       抽象
    //-----------------------------------
    protected abstract fun getItemLayout(): Int

    protected abstract fun onBindViewHolder(holder: CommonHolder, position: Int)

    abstract fun loadData()
}