package com.jhegnerlabs

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.data.redis.core.RedisTemplate
import org.springframework.stereotype.Component

@Component
class Consulta {

    @Autowired
    lateinit var template: RedisTemplate<String, String>

    fun consulta(key: String): String? {
        return template.opsForValue().get(key)
    }

}