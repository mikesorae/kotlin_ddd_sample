package net.straycalico.ecsample.domain.order

import org.springframework.data.jpa.repository.JpaRepository

interface OrderRepository : JpaRepository<Order, Long> {
    fun findOneByOrderId(orderId: OrderId): Order
}