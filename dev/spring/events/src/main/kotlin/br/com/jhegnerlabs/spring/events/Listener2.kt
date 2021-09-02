package br.com.jhegnerlabs.spring.events

import org.springframework.context.event.EventListener
import org.springframework.stereotype.Component

@Component
class Listener2 {

    @EventListener
    fun listen(event1: Event1) {
        println("Listener2 processando o ${event1.msg}")
    }
}