package com.jarvisdong.kotlindemo.pattern.stragety

/**
 * Created by JarvisDong on 2018/12/16.
 * @Description:
 * @see:
 *
 * 具体的可替换的
 * 策略之一--bus
 */
class BusStragety : CalcStragety{
    override fun calcPcice(km : Int): Int {
        System.out.println("bus calc result")
        return 2
    }

}