package net.straycalico.ecsample.domain.cart

import net.straycalico.ecsample.domain.common.DomainEntity
import net.straycalico.ecsample.domain.common.Identifier
import net.straycalico.ecsample.domain.item.ItemId
import java.util.*
import javax.persistence.*

private fun generateId() = UUID.randomUUID().toString()

@Embeddable
class CartId private constructor(
        override val value: String?
): Identifier<String?>(value) {
    constructor(): this(generateId())
}

@Entity
class Cart private constructor(
        @Embedded
        @AttributeOverride(name = "value", column = Column(name = "cart_id"))
        val cartId: CartId
): DomainEntity<CartId>(cartId) {
    constructor(): this(CartId())

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
