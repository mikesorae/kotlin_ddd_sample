package net.straycalico.ecsample.domain.order

import net.straycalico.ecsample.domain.common.DomainEntity
import net.straycalico.ecsample.domain.common.Identifier
import net.straycalico.ecsample.domain.item.ItemId
import javax.persistence.*

@Embeddable
data class OrderId(
        override val value: String
): Identifier<String>(value) {
    internal constructor(): this(value = "")
}

@Table(name = "`order`") // orderが予約語なので自動生成クエリだとこける
@Entity
class Order(
        @Embedded
        @AttributeOverride(name = "value", column = Column(name = "order_id"))
        val orderId: OrderId,
        @OneToOne(cascade = arrayOf(CascadeType.ALL))
        @JoinColumn(name = "customer_id")
        val customer: Customer,
        @ElementCollection
        val items: List<ItemId>
): DomainEntity<OrderId>(orderId) {
    internal constructor(): this(OrderId(), Customer(), listOf())
}
