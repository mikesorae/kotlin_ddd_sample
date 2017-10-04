package net.straycalico.ecsample.domain.common

import org.junit.Assert.assertEquals
import org.junit.Assert.assertNotNull
import org.junit.Test

class IdentifierTest {

    @Test
    fun testCreate() {
        val id = Identifier(1)
        assertEquals(id.value, 1)
    }

    @Test
    fun testEquals() {
        assert(Identifier(1) == Identifier(1))
        assert(Identifier("foo") == Identifier("foo"))
    }

    @Test
    fun testNotEquals() {
        assert(Identifier(1) != Identifier(2))
        assert(Identifier("foo") != Identifier("bar"))
    }

    @Test
    fun testHashcode() {
        val id = Identifier(1)
        assertNotNull(id.hashCode())
    }

}
