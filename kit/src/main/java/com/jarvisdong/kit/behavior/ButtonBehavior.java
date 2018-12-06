package com.jarvisdong.kit.behavior;

import android.content.Context;
import android.content.res.TypedArray;
import android.support.design.widget.CoordinatorLayout;
import android.util.AttributeSet;
import android.view.View;

import com.jarvisdong.kit.R;


/**
 * Created by JarvisDong on 2017/5/27.
 * OverView: 设置物资下一步按钮的依赖事件;
 */

public class ButtonBehavior extends CoordinatorLayout.Behavior {
    private int targetId;

    public ButtonBehavior(Context context, AttributeSet attrs) {
        super(context, attrs);
        TypedArray a = context.obtainStyledAttributes(attrs, R.styleable.Follow);
        for (int i = 0; i < a.getIndexCount(); i++) {
            int attr = a.getIndex(i);
            if (a.getIndex(i) == R.styleable.Follow_target_dependcy) {
                targetId = a.getResourceId(attr, -1);
            }
        }
        a.recycle();
    }

    @Override
    public boolean layoutDependsOn(CoordinatorLayout parent, View child, View dependency) {
        return dependency.getId() == targetId;
//            return super.layoutDependsOn(parent, child, dependency);
    }

    @Override
    public boolean onDependentViewChanged(CoordinatorLayout parent, View child, View dependency) {
//        LogUtil.commonLog(dependency.getHeight() + ",getY:" + dependency.getY() + "/" + child.getHeight());
//        float rate = (dependency.getHeight() + dependency.getY()) / dependency.getHeight();
        float difference = child.getHeight() + dependency.getY();
        float rate = difference / child.getHeight();
        if (difference <= 0) {
            child.setTranslationY(child.getHeight());
        } else {
            child.setTranslationY(child.getHeight() * (1 - rate));
        }
        return true;
    }
}
