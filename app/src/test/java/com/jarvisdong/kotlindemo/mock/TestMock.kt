package com.jarvisdong.kotlindemo.mock

import org.junit.Test

/**
 * Created by JarvisDong on 2018/12/12.
 * OverView:
 */

class TestInterface{
    fun a(){
        System.out.println("test a")
    }
}

class TestMock{

    fun testImplFunc(call: TestInterface.()->Unit){
        call.invoke(TestInterface())
    }

    @Test
    fun testMockAnno() {
        testImplFunc {
            System.out.println("invoke $this ${this.a()}")
        }
    }
}
