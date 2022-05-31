package br.com.jhegnerlabs

import org.junit.jupiter.api.extension.ExtendWith

@MustBeDocumented
@Target(AnnotationTarget.FUNCTION)
@Retention(AnnotationRetention.RUNTIME)
@ExtendWith(value = [CondicaoHorario::class])
annotation class EnabledIfHorarioPermitido(
    val horarioMinimo: String, val horarioMaximo: String
)