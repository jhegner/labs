package com.jhegnerlabs

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.data.redis.core.HashOperations
import org.springframework.data.redis.core.RedisTemplate
import org.springframework.data.redis.hash.HashMapper
import org.springframework.data.redis.hash.ObjectHashMapper
import org.springframework.stereotype.Component


//@Component
class Consulta {

    @Autowired
    lateinit var template: RedisTemplate<String, Any>

    fun consulta(key: String): String? {

        template.opsForValue().get(key)

        template.opsForHash<String, Any>().putAll(
            "cliente:0050",
            mapOf(
                "nome" to "sdfaasdfadsf asdfas ",
                "idade" to "73",
                "telefone" to "5345 435435",
                "profissao" to "professor",
            )
        )

        var tmp = template.opsForHash<String, Any>().entries("cliente:0001")
        tmp.mapKeys {
            println("Chave: ${it.key}")
            println("Valor: ${it.value}")
        }

        var tmp2 = template.opsForHash<String, Any>().multiGet("cliente:0001", listOf("nome", "idade"))
        tmp2.forEach{
            println(it)
        }

        return ""
    }

}