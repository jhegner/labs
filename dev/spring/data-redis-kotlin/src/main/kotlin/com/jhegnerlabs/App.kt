package com.jhegnerlabs

import org.springframework.context.annotation.AnnotationConfigApplicationContext

class App

fun main() {

    val ctx = AnnotationConfigApplicationContext("com.jhegnerlabs")
    val consulta = ctx.getBean(Consulta::class.java)

    println("Nome: ${consulta.consulta("nome-1")}")

}