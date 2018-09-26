package com.jarvisdong.kotlindemo

import android.app.Application

/**
 * Created by JarvisDong on 2018/9/26.
 * OverView:
 *
 * application;
 */

class App : Application() {
    companion object {
        private var instance: App?= null
        fun getApp(): App {
           return instance!!
        }
    }

    override fun onCreate() {
        super.onCreate()
        instance = this
    }
}
