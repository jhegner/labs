package com.jhegnerlabs

import org.springframework.core.convert.converter.Converter
import org.springframework.data.convert.ReadingConverter
import org.springframework.stereotype.Component

@Component
@ReadingConverter
class ContratoIdByteArrayConverterReader: Converter<ByteArray, ContratoId> {
    override fun convert(source: ByteArray): ContratoId? {
        val data = String(source).split(":")
        return ContratoId(codigo = data[0], data[1])
    }
}