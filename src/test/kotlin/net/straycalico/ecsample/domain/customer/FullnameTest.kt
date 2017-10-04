package net.straycalico.ecsample.domain.customer

import org.junit.Assert.*
import org.junit.Test

class FullnameTest {
    @Test
    fun testCreate() {
        val name = Fullname("first", "last")
        assertEquals("first", name.first)
        assertEquals("last", name.last)
        assertEquals("first last", name.toString())
    }
}