package com.jarvisdong.kotlindemo.pattern.Interpreter

/**
 * Created by JarvisDong on 2018/12/17.
 * @Description:
 * @see:
 *
 * 具体的数字解释器--0-9
 */
class NumExpression public constructor(var num: Int): ArithmeticExpression(){

    override fun interpreter(): Int {
        return num
    }

}