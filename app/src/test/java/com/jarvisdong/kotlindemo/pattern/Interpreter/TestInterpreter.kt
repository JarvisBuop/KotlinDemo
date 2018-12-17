package com.jarvisdong.kotlindemo.pattern.Interpreter

import org.junit.Test

/**
 * Created by JarvisDong on 2018/12/17.
 * @Description:
 * @see:
 */
class TestInterpreter{

    @Test
    fun testInterpreter(){
        var calc = Calculator("1 + 2 + 3 + 4")
        System.out.println("result: "+calc.calculate())
    }
}