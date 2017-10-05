package net.straycalico.ecsample.domain.order

import net.straycalico.ecsample.domain.customer.Customer
import org.springframework.data.jpa.repository.JpaRepository
import javax.transaction.Transactional

@Transactional(Transactional.TxType.MANDATORY)
interface OrderRepository : JpaRepository<Order, Long> {
}