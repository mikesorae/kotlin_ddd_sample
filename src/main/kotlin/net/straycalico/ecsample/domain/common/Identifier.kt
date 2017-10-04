package net.straycalico.ecsample.domain.common

/**
 * Entity識別子用クラス
 */
open class Identifier<T: Any> (val value: T) { // nullで初期化させないためにAnyを指定
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