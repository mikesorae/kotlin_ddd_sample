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
}