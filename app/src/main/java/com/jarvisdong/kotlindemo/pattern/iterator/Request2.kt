package com.jarvisdong.kotlindemo.pattern.iterator

/**
 * Created by JarvisDong on 2018/12/16.
 * @Description:
 * @see:
 *
 * 具体的请求类
 */
class Request2 public constructor(obj: Any) : AbstractRequest(obj) {
    override fun getRequestLevel(): Int {
        return 2
    }

}