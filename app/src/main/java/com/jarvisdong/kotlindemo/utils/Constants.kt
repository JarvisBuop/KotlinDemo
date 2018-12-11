package com.jarvisdong.kotlindemo.utils

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
class Principles{
    companion object {
        const val SRP = "SRP"  //单一职责原则
        const val OCP = "OCP"  //开闭原则
        const val LSP = "LSP"  //里氏替换原则
        const val DIP = "DIP"  //依赖倒置原则
        const val ISP = "ISP"  //接口隔离原则
        const val LKP = "LKP"  //最少知识原则
    }
}
//23种设计模式
class Patterns{
    companion object {
        const val SINGLETON = "SINGLETON"  //单例模式
        const val BUILDER = "BUILDER"  //构造者模式
        const val PROTOTYPE = "PROTOTYPE"  //原型模式
        const val FACTORY = "FACTORY"  //工厂模式
        const val ABSTRACT_FACTORY = "ABSTRACT_FACTORY"  //抽象工厂模式
        const val STRAGETY = "STRAGETY"  //策略模式
        const val STATE = "STATE"  //状态模式
        const val ITERATOR_HANDLER = "ITERATOR_HANDLER"  //责任链模式
        const val INTERPRETER = "INTERPRETER"  //解释器模式
        const val COMMAND = "COMMAND"  //命令模式
        const val OBSERVER = "OBSERVER"  //观察者模式
        const val MEMENTO = "MEMENTO"  //备忘录模式
        const val ITERATOR = "ITERATOR"  //迭代器模式
        const val TEMPLATE = "TEMPLATE"  //模板模式
        const val VISITOR = "VISITOR"  //访问者模式
        const val MEDIATOR = "MEDIATOR"  //中介者模式
        const val PROXY = "PROXY"  //代理模式
        const val COMPOSITE = "COMPOSITE"  //组合模式
        const val ADAPTER = "ADAPTER"  //适配器模式
        const val DECORATOR = "DECORATOR"  //装饰者模式
        const val FLYWEIGHT = "FLYWEIGHT"  //享元模式
        const val FACADE = "FACADE"  //外观模式
        const val BRIDGE = "BRIDGE"  //桥接模式
    }
}
