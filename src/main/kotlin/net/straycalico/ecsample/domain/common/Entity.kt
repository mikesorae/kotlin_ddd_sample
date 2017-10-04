package net.straycalico.ecsample.domain.common

/**
 * Entityを表すクラス
 */
class Entity<ID : Identifier<*>> (val id: Identifier<ID>) {
    override fun hashCode(): Int {
        return id.hashCode()
    }
}
