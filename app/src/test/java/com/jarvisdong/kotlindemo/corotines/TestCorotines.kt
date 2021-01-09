package com.jarvisdong.kotlindemo.corotines

import kotlinx.coroutines.*
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.channels.ReceiveChannel
import kotlinx.coroutines.channels.SendChannel
import kotlinx.coroutines.channels.produce
import kotlinx.coroutines.flow.*
import org.junit.Test
import java.lang.Exception
import kotlin.system.measureTimeMillis

class TestCorotines {

    @Test
    fun main() = runBlocking { // this: CoroutineScope
        launch {
            delay(150L)
            println("Task from runBlocking")
        }

        // 创建一个协程作用域，没执行完不会结束
        coroutineScope {
            launch {
                delay(500L)
                println("Task from nested launch")
            }

            delay(100L)
            println("Task from coroutine scope") // 这一行会在内嵌 launch 之前输出
        }

        println("Coroutine scope is over") // 这一行在内嵌 launch 执行完毕后才输出
    }


    companion object {
        var acquired = 0
    }

    class Resource {
        init {
            acquired++
        } // Acquire the resource

        fun close() {
            acquired--
        } // Release the resource
    }

    @Test
    fun main1() {
        runBlocking {
            repeat(100_000) { // Launch 100K coroutines
                launch {
                    var resource: Resource? = null // Not acquired yet
                    try {
                        withTimeout(60) { // Timeout of 60 ms
                            delay(50) // Delay for 50 ms
                            resource = Resource() // Store a resource to the variable if acquired
                        }
                        // We can do something else with the resource here
                    } finally {
                        resource?.close() // Release the resource if it was acquired
                    }
                }
            }
        }
        // Outside of runBlocking all coroutines have completed
        println(acquired) // Print the number of resources still acquired
    }

    @Test
    fun main2() = runBlocking<Unit> {
        launch { // 运行在父协程的上下文中，即 runBlocking 主协程
            println("main runBlocking      : I'm working in thread ${Thread.currentThread().name}")
        }
        launch(Dispatchers.Unconfined) { // 不受限的——将工作在主线程中
            println("Unconfined            : I'm working in thread ${Thread.currentThread().name}")
        }
        launch(Dispatchers.Default) { // 将会获取默认调度器
            println("Default               : I'm working in thread ${Thread.currentThread().name}")
        }
        launch(Dispatchers.IO) {
            println("IO               : I'm working in thread ${Thread.currentThread().name}")
        }
//        launch(Dispatchers.Main) {
//            println("Main               : I'm working in thread ${Thread.currentThread().name}")
//        }
        launch(newSingleThreadContext("MyOwnThread")) { // 将使它获得一个新的线程
            println("newSingleThreadContext: I'm working in thread ${Thread.currentThread().name}")
        }
    }

    @Test
    fun main3() = runBlocking<Unit> {
        launch(Dispatchers.Unconfined) { // 非受限的——将和主线程一起工作
            println("Unconfined      : I'm working in thread ${Thread.currentThread().name}")
            delay(1000)
            println("Unconfined      : After delay in thread ${Thread.currentThread().name}")
        }
        launch { // 父协程的上下文，主 runBlocking 协程
            println("main runBlocking: I'm working in thread ${Thread.currentThread().name}")
            delay(2000)
            println("main runBlocking: After delay in thread ${Thread.currentThread().name}")
        }
    }

    val threadLocal = ThreadLocal<String?>() // 声明线程局部变量

    @Test
    fun main4() = runBlocking<Unit> {
        threadLocal.set("main")
        println("Pre-main, current thread: ${Thread.currentThread()}, thread local value: '${threadLocal.get()}'")
        val job = launch(Dispatchers.Default + threadLocal.asContextElement(value = "launch")) {
            println("Launch start, current thread: ${Thread.currentThread()}, thread local value: '${threadLocal.get()}'")
            yield()
            println("After yield, current thread: ${Thread.currentThread()}, thread local value: '${threadLocal.get()}'")
        }
        job.join()
        println("Post-main, current thread: ${Thread.currentThread()}, thread local value: '${threadLocal.get()}'")
    }

    fun simple(): Sequence<Int> = sequence { // 序列构建器
        for (i in 1..3) {
            Thread.sleep(100) // 假装我们正在计算
            yield(i) // 产生下一个值
        }
    }
    @Test
    fun main5() {
        simple().forEach { value -> println(value) }
    }

    fun numbers(): Flow<Int> = flow {
//        try {
            emit(1)
            emit(2)
            println("This line will not execute")
            emit(3)
//        } catch (e:Exception){
//            println("$e")
//        }
//        finally {
//            println("Finally in numbers")
//        }
    }

    @Test
    fun main6() = runBlocking<Unit> {
        numbers()
                .take(2) // 只获取前两个
                .collect {
                    value -> println(value)
                }
    }

    fun simple_throw(): Flow<Int> = flow {
        emit(1)
        throw RuntimeException()
    }

    @Test
    fun main7() = runBlocking<Unit> {
        simple_throw()
                .catch { cause -> println("Caught exception") }
                .onCompletion { cause -> if (cause != null) println("Flow completed exceptionally") }
                .collect { value -> println(value) }
    }

    @Test
    fun main8() = runBlocking {

        val channel = Channel<Int>()
        launch {
            // 这里可能是消耗大量 CPU 运算的异步逻辑，我们将仅仅做 5 次整数的平方并发送
            for (x in 1..5) channel.send(x * x)
        }
        // 这里我们打印了 5 次被接收的整数：
        repeat(0) { println(channel.receive()) }
        println("Done!")
    }

    @Test
    fun main9() = runBlocking<Unit> {
        val producer = produceNumbers()
        repeat(5) { launchProcessor(it, producer) }
        delay(950)
        producer.cancel() // 取消协程生产者从而将它们全部杀死
    }

    fun CoroutineScope.produceNumbers() = produce<Int> {
        var x = 1 // start from 1
        while (true) {
            send(x++) // 产生下一个数字
            delay(100) // 等待 0.1 秒
        }
    }

    fun CoroutineScope.launchProcessor(id: Int, channel: ReceiveChannel<Int>) = launch {
        for (msg in channel) {
            println("Processor #$id received $msg")
        }
    }

    @Test
    fun main10() = runBlocking {
        val channel = Channel<String>()
        launch { sendString(channel, "foo", 200L) }
        launch { sendString(channel, "BAR!", 500L) }
        repeat(6) { // 接收前六个
            println(channel.receive())
        }
        coroutineContext.cancelChildren() // 取消所有子协程来让主协程结束
    }

    suspend fun sendString(channel: SendChannel<String>, s: String, time: Long) {
        while (true) {
            delay(time)
            channel.send(s)
        }
    }
}