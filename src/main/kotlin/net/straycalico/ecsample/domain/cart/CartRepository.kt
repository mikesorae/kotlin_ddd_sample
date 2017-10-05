package net.straycalico.ecsample.domain.cart

import net.straycalico.ecsample.domain.item.Item
import org.springframework.data.jpa.repository.JpaRepository

interface CartRepository : JpaRepository<Cart, Long>