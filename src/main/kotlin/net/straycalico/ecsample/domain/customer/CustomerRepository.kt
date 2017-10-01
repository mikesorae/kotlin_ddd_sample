package net.straycalico.ecsample.domain.customer

import org.springframework.data.jpa.repository.JpaRepository
import javax.transaction.Transactional

@Transactional(Transactional.TxType.MANDATORY)
interface CustomerRepository: JpaRepository<Customer, Long> {
}
