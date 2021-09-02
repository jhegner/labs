package br.com.jhegner.labs.kotlin.tutorialspoint.basictypes

fun main(args : Array<String>) {
    val numbers : IntArray = intArrayOf(1,2,3,4,5,6)
    println("Ola!! Eu sou um array de exemplo: ")

    println("# modo 1")
    numbers.forEach { i: Int -> print(i) }

    println("\n# modo 2")
    (0 until numbers.size).forEach {print(numbers[it])}

    println("\n# modo 3")
    (numbers.indices).forEach { print(numbers[it])}

    println("\n# modo 4")
    numbers.forEach { print( it ) }

    println("\n# modo 5")
    numbers.forEach(::print)

}