package net.straycalico.ecsample.domain.order

import org.junit.Assert.*
import org.junit.Test

class GenderTest {

    @Test
    fun create() {
        val gender = Gender.valueOf("MALE")
        assert(gender == Gender.MALE)
        assert(gender.toString() == "MALE")
    }
}