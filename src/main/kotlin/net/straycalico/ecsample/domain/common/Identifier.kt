package net.straycalico.ecsample.domain.common

import java.io.Serializable

/**
 * Entity識別子用クラス
 */
abstract class Identifier<out T: Any> (open val value: T): Serializable {
    override fun equals(other: Any?): Boolean {
        return when (other) {
            is Identifier<*> -> this.value == other.value
            else -> false
        }
    }

    override fun hashCode(): Int {
        return value.hashCode()
    }
}