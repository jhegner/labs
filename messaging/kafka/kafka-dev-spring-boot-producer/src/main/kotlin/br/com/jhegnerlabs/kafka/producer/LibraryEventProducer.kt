package br.com.jhegnerlabs.kafka.producer

import br.com.jhegnerlabs.kafka.domain.LibraryEvent
import com.fasterxml.jackson.databind.ObjectMapper
import org.slf4j.LoggerFactory
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.kafka.core.KafkaTemplate
import org.springframework.kafka.support.SendResult
import org.springframework.stereotype.Component
import org.springframework.util.concurrent.ListenableFutureCallback
import kotlin.jvm.Throws


@Component
class LibraryEventProducer {

    private val logger = LoggerFactory.getLogger(LibraryEventProducer::class.java)

    @Autowired
    lateinit var kafkaTemplate: KafkaTemplate<Int, String>

    @Autowired
    lateinit var mapper: ObjectMapper

    fun sendLibraryEventAsync(libraryEvent: LibraryEvent) {

        val key = libraryEvent.librarayEventId
        val data = mapper.writeValueAsString(libraryEvent)

        val resultListenableFuture = kafkaTemplate.sendDefault(key, data)

        resultListenableFuture.addCallback(object : ListenableFutureCallback<SendResult<Int?, String?>?> {

            override fun onSuccess(result: SendResult<Int?, String?>?) {
                handleSuccess(key, data, result)
            }

            override fun onFailure(ex: Throwable) {
                handleFailure(key, data, ex)
            }
        })
    }

    @Throws(Exception::class)
    fun sendLibraryEventSync(libraryEvent: LibraryEvent): SendResult<Int, String> {

        val key = libraryEvent.librarayEventId
        val data = mapper.writeValueAsString(libraryEvent)

        return kafkaTemplate.sendDefault(key, data).get()

    }

    private fun handleFailure(key: Int, data: String?, ex: Throwable) {
        logger.error("Mensagem de erro enviada - {}", ex.message)
        throw ex
    }

    private fun handleSuccess(key: Int, data: String?, result: SendResult<Int?, String?>?) {
        logger.info(
            "Mensagem enviada com sucesso - Key: {} e Data: {}, na Particao: {} ",
            key,
            data,
            result!!.recordMetadata.partition()
        )
    }
}