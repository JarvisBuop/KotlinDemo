package com.jarvisdong.kotlindemo.ui

import android.os.Bundle
import android.support.v7.widget.DividerItemDecoration
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.text.TextUtils
import android.view.View
import android.view.ViewGroup
import com.jarvisdong.kotlindemo.utils.Patterns
import com.jarvisdong.kotlindemo.utils.Principles
import com.jarvisdong.kotlindemo.R
import kotlinx.android.synthetic.main.component_include_list_swipe.*
import kotlinx.android.synthetic.main.item_common.view.*

/**
 * Created by JarvisDong on 2018/12/9.
 * @Description: design patterns
 * @see:
 */
class DesignPatternActivity : BaseActivity() {
    var mDataList : ArrayList<Any>? = null

    override fun getViewStubId(): Int {
        return R.layout.component_include_list_swipe
    }

    override fun initIntentData(): Boolean {
        return true
    }

    override fun customOperate(savedInstanceState: Bundle?) {

        initRecyclerView()

        doPost()

    }

    private fun doPost() {
        mDataList!!.clear()
        mDataList!!.add(Pair<String,String>(Principles.SRP,"单一职责原则"))
        mDataList!!.add(Pair<String,String>(Principles.OCP,"开闭原则"))
        mDataList!!.add(Pair<String,String>(Principles.LSP,"里氏替换原则"))
        mDataList!!.add(Pair<String,String>(Principles.DIP,"依赖倒置原则"))
        mDataList!!.add(Pair<String,String>(Principles.ISP,"接口隔离原则"))
        mDataList!!.add(Pair<String,String>(Principles.LKP,"最少知识原则"))
        mDataList!!.add(Pair<String,String>(Principles.LKP,"最少知识原则"))
        mDataList!!.add(Pair<String,String>("",""))
        mDataList!!.add(Pair<String,String>(Patterns.SINGLETON,"单例模式"))
        mDataList!!.add(Pair<String,String>(Patterns.BUILDER,"单例模式"))
        mDataList!!.add(Pair<String,String>(Patterns.PROTOTYPE,"单例模式"))
        mDataList!!.add(Pair<String,String>(Patterns.FACTORY,"单例模式"))
        mDataList!!.add(Pair<String,String>(Patterns.ABSTRACT_FACTORY,"单例模式"))
        mDataList!!.add(Pair<String,String>(Patterns.STRAGETY,"单例模式"))
        mDataList!!.add(Pair<String,String>(Patterns.STATE,"单例模式"))
        mDataList!!.add(Pair<String,String>(Patterns.ITERATOR_HANDLER,"单例模式"))
        mDataList!!.add(Pair<String,String>(Patterns.INTERPRETER,"单例模式"))
        mDataList!!.add(Pair<String,String>(Patterns.COMMAND,"单例模式"))
        mDataList!!.add(Pair<String,String>(Patterns.OBSERVER,"单例模式"))
        mDataList!!.add(Pair<String,String>(Patterns.MEMENTO,"单例模式"))
        mDataList!!.add(Pair<String,String>(Patterns.ITERATOR,"单例模式"))
        mDataList!!.add(Pair<String,String>(Patterns.TEMPLATE,"单例模式"))
        mDataList!!.add(Pair<String,String>(Patterns.VISITOR,"单例模式"))
        mDataList!!.add(Pair<String,String>(Patterns.MEDIATOR,"单例模式"))
        mDataList!!.add(Pair<String,String>(Patterns.PROXY,"单例模式"))
        mDataList!!.add(Pair<String,String>(Patterns.COMPOSITE,"单例模式"))
        mDataList!!.add(Pair<String,String>(Patterns.ADAPTER,"单例模式"))
        mDataList!!.add(Pair<String,String>(Patterns.DECORATOR,"单例模式"))
        mDataList!!.add(Pair<String,String>(Patterns.FLYWEIGHT,"单例模式"))
        mDataList!!.add(Pair<String,String>(Patterns.FACADE,"单例模式"))
        mDataList!!.add(Pair<String,String>(Patterns.BRIDGE,"单例模式"))

        common_recyclerview.adapter.notifyDataSetChanged()
    }

    private fun initRecyclerView() {
        mDataList = ArrayList()
        common_swipe.setOnRefreshListener {
            common_swipe.setRefreshing(false)
        }
        common_recyclerview.layoutManager = LinearLayoutManager(mContext)
        common_recyclerview.adapter = MyAdapter()
        common_recyclerview.addItemDecoration(DividerItemDecoration(mContext, DividerItemDecoration.HORIZONTAL))
    }

    inner class MyAdapter : RecyclerView.Adapter<MyViewHolder>() {

        override fun getItemViewType(position: Int): Int {
            return super.getItemViewType(position)
        }

        override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
            if (holder is MyViewHolder) {
                var obj = mDataList!!.get(position) as Pair<String, String>
                holder.apply {
                    if(TextUtils.isEmpty(obj.first )&& TextUtils.isEmpty(obj.second)){
                        holder.itemView.img_main.visibility = View.GONE
                        holder.itemView.img_arrow.visibility = View.GONE
                    }else{
                        holder.itemView.img_main.visibility = View.VISIBLE
                        holder.itemView.img_arrow.visibility = View.VISIBLE
                    }
                    holder.itemView.item_title.setText(obj.first)
                    holder.itemView.item_content.setText(obj.second)
                    holder.itemView.setOnClickListener { null }
                }
            }
        }

        override fun getItemCount(): Int {
            return mDataList!!.size
        }

        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
            return MyViewHolder(layoutInflater.inflate(R.layout.item_common, parent, false))
        }

    }

    inner class MyViewHolder(itemView: View?) : RecyclerView.ViewHolder(itemView)
}