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
    lateinit var template: RedisTemplate<String, String>

//    @Autowired
//    var hashOperations: HashOperations<String, ByteArray, ByteArray>? = null
//
//    var mapper: HashMapper<Any, ByteArray, ByteArray> = ObjectHashMapper()

    fun consulta(key: String): String? {
//        return template.opsForValue().get(key)
//        template.opsForHash<String, String>().putAll(
//            "cliente:0002",
//            mapOf(
//                "nome" to "cardoso",
//                "idade" to "73",
//                "telefone" to "98765345",
//                "profissao" to "professor",
//            )
//        )

//        var tmp = template.opsForHash<String, Any>().entries("cliente:0001")
//
//
//        tmp.mapKeys {
//            println("Chave: ${it.key}")
//            println("Valor: ${it.value}")
//        }

        var tmp = template.opsForHash<String, String>().multiGet("cliente:0001", listOf("nome", "idade"))

        tmp.forEach{
            println(it)
        }

        return ""
    }

}