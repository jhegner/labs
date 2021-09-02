package br.com.jhegner.labs.kotlin.tutorialspoint.basictypes

fun main() {
    val numbers: MutableList<Int> = mutableListOf(1, 2, 3, 4, 5, 6, 7, 8, 9, 10)
    val numbersReadOnly : List<Int> = listOf(10, 20, 30 , 40, 50, 60, 70 ,80, 90, 100)

    println("Minha lista de Interios mutaveis: $numbers")
    println("Minha lista de Interios Imutaveis: $numbersReadOnly")

    // metodos utilitarios
    println(numbers.first())
    println(numbers.first())
    println(numbers.filter {
        it > 5
    })
    printMap()
    printSet()
}

fun printMap () {
    val meuMap = hashMapOf("um" to 1, "dois" to 2)
    println(meuMap["um"])
}

fun printSet () {
    val meuSet = hashSetOf("a", "b", "c", "c")
    println(meuSet)
}