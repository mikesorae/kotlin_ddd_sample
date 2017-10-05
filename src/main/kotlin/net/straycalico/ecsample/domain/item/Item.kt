package net.straycalico.ecsample.domain.item

import net.straycalico.ecsample.domain.common.Identifier
import javax.persistence.*

@Embeddable
class ItemId(
        override val value: Long?
): Identifier<Long?>(value) {
    internal constructor(): this(value = null)
}

@Entity
class Item(
        @EmbeddedId
        @AttributeOverride(name = "value", column = Column(name = "item_id"))
        val itemId: ItemId,
        val price: Long
): net.straycalico.ecsample.domain.common.Entity<ItemId>(itemId) {
    internal constructor(): this(ItemId(), 0)
}
