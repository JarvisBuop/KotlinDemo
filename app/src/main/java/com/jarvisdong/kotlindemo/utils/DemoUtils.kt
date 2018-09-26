package com.jarvisdong.kotlindemo.utils

import com.jarvisdong.kotlindemo.App

/**
 * Created by JarvisDong on 2018/9/26.
 * OverView:
 * 常用工具类;
 *
 * 静态方法;
 *
 */
class DemoUtils{
    companion object {
        fun getStringId(intRes : Int): String{
            return App.getApp().getString(intRes)
        }

//        fun getDrawableId(intRes :Int) : Int{
//
//        }
    }
}