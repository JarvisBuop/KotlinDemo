package com.jarvisdong.kotlindemo.pattern.Interpreter

import java.util.*

/**
 * Created by JarvisDong on 2018/12/17.
 * @Description:
 * @see:
 *
 * 与解释器相关业务--计算;
 */
class Calculator public constructor(expression: String) {
    private var mExpStack = Stack<ArithmeticExpression>()

    init {
        var exp1: ArithmeticExpression? = null
        var exp2: ArithmeticExpression? = null
        var elements = expression.split(" ")

        for (i in 0..elements.size - 1) {
            var index = i

            System.out.println("item: " + elements.toString() + "  " + elements[i].trim().get(0))
            when (elements[i].trim().get(0)) {
                '+' -> {
                    exp1 = mExpStack.pop()
                    exp2 = NumExpression(Integer.valueOf(elements[++index]))
                    mExpStack.push(AddtionExpression(exp1, exp2))
                }
                else -> {
                    mExpStack.push(NumExpression(Integer.valueOf(elements[index])))
                }
            }
        }
    }

    fun calculate(): Int {
        mExpStack.pop()
        return mExpStack.pop().interpreter()
    }
}