package com.jarvisdong.kotlindemo.pattern.singleton

/**
 * Created by JarvisDong on 2018/12/10.
 * OverView:
 * 1.DCL 单例
 */

class SingletonDemo {
    @Volatile private var instance: SingletonDemo? = null

    public fun getInstance(): SingletonDemo {
        if (instance == null) {
            synchronized(SingletonDemo::class.java) {
                if (instance == null) {
                    instance = SingletonDemo()
                }
            }
        }
        return instance!!
    }
}
