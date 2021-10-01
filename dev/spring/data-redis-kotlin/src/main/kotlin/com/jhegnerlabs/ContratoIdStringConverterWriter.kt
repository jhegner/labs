package com.jhegnerlabs

import org.springframework.core.convert.converter.Converter
import org.springframework.data.convert.WritingConverter
import org.springframework.stereotype.Component

@Component
@WritingConverter
class ContratoIdStringConverterWriter: Converter<ContratoId, String> {
    override fun convert(source: ContratoId): String? {
        return String.format("%s:%s", source.codigo, source.numero)
    }
}