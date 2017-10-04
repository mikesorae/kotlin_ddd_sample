package net.straycalico.ecsample.domain.common

/**
 * Entity識別子用クラス
 */
abstract class Identifier<out T> (open val value: T) {
    override fun equals(other: Any?): Boolean {
        return when (other) {
            is Identifier<*> -> this.value == other.value
            else -> false
        }
    }

    override fun hashCode(): Int {
        return value?.let { it!!.hashCode() } ?: -1
    }
}