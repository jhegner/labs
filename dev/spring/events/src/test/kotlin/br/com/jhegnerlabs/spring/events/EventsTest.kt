package br.com.jhegnerlabs.spring.events

import com.nhaarman.mockitokotlin2.any
import com.nhaarman.mockitokotlin2.times
import com.nhaarman.mockitokotlin2.verify
import org.junit.jupiter.api.BeforeAll
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.TestInstance
import org.junit.jupiter.api.assertThrows
import org.junit.jupiter.api.extension.ExtendWith
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.mock.mockito.MockBean
import org.springframework.context.ApplicationEventPublisher
import org.springframework.test.context.ContextConfiguration
import org.springframework.test.context.junit.jupiter.SpringExtension

@ExtendWith(SpringExtension::class)
@ContextConfiguration(classes = [Publisher::class])
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class EventsTest {

    @Autowired
    lateinit var publisher: Publisher

    @MockBean
    lateinit var appPublisher: ApplicationEventPublisher

    @BeforeAll
    fun beforeAll() {
        publisher.setApplicationEventPublisher(this.appPublisher)
    }

    @Test
    fun `Deve testa um evento da app`() {

        publisher.publish(EventType.EVENT_1)
        publisher.publish(EventType.EVENT_2)
        publisher.publish(EventType.EVENT_3)
        verify(appPublisher, times(3)).publishEvent(any())
    }

    @Test
    fun `Deve lancar excecao quando evento nao mapeado no factory`() {

        assertThrows<IllegalStateException> {
            publisher.publish(EventType.EVENT_4)
        }
    }

}