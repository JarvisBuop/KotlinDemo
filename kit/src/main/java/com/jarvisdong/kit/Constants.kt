package com.jarvisdong.kit

/**
 * Created by JarvisDong on 2018/12/6.
 * OverView:
 * 常量有三种类型
 * 1. 直接const定义常量,使用 文件名.常量名
 * 2. 对象中使用const定义常量 对象名.常量名
 * 3. class中使用const定义常量 类名.常量名
 * 4. @jvmField注解,定义java中静态常量
 */

//activity类型
object ActBottomType{
    const val ACT_BOTTOM_NONE = 0
    const val ACT_BOTTOM_BTNS = 1
    const val ACT_BOTTOM_SHARE = 2
}

//六大原则
class Principle{
    companion object {
        const val SRP = 0  //
        const val OCP = 1
        const val LSP = 2
        const val DIP = 3
        const val ISP = 4
        const val LKP = 5
    }
}
