package net.straycalico.ecsample.domain.customer

import net.straycalico.ecsample.domain.order.Fullname
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

    @Test
    fun testEquals() {
        val name1 = Fullname("taro", "yamada")
        val name2 = Fullname("taro", "yamada")
        assert(name1 == name2)
    }

    @Test
    fun testNotEquals() {
        val name1 = Fullname("taro", "yamada")
        val name2 = Fullname("tare", "yamada")
        assert(name1 != name2)
    }
}