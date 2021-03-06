package net.straycalico.ecsample.domain.item

import net.straycalico.ecsample.domain.common.DomainEntity
import net.straycalico.ecsample.domain.common.Identifier
import javax.persistence.*

@Embeddable
data class ItemId(
        override val value: String
): Identifier<String>(value) {
    internal constructor(): this(value = "")
}

@Entity
class Item(
        @Embedded
        @AttributeOverride(name = "value", column = Column(name = "item_id"))
        val itemId: ItemId,
        val name: String,
        val price: Long
): DomainEntity<ItemId>(itemId) {
    internal constructor(): this(ItemId(), "", 0)
}
