package br.com.jhegnerlabs

import br.com.jhegnerlabs.ParteDia.*

class Cumprimento {

    fun cumprimentar(parteDia: ParteDia): String {
        return when (parteDia) {
            MANHA -> {
                "Bom dia"
            }
            TARDE -> {
                "Boa tarde"
            }
            NOITE -> {
                "Boa noite"
            }
        }
    }

}

fun main() {
    println(Cumprimento().cumprimentar(TARDE))
}