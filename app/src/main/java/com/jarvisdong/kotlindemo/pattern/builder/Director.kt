package com.jarvisdong.kotlindemo.pattern.builder

/**
 * Created by JarvisDong on 2018/12/13.
 * OverView:
 *
 * 统一组装过程类,负责构造产品
 */
class Director public constructor(val builder: Builder) {

    fun construct(board: String) {
        builder.buildBoard(board)
        builder.buildOs()
    }
}