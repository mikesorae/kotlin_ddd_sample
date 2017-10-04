package net.straycalico.ecsample.domain.common

import org.junit.Assert.*
import org.junit.Test

class EntityTest {
    @Test
    fun testCreate() {
        val id = Identifier(1)
        val entity = Entity(id)
        assertEquals(1, entity.id.value)
    }

    @Test
    fun testEquals() {
        val id = Identifier(1)
        assert(Entity(id).equals(Entity(id)))
    }

    @Test
    fun testInherit() {
        class MyId(value: String): Identifier<String>(value)
        class MyEntity(id: MyId): Entity<String, MyId>(id)

        val id = MyId("id-001")
        val entity = MyEntity(id)

        assertEquals("id-001", entity.id.value)
    }
}