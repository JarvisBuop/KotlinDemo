package com.jarvisdong.kotlindemo.pattern.factory

/**
 * Created by JarvisDong on 2018/12/15.
 * @Description:
 * @see:
 *
 * 设计模式4-工厂模式
 *
 * [简单工厂模式]--直接使用静态方法造对象;
 *
 * 抽象产品类
 */
abstract class Product {

    abstract fun method()
}