package br.com.jhegnerlabs.kafka.controller

import br.com.jhegnerlabs.kafka.domain.LibraryEvent
import br.com.jhegnerlabs.kafka.producer.LibraryEventProducer
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api/v1")
class LibraryEventsController {

    @Autowired
    lateinit var producer: LibraryEventProducer

    @PostMapping("/libraryevent")
    fun postLibraryEvent(@RequestBody libraryEvent: LibraryEvent) {
//        producer.sendLibraryEventAsync(libraryEvent)
        producer.sendLibraryEventSync(libraryEvent)
        ResponseEntity.status(HttpStatus.CREATED).body(libraryEvent)
    }

}