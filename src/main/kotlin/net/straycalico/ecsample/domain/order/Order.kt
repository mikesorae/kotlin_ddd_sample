package net.straycalico.ecsample.domain.order

import net.straycalico.ecsample.domain.common.Identifier
import javax.persistence.*

@Embeddable
class OrderId(
        override val value: Long?
): Identifier<Long?>(value) {
    internal constructor(): this(value = null)
}

@Table(name = "`order`") // orderが予約語なので自動生成クエリだとこける
@Entity
class Order(
        @EmbeddedId
        @AttributeOverride(name = "value", column = Column(name = "order_id"))
        val orderId: OrderId,
        @OneToOne(cascade = arrayOf(CascadeType.ALL))
        @JoinColumn(name = "customer_id")
        val customer: Customer
): net.straycalico.ecsample.domain.common.DomainEntity<OrderId>(orderId) {
    internal constructor(): this(OrderId(), Customer())
}
