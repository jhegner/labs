package com.jhegnerlabs

import com.fasterxml.jackson.module.kotlin.jacksonObjectMapper
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.context.annotation.Primary
import org.springframework.data.redis.connection.RedisConnectionFactory
import org.springframework.data.redis.connection.RedisStandaloneConfiguration
import org.springframework.data.redis.connection.lettuce.LettuceConnectionFactory
import org.springframework.data.redis.core.RedisTemplate
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

//    @Bean
//    fun redisTemplate2(redisConnectionFactory: RedisConnectionFactory): RedisTemplate<String, ByteArray>{
//        val redisTemplate = RedisTemplate<String, ByteArray>()
//        redisTemplate.connectionFactory = redisConnectionFactory
//        redisTemplate.keySerializer = StringRedisSerializer()
//        return redisTemplate
//    }

    @Bean("redisTemplate")
//    @Primary
    fun redisTemplate3(redisConnectionFactory: RedisConnectionFactory?): RedisTemplate<String, Cliente>? {
        val template = RedisTemplate<String, Cliente>()

        val clienteValueSerializer = Jackson2JsonRedisSerializer(Cliente::class.java)
        clienteValueSerializer.setObjectMapper(jacksonObjectMapper())

        template.connectionFactory = redisConnectionFactory
        template.keySerializer = StringRedisSerializer()
        template.valueSerializer = clienteValueSerializer

        template.afterPropertiesSet()

        return template
    }

}