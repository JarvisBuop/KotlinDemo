package com.jarvisdong.kotlindemo.pattern.state

/**
 * Created by JarvisDong on 2018/12/16.
 * @Description:
 * @see:
 *
 * 设计模式7--状态模式
 *
 * 抽象状态类
 */
interface State{
    fun nextChannel()
    fun preChannel()
    fun turnUp()
    fun turnDown()
}