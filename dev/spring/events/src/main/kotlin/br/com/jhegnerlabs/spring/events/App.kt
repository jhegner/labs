package br.com.jhegnerlabs.spring.events

import org.springframework.context.annotation.AnnotationConfigApplicationContext

class App

fun main(args: Array<String>) {
    val appContext =
        AnnotationConfigApplicationContext(Publisher::class.java, Listener1::class.java, Listener2::class.java)
    val appPublisher = appContext.getBean("publisher") as Publisher
    appPublisher.publish(EventType.EVENT_1)
}