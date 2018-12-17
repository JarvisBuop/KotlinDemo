package com.jarvisdong.kotlindemo.pattern.Interpreter

/**
 * Created by JarvisDong on 2018/12/17.
 * @Description:
 * @see:
 *
 * 抽象的操作符解释器--+ -
 */
abstract class OperaterExpression public constructor(val exp1: ArithmeticExpression,
                                                     val exp2: ArithmeticExpression) : ArithmeticExpression() {

}