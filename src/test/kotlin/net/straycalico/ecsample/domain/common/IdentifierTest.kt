package net.straycalico.ecsample.domain.common

import org.junit.Assert.assertEquals
import org.junit.Assert.assertNotNull
import org.junit.Test

class IdentifierTest {

    class LongIdentifier(value: Long): Identifier<Long>(value)
    class StringIdentifier(value: String): Identifier<String>(value)

    @Test
    fun testCreate() {
        val id = LongIdentifier(1)
        assertEquals(id.value, 1)
    }

    @Test
    fun testEquals() {
        assert(LongIdentifier(1) == LongIdentifier(1))
        assert(StringIdentifier("foo") == StringIdentifier("foo"))
    }

    @Test
    fun testNotEquals() {
        assert(LongIdentifier(1) != LongIdentifier(2))
        assert(StringIdentifier("foo") != StringIdentifier("bar"))
    }

    @Test
    fun testHashcode() {
        val id = LongIdentifier(1)
        assertNotNull(id.hashCode())
    }

    @Test
    fun testInherit() {
        class MyId(value: Long): Identifier<Long>(value)

        val myId = MyId(100)
        assertEquals(100, myId.value)
    }

}
