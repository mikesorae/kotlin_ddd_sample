package net.straycalico.ecsample.domain.common

/**
 * Entity識別子用クラス
 */
data class Identifier<T> (val value: T) {
    override fun equals(other: Any?): Boolean {
        return when (other) {
            is Identifier<*> -> this.value == other.value
            else -> false
        }
    }

    override fun hashCode(): Int {
        return value!!.hashCode()
    }
}