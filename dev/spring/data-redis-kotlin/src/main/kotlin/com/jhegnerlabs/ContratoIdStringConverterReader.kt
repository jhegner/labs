package com.jhegnerlabs

import org.springframework.core.convert.converter.Converter
import org.springframework.data.convert.ReadingConverter
import org.springframework.stereotype.Component

@Component
@ReadingConverter
class ContratoIdStringConverterReader: Converter<String, ContratoId> {
    override fun convert(source: String): ContratoId? {
        val data = source.split(":")
        return ContratoId(codigo = data[0], data[1])
    }
}