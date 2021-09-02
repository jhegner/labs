package br.com.jhegner.labs.kotlin.tutorialspoint.basictypes

fun main() {

    var rawString : String = "Ola eu sou um tipo de String"
    val escapedString : String = "Ola eu sou outro tipo de String \n $rawString"

    println("1 -- $rawString")
    println("2 -- $escapedString")
}

