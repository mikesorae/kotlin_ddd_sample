package net.straycalico.ecsample.domain.common

/**
 * Entityを表すクラス
 */
class Entity<T: Any, ID : Identifier<T>> (val id: Identifier<T>) {
    fun equals(other: Entity<T, Identifier<T>>): Boolean {
        return when (other) {
            is Entity<T, Identifier<T>> -> this.id == other.id
            else -> false
        }
    }

    override fun hashCode(): Int {
        return id.hashCode()
    }
}
