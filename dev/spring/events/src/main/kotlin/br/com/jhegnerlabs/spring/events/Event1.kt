package br.com.jhegnerlabs.spring.events

import org.springframework.context.ApplicationEvent

class Event1(
    source: Any,
    var msg: String = "Event 1"
) : ApplicationEvent(source) {
}