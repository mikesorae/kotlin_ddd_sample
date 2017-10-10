package net.straycalico.ecsample.domain.order

import javassist.NotFoundException
import net.straycalico.ecsample.domain.cart.Cart
import net.straycalico.ecsample.domain.cart.CartId
import net.straycalico.ecsample.domain.cart.CartRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import java.util.*

/**
 * 注文サービス
 */
@Service
class OrderService {
    @Autowired
    private lateinit var cartRepository: CartRepository

    @Autowired
    private lateinit var orderRepository: OrderRepository

    // 顧客情報を受け取り、カート内の商品を発注する
    fun createOrder(cartId: CartId, customer: Customer): Order {
        val cart: Cart = cartRepository.findOneByCartId(cartId) ?: throw NotFoundException("cart not found")

        val items = cart.currentItems()
        val orderId = generateOrderId()
        val order = Order(orderId, customer, items)

        return orderRepository.save(order)
    }

    private fun generateOrderId() = OrderId(UUID.randomUUID().toString())
}