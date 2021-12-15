package br.com.jhegnerlabs

import org.junit.jupiter.api.extension.ConditionEvaluationResult
import org.junit.jupiter.api.extension.ExecutionCondition
import org.junit.jupiter.api.extension.ExtensionContext
import org.junit.platform.commons.util.AnnotationUtils
import org.junit.platform.commons.util.Preconditions

class CondicaoHorario : ExecutionCondition {

    companion object {
        val DISABLED_BY_DEFAULT: ConditionEvaluationResult = ConditionEvaluationResult.enabled("@EnabledIfHorarioPermitido nao esta presente")
    }

    override fun evaluateExecutionCondition(context: ExtensionContext?): ConditionEvaluationResult {
        val optional = AnnotationUtils.findAnnotation(
            context!!.element,
            EnabledIfHorarioPermitido::class.java
        )
        if(optional.isPresent) {
            val horarioMinimo = optional.get().horarioMinimo
            val horarioMaximo = optional.get().horarioMaximo
            Preconditions.condition(horarioMinimo.isNotBlank() && horarioMaximo.isNotBlank(), "Eh necessario declarar o horario minimo e horario maximo")
//            return ConditionEvaluationResult.enabled("Habilitado no horario entre $horarioMinimo e $horarioMaximo")
            return ConditionEvaluationResult.disabled("Nao habilitado no horario entre $horarioMinimo e $horarioMaximo")
        } else {
            return DISABLED_BY_DEFAULT
        }
    }

}