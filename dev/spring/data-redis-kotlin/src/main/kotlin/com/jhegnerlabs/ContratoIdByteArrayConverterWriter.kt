package com.jhegnerlabs

import org.springframework.core.convert.converter.Converter
import org.springframework.data.convert.WritingConverter
import org.springframework.stereotype.Component

@Component
@WritingConverter
class ContratoIdByteArrayConverterWriter: Converter<ContratoId, ByteArray> {
    override fun convert(source: ContratoId): ByteArray? {
        return String.format("%s:%s", source.codigo, source.numero).toByteArray()
    }
}