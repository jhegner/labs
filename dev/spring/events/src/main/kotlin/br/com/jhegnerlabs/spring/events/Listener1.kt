package br.com.jhegnerlabs.spring.events

import org.springframework.context.event.EventListener
import org.springframework.stereotype.Component

@Component
class Listener1 {

    @EventListener
    fun listen(event1: Event1) {
        println("Listener1 processando o ${event1.msg}")
    }
}