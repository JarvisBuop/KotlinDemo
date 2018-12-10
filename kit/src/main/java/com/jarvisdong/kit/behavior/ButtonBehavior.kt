package com.jarvisdong.kit.behavior

import android.content.Context
import android.support.design.widget.CoordinatorLayout
import android.util.AttributeSet
import android.view.View
import com.jarvisdong.kit.R


/**
 * Created by JarvisDong on 2017/5/27.
 * OverView: 设置物资下一步按钮的依赖事件;
 */

class ButtonBehavior(context: Context, attrs: AttributeSet) : CoordinatorLayout.Behavior<View>(context, attrs) {
    private var targetId: Int = 0

    init {
        val a = context.obtainStyledAttributes(attrs, R.styleable.Follow)
        for (i in 0 until a.indexCount) {
            val attr = a.getIndex(i)
            if (a.getIndex(i) == R.styleable.Follow_target_dependcy) {
                targetId = a.getResourceId(attr, -1)
            }
        }
        a.recycle()
    }

    override fun layoutDependsOn(parent: CoordinatorLayout?, child: View?, dependency: View?): Boolean {
        return dependency!!.id == targetId
        //            return super.layoutDependsOn(parent, child, dependency);
    }

    override fun onDependentViewChanged(parent: CoordinatorLayout?, child: View?, dependency: View?): Boolean {
        //        LogUtil.commonLog(dependency.getHeight() + ",getY:" + dependency.getY() + "/" + child.getHeight());
        //        float rate = (dependency.getHeight() + dependency.getY()) / dependency.getHeight();
        val difference = child!!.height + dependency!!.y
        val rate = difference / child.height
        if (difference <= 0) {
            child.translationY = child.height.toFloat()
        } else {
            child.translationY = child.height * (1 - rate)
        }
        return true
    }
}
