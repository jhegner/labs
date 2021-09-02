package br.com.jhegnerlabs.spring.events

import org.springframework.context.ApplicationEventPublisher
import org.springframework.context.ApplicationEventPublisherAware
import org.springframework.stereotype.Component

@Component
class Publisher : ApplicationEventPublisherAware {

    private lateinit var appPublisher: ApplicationEventPublisher

    override fun setApplicationEventPublisher(applicationEventPublisher: ApplicationEventPublisher) {
        this.appPublisher = applicationEventPublisher
    }

    fun publish(eventType: EventType){
        appPublisher.publishEvent(EventTypeFactory.buildEventByType(eventType))
    }
}