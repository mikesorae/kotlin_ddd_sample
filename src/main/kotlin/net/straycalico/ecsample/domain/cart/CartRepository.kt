package net.straycalico.ecsample.domain.cart

import org.springframework.data.jpa.repository.JpaRepository

interface CartRepository : JpaRepository<Cart, Long> {
    fun findOneByCartId(cartId: CartId): Cart?
}