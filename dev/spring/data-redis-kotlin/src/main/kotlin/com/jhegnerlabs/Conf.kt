package com.jhegnerlabs

import com.fasterxml.jackson.module.kotlin.jacksonObjectMapper
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.data.redis.connection.RedisConnectionFactory
import org.springframework.data.redis.connection.RedisStandaloneConfiguration
import org.springframework.data.redis.connection.lettuce.LettuceConnectionFactory
import org.springframework.data.redis.core.RedisTemplate
import org.springframework.data.redis.core.convert.RedisCustomConversions
import org.springframework.data.redis.repository.configuration.EnableRedisRepositories
import org.springframework.data.redis.serializer.Jackson2JsonRedisSerializer
import org.springframework.data.redis.serializer.StringRedisSerializer

@Configuration
@EnableRedisRepositories
class Conf {

    @Bean
    fun redisConnectionFactory(): LettuceConnectionFactory {
        return LettuceConnectionFactory(RedisStandaloneConfiguration("localhost", 6379))
    }

//    @Bean
//    fun redisTempalate(redisConnectionFactory: RedisConnectionFactory): RedisTemplate<String, String>{
//
//        val redisTemplate = RedisTemplate<String, String>()
//        redisTemplate.connectionFactory = redisConnectionFactory
//        redisTemplate.hashKeySerializer = StringRedisSerializer()
//        redisTemplate.hashValueSerializer = StringRedisSerializer()
//
//        return redisTemplate
//    }

//    @Bean("redisTemplate")
//    fun redisTemplate2(redisConnectionFactory: RedisConnectionFactory): RedisTemplate<String, Any>{
//
//        val redisTemplate = RedisTemplate<String, Any>()
//
//        redisTemplate.connectionFactory = redisConnectionFactory
//
//        redisTemplate.keySerializer = StringRedisSerializer()
//        redisTemplate.valueSerializer = StringRedisSerializer()
//        redisTemplate.hashValueSerializer = StringRedisSerializer()
//        redisTemplate.hashValueSerializer = StringRedisSerializer()
//
//        redisTemplate.afterPropertiesSet()
//
//        return redisTemplate
//    }

//    @Bean
//    fun redisTemplateCliente(redisConnectionFactory: RedisConnectionFactory?): RedisTemplate<String, Cliente>? {
//        val template = RedisTemplate<String, Cliente>()
//
//        val clienteValueSerializer = Jackson2JsonRedisSerializer(Cliente::class.java)
//        clienteValueSerializer.setObjectMapper(jacksonObjectMapper())
//
//        template.connectionFactory = redisConnectionFactory
//        template.keySerializer = StringRedisSerializer()
//        template.valueSerializer = clienteValueSerializer
//
//        template.afterPropertiesSet()
//
//        return template
//    }

//    @Bean
//    fun redisTemplateContrato(redisConnectionFactory: RedisConnectionFactory?): RedisTemplate<IdContrato, Contrato>? {
//        val template = RedisTemplate<IdContrato, Contrato>()
//
//        val conSer = Jackson2JsonRedisSerializer(Contrato::class.java)
//        conSer.setObjectMapper(jacksonObjectMapper())
//
//        template.connectionFactory = redisConnectionFactory
//        template.keySerializer = StringRedisSerializer()
//        template.valueSerializer = conSer
//
//        template.afterPropertiesSet()
//
//        return template
//    }

//    @Bean("redisTemplate")
//    fun redisTemplateContrato(redisConnectionFactory: RedisConnectionFactory?): RedisTemplate<String, Contrato>? {
//
//        val template = RedisTemplate<ContratoId, String>()
//
//        template.connectionFactory = redisConnectionFactory
//
//        template.keySerializer = ContratoIdSerializer()
//        template.valueSerializer = StringRedisSerializer()
//        template.hashKeySerializer = StringRedisSerializer()
//        template.hashValueSerializer = StringRedisSerializer()
//
//        template.afterPropertiesSet()
//
//        return template
//    }

//    @Bean("redisTemplate") //last
//    fun redisTemplateContrato2(redisConnectionFactory: RedisConnectionFactory?): RedisTemplate<ContratoId, Contrato>? {
//
//        val template = RedisTemplate<ContratoId, Contrato>()
//
//        val contratoSerializer = Jackson2JsonRedisSerializer(Contrato::class.java)
//        contratoSerializer.setObjectMapper(jacksonObjectMapper())
//
//        template.connectionFactory = redisConnectionFactory
//
////        template.keySerializer = StringRedisSerializer()
//        template.keySerializer = ContratoIdSerializer()
////        template.valueSerializer = StringRedisSerializer()
//        template.hashKeySerializer = ContratoIdSerializer()
//        template.hashValueSerializer = contratoSerializer
//
//        template.afterPropertiesSet()
//
//        return template
//    }

//    @Bean("redisTemplate")
//    fun redisTemplateContrato2(redisConnectionFactory: RedisConnectionFactory?): RedisTemplate<String, Contrato>? {
//
//        val template = RedisTemplate<String, Contrato>()
//
//        val contratoSerializer = Jackson2JsonRedisSerializer(Contrato::class.java)
//        contratoSerializer.setObjectMapper(jacksonObjectMapper())
//
//        template.connectionFactory = redisConnectionFactory
//
//        template.keySerializer = StringRedisSerializer()
//        template.hashKeySerializer = StringRedisSerializer()
//        template.hashValueSerializer = contratoSerializer
//
//        template.afterPropertiesSet()
//
//        return template
//    }

    @Bean("redisTemplate")
    fun redisTemplateContrato2(redisConnectionFactory: RedisConnectionFactory?): RedisTemplate<String, String>? {

        val template = RedisTemplate<String, String>()

        template.connectionFactory = redisConnectionFactory

        template.keySerializer = StringRedisSerializer()
//        template.valueSerializer = StringRedisSerializer()
        template.hashKeySerializer = StringRedisSerializer()
        template.hashValueSerializer = StringRedisSerializer()

        template.afterPropertiesSet()

        return template
    }

//    @Bean
//    fun redisCustomConversions(
//        readerByteArray: ContratoIdByteArrayConverterReader,
//        writerByteArray: ContratoIdByteArrayConverterWriter,
//        readerString: ContratoIdStringConverterReader,
//        writerString: ContratoIdStringConverterWriter
//    ): RedisCustomConversions {
//        return RedisCustomConversions(
//            arrayListOf(readerByteArray, writerByteArray, readerString, writerString)
//        )
//    }

}