package com.jarvisdong.kotlindemo.pattern.iterator

import org.junit.Test

/**
 * Created by JarvisDong on 2018/12/16.
 * @Description:
 * @see:
 *
 * 测试责任链模式
 */
class TestIterator{

    @Test
    fun testIterator(){
        var handler1 = Handler1()
        var handler2 = Handler2()

        //设立节点链
        handler1.nextHander = handler2

        var request1 = Request1("request1")
        var request2 = Request2("request2")

        //启动链首端
        handler1.handleRequest(request1)
        handler1.handleRequest(request2)
    }
}