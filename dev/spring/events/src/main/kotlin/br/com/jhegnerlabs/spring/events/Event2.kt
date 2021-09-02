package br.com.jhegnerlabs.spring.events

import org.springframework.context.ApplicationEvent

class Event2(
    source: Any,
    var msg: String = "Event 3"
) : ApplicationEvent(source) {
}