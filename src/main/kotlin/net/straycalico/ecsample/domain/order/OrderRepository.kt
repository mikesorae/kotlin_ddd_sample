package net.straycalico.ecsample.domain.order

import net.straycalico.ecsample.domain.customer.Customer
import org.springframework.data.jpa.repository.JpaRepository
import javax.transaction.Transactional

interface OrderRepository : JpaRepository<Order, Long> {
    fun findOneByOrderId(orderId: OrderId): Order
}