package com.jarvisdong.kotlindemo.pattern.iterator

/**
 * Created by JarvisDong on 2018/12/16.
 * @Description:
 * @see:
 *
 * 抽象请求者
 */
abstract class AbstractRequest public constructor(var obj:Any){

    //获取处理的内容对象
    fun getContent() : Any{
        return obj
    }

    //获取请求级别
    abstract fun getRequestLevel():Int
}