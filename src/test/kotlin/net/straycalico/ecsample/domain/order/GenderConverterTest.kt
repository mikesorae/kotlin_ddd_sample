package net.straycalico.ecsample.domain.order

import org.junit.Test

import org.junit.Assert.*

class GenderConverterTest {

    @Test
    fun convertToDatabaseColumn() {
        val conv = GenderConverter()
        assertEquals("MALE", conv.convertToDatabaseColumn(Gender.MALE))
        assertEquals("FEMALE", conv.convertToDatabaseColumn(Gender.FEMALE))
        assertEquals("OTHER", conv.convertToDatabaseColumn(Gender.OTHER))
        assertEquals("UNKNOWN", conv.convertToDatabaseColumn(Gender.UNKNOWN))
        assertEquals("UNKNOWN", conv.convertToDatabaseColumn(null))
    }

    @Test
    fun convertToEntityAttribute() {
        val conv = GenderConverter()
        assertEquals(Gender.MALE, conv.convertToEntityAttribute("MALE"))
        assertEquals(Gender.FEMALE, conv.convertToEntityAttribute("FEMALE"))
        assertEquals(Gender.OTHER, conv.convertToEntityAttribute("OTHER"))
        assertEquals(Gender.UNKNOWN, conv.convertToEntityAttribute("UNKNOWN"))
        assertEquals(Gender.UNKNOWN, conv.convertToEntityAttribute(null))
    }

}