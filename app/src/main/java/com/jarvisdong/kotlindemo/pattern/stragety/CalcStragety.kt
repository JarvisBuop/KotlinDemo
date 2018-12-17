package com.jarvisdong.kotlindemo.pattern.stragety

/**
 * Created by JarvisDong on 2018/12/16.
 * @Description:
 * @see:
 *
 * 设计模式6--策略模式
 * 抽象策略类
 */
interface CalcStragety{
    fun calcPcice( km : Int) : Int
}