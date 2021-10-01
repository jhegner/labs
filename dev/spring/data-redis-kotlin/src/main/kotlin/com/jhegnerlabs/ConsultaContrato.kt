package com.jhegnerlabs

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.data.redis.core.RedisTemplate
import org.springframework.stereotype.Component

@Component
class ConsultaContrato {

    @Autowired
    lateinit var repo: ContratoRepository

//    @Autowired
//    lateinit var template: RedisTemplate<ContratoId, String>

//    @Autowired
//    lateinit var template2: RedisTemplate<ContratoId, Contrato>

    @Autowired
    lateinit var template3: RedisTemplate<String, String>

    fun consulta(): String {

//        val retoAll = repo.findAll()
//
//        println(retoAll)

//        val retro1 = repo.findById(ContratoId("001", "00001"))

//        val ret = template.opsForHash<ContratoId, String>().get(ContratoId("002", "00002"), "valor")

//        println(retro1)

//        template2.opsForHash<String, Contrato>().putAll("007:00007", mutableMapOf(
//            "007:00007" to Contrato("00007", "007", "7000")
//        ))

//        repo.saveAll(
//            mutableListOf(
//                Contrato(
//                    ContratoId("001", "0001"),
//                    "001",
//                    "0001",
//                    "1000"
//                ),
//                Contrato(
//                    ContratoId("002", "0002"),
//                    "002",
//                    "0002",
//                    "2000"
//                )
//            )
//        )

//        val ret1 = repo.findById(ContratoId("001", "0001"))
//        val ret2 = repo.findById(ContratoId("002", "0002"))

//        repo.saveAll(
//            mutableListOf(
//                Contrato(
//                    "001:0001",
//                    "0001",
//                    "1000"
//                ),
//                Contrato(
//                    "002:0002",
//                    "0002",
//                    "2000"
//                )
//            )
//        )

        val codigo = "005"
        val numero = "0005"

//        val ret2 = repo.findById("contrato:$codigo:$numero")

        template3.opsForHash<String, String>().putAll("contrato:$codigo:$numero",
        mutableMapOf(
            "codigo" to codigo,
            "numero" to numero,
            "valor" to "5000"
        ))

        val ret3 = template3.opsForHash<String, String>().entries("contrato:$codigo:$numero")


        return "Ok"

    }
}