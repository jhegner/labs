package br.com.jhegnerlabs

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

//@ExtendWith(SpringExtension::class)
//@ContextConfiguration(classes = [Cumprimento::class])
internal class CumprimentoTest {

    @Test
    fun `Deve cumprimentar com bom dia`() {
        assertEquals("Bom dia", Cumprimento().cumprimentar(ParteDia.MANHA))
    }

    @Test
    @EnabledIfHorarioPermitido(horarioMinimo = "09:00", horarioMaximo = "10:09")
    fun `Deve cumprimentar com boa tarde`() {
        assertEquals("Boa tarde", Cumprimento().cumprimentar(ParteDia.TARDE))
    }

    @Test
    fun `Deve cumprimentar com boa noite`() {
        assertEquals("Boa noite", Cumprimento().cumprimentar(ParteDia.NOITE))
    }

    fun retornaValor(): Boolean {
        return false
    }

}