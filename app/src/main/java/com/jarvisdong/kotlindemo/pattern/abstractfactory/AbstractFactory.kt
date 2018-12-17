package com.jarvisdong.kotlindemo.pattern.abstractfactory

/**
 * Created by JarvisDong on 2018/12/15.
 * @Description:
 * @see:
 *
 * 设计模式5-抽象工厂模式
 *
 * 抽象工厂类
 */
abstract class AbstractFactory{
    abstract fun createProductA() : AbstractProductA
    abstract fun createProductB() : AbstractProductB
}