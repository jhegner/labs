package com.jhegnerlabs

import org.springframework.data.annotation.Id
import org.springframework.data.redis.core.RedisHash

@RedisHash("cliente")
data class Cliente (

    @Id
    var id: String,

    var nome: String,

    var idade: String,

    var telefone: String,

    var profissao: String

)