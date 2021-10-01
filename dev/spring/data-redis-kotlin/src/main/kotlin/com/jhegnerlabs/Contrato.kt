package com.jhegnerlabs

import org.springframework.data.annotation.Id
import org.springframework.data.redis.core.RedisHash

@RedisHash("contrato")
class Contrato(

//    @Id
//    var contratoId: ContratoId,

    @Id
    var codigo: String,
    var numero: String,
    var valor: String,

    )

