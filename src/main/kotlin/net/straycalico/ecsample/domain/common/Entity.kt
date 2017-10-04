package net.straycalico.ecsample.domain.common

/**
 * Entityを表すクラス
 * Id生成前でNullのケースがあるのを考慮
 */
abstract class Entity<T: Any, ID : Identifier<T>>
    (protected val identifier: Identifier<T>?) {

    override fun equals(other: Any?): Boolean {
        return when(other) {
            is Entity<*, *> -> this.identifier == other.identifier
            else -> false
        }
    }

    override fun hashCode(): Int {
        return identifier?.let { it.hashCode() } ?: super.hashCode() // TODO もう少しまともに
    }

    fun identifier(): Identifier<T>? = this.identifier
}
