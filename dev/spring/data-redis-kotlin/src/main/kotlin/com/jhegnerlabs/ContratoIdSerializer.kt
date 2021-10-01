package com.jhegnerlabs

import org.springframework.data.redis.serializer.RedisSerializer

class ContratoIdSerializer : RedisSerializer<ContratoId> {

    override fun serialize(t: ContratoId?): ByteArray {
        return String.format("%s:%s", t?.codigo, t?.numero).toByteArray()
    }

    override fun deserialize(bytes: ByteArray): ContratoId? {
        val data = String(bytes).split(":")
        return ContratoId(codigo = data[0], data[1])
    }

}