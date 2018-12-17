package com.jarvisdong.kotlindemo.pattern.abstractfactory

/**
 * Created by JarvisDong on 2018/12/15.
 * @Description:
 * @see:
 */
class ConcreateFactory2 : AbstractFactory() {
    override fun createProductB(): AbstractProductB {
        return ConcreateProductB2()
    }

    override fun createProductA(): AbstractProductA {
        return ConcreateProductA2()
    }

}