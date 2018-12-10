package com.jarvisdong.kotlindemo.pattern.singleton

/**
 * Created by JarvisDong on 2018/12/10.
 * OverView:
 */

class SingletonDemo {
    private var instance: SingletonDemo? = null

    fun getInstance(): SingletonDemo {
        if (instance == null) {
            instance = SingletonDemo()
        }
        return instance as SingletonDemo
    }
}
