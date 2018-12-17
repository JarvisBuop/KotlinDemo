package com.jarvisdong.kotlindemo.pattern.abstractfactory

/**
 * Created by JarvisDong on 2018/12/15.
 * @Description:
 * @see:
 */
class ConcreateProductB2 : AbstractProductB() {
    override fun method() {
        System.out.println("具体产品类B2--进口发动机")
    }

}