package com.jarvisdong.kotlindemo.pattern.state

/**
 * Created by JarvisDong on 2018/12/16.
 * @Description:
 * @see:
 *
 * 关机状态
 * 所有方法都无效化;
 */
class PowerOffState : State{
    override fun nextChannel() {

    }

    override fun preChannel() {
    }

    override fun turnUp() {

    }

    override fun turnDown() {
    }

}