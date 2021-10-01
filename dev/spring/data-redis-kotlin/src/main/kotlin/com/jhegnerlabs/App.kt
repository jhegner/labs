package com.jhegnerlabs

import org.springframework.context.annotation.AnnotationConfigApplicationContext

class App

fun main() {

    val ctx = AnnotationConfigApplicationContext("com.jhegnerlabs")

//    val consulta = ctx.getBean(Consulta::class.java)
//    println("Nome: ${consulta.consulta("nome-1")}")

//    val c2 = Consulta2().consulta2()
//    println(c2)

//    val c3 = ctx.getBean(Consulta3::class.java)
//    c3.consulta3()
//    println(c3)

    val c4 = ctx.getBean(ConsultaContrato::class.java)
    c4.consulta()

}