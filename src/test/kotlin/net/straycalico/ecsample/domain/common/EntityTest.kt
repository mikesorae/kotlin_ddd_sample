package net.straycalico.ecsample.domain.common

import org.junit.Assert.*
import org.junit.Test

class EntityTest {
    class MyId(value: String): Identifier<String>(value)
    class MyEntity(id: MyId): Entity<String, MyId>(id)

    @Test
    fun testCreate() {
        val id = MyId("test")
        val entity = MyEntity(id)
        assertEquals("test", entity.identifier()!!.value)
    }

    @Test
    fun testEquals() {
        val id = MyId("test")
        assert(MyEntity(id) == MyEntity(id))
    }

    @Test
    fun testInherit() {
        val id = MyId("id-001")
        val entity = MyEntity(id)

        assertEquals("id-001", entity.identifier()!!.value)
    }
}