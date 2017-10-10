package net.straycalico.ecsample.domain.common

/**
 * Entityを表すクラス
 * Id生成前でNullのケースがあるのを考慮
 */
abstract class DomainEntity<out ID : Identifier<*>>
    (protected val identifier: ID?): IdentifiedDomainObject() {

    override fun equals(other: Any?): Boolean {
        return when(other) {
            is DomainEntity<*> -> this.identifier == other.identifier
            else -> false
        }
    }

    override fun hashCode(): Int {
        return identifier?.let { it.hashCode() } ?: super.hashCode() // TODO もう少しまともに
    }

    fun identifier(): ID? = this.identifier
}
