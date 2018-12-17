package com.jarvisdong.kotlindemo.pattern.abstractfactory

/**
 * Created by JarvisDong on 2018/12/15.
 * @Description:
 * @see:
 */
class ConcreateProductA2 : AbstractProductA() {
    override fun method() {
        System.out.println("具体产品类A2--越野轮胎")
    }
}