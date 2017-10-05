package net.straycalico.ecsample.domain.cart

import net.straycalico.ecsample.domain.common.Identifier
import net.straycalico.ecsample.domain.item.ItemId
import javax.persistence.Embeddable
import javax.persistence.EmbeddedId
import javax.persistence.Entity

@Embeddable
class CartId(
        override val value: Long?
): Identifier<Long?>(value) {
    internal constructor(): this(null)
}

@Entity
class Cart(
        @EmbeddedId
        val cartId: CartId
): net.straycalico.ecsample.domain.common.Entity<CartId>(cartId) {
    private val items: MutableList<ItemId> = mutableListOf()

    fun currentItems() = this.items.toMutableList()

    fun addItem(itemId: ItemId): Unit {
        if(!this.items.contains(itemId)) {
            this.items.add(itemId)
        }
    }
    
    fun removeItem(itemId: ItemId): Unit {
        this.items.remove(itemId)
    }
}
