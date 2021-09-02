package br.com.jhegnerlabs.spring.events

class EventTypeFactory {

    companion object {

        fun buildEventByType(eventType: EventType) = when(eventType) {
            EventType.EVENT_1 -> Event1(this)
            EventType.EVENT_2 -> Event2(this)
            EventType.EVENT_3 -> Event3(this)
            else -> throw IllegalStateException("Event type is illegal")
        }

    }

}