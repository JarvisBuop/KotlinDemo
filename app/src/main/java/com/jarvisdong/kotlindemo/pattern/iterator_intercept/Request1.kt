package com.jarvisdong.kotlindemo.pattern.iterator_intercept

/**
 * Created by JarvisDong on 2018/12/16.
 * @Description:
 * @see:
 *
 * 具体的请求类,待处理请求;
 *
 * >>封装的是待处理的条件和被处理数据;
 */
class Request1 public constructor(obj: Any) : AbstractRequest(obj) {
    override fun getRequestLevel(): Int {
        return 1
    }

}