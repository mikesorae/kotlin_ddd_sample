package net.straycalico.ecsample.domain.cart

import net.straycalico.ecsample.domain.common.Identifier
import net.straycalico.ecsample.domain.item.ItemId
import javax.persistence.*

@Embeddable
class CartId(
        override val value: Long?
): Identifier<Long?>(value) {
    internal constructor(): this(null)
}

@Entity
class Cart(
        @EmbeddedId
        @AttributeOverride(name = "value", column = Column(name = "cart_id"))
        val cartId: CartId
): net.straycalico.ecsample.domain.common.Entity<CartId>(cartId) {
    private constructor(): this(CartId())

    @ElementCollection
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
