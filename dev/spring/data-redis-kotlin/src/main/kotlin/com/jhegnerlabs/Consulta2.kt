package com.jhegnerlabs

import io.lettuce.core.RedisClient


class Consulta2 {

    fun consulta2(): String {

        val redisClient = RedisClient.create("redis://localhost/0")
        val connection = redisClient.connect()

        println("Connected to Redis")
        connection.sync().set("mensagem", "Hello World")

        try {

            val msg = connection.sync().get("mensagem")
            println(msg)

            val cliente = connection.sync().hmget("cliente:0001", "nome", "telefone")
            println(cliente)

            return ""

        } finally {

            connection.close()
            redisClient.shutdown()
        }
    }
}