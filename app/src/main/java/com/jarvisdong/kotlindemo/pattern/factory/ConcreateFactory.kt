package com.jarvisdong.kotlindemo.pattern.factory

/**
 * Created by JarvisDong on 2018/12/15.
 * @Description:
 * @see:
 *
 * 具体的工厂类
 */
class ConcreateFactory : Factory() {
    override fun <T : Product> createProduct(clazz: Class<T>): T {
        var p : Product? = null
        try {
            p = Class.forName(clazz.name).newInstance() as Product
        }catch (e:Exception){
            e.printStackTrace()
        }
        return p as T
    }

}