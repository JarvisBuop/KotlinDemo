package com.jarvisdong.kotlindemo.ui

import android.content.Intent
import android.os.Bundle
import android.support.design.widget.BottomSheetBehavior
import android.support.v7.widget.DividerItemDecoration
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.View
import android.view.ViewGroup
import com.jarvisdong.kit.ActBottomType
import com.jarvisdong.kit.baseui.BaseActivity
import com.jarvisdong.kotlindemo.R
import kotlinx.android.synthetic.main.component_include_list_swipe.*
import kotlinx.android.synthetic.main.item_common.view.*

class MainActivity : BaseActivity() {
    var mDataList: ArrayList<Pair<Int, String>> = ArrayList()

    override fun getViewStubId(): Int {
        return R.layout.component_include_list_swipe
    }

    override fun initIntentData(): Boolean {
        return true
    }

    override fun customOperate(savedInstanceState: Bundle?) {
        initView()

        var index = 0
        mDataList.add(Pair(index++, "约束布局 constraint layout demo >>"))
        mDataList.add(Pair(index++, "面向对象六大原则(solid五大原则) >> "))
        mDataList.add(Pair(index++, "23种设计模式简介 >> "))
        common_recyclerview.adapter.notifyDataSetChanged()
    }

    /**
     * 选择使用不同底部;
     */
    override fun setBottomType(): Int {
        return ActBottomType.ACT_BOTTOM_BTNS
    }

    private fun initView() {
        initTitle("current title")
        getLeftView().setOnClickListener {
            if (getBottomType() == ActBottomType.ACT_BOTTOM_SHARE) {
                if (bottomSheetBehavior?.state != BottomSheetBehavior.STATE_EXPANDED) {
                    bottomSheetBehavior?.state = BottomSheetBehavior.STATE_EXPANDED
                } else {
                    bottomSheetBehavior?.setState(BottomSheetBehavior.STATE_HIDDEN)
                }
            }
        }
        common_swipe.setOnRefreshListener {
            mDataList.add(0, Pair<Int, String>(mDataList.size + 1, "content00"))
            common_recyclerview.adapter.notifyItemInserted(0)
            common_swipe.setRefreshing(false)
        }
        common_recyclerview.layoutManager = LinearLayoutManager(mContext)
        common_recyclerview.adapter = MyAdapter()
        common_recyclerview.addItemDecoration(DividerItemDecoration(mContext, DividerItemDecoration.HORIZONTAL))
    }

    inner class MyAdapter : RecyclerView.Adapter<MyViewHolder>() {

        override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
            if (holder is MyViewHolder) {
                var obj = mDataList.get(position) as Pair<Int, String>
                holder.apply {
                    //使用java方式转换数据;
//                    java.lang.String.valueOf(obj.first)
                    holder.itemView.item_title.setText(obj.first.toString())
                    holder.itemView.item_content.setText(obj.second)
                    //匿名函数方式
//                        holder.itemView.setOnClickListener(View.OnClickListener {
//                            v:View -> nextAct(v)
//                        })

                    //最后一个参数是函数类型,可省略圆括号
                    holder.itemView.setOnClickListener { v: View ->
                        nextAct(obj.first, v)
                    }
                }
            }
        }

        private fun nextAct(type: Int, v: View) {
            var intent: Intent? = null
            when (type) {
                0 -> intent = Intent(mContext, LayoutDemoActivity::class.java)
                1, 2 -> {
                    intent = Intent(mContext, DesignPatternActivity::class.java)
                    intent.putExtra("type", type)
                }
            }
            intent?.let {
                startActivity(it)
            }
        }

        override fun getItemCount(): Int {
            return mDataList.size
        }

        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
            return MyViewHolder(layoutInflater.inflate(R.layout.item_common, parent, false))
        }

    }

    inner class MyViewHolder(itemView: View?) : RecyclerView.ViewHolder(itemView)
}
