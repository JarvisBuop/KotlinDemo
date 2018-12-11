package com.jarvisdong.kotlindemo.pattern.singleton

/**
 * Created by JarvisDong on 2018/12/10.
 * OverView:
 * 1.DCL 单例
 *
 */

class SingletonDemo private constructor() {

    companion object {

        @Volatile private var instance: SingletonDemo? = null

        public fun getInstance()  =  {
            instance ?: synchronized(SingletonDemo::class.java) {
                instance ?: SingletonDemo().also {
                    instance = it
                }
            }
        }
    }
}


