package net.straycalico.ecsample.controller

import net.straycalico.ecsample.domain.customer.Contact
import net.straycalico.ecsample.domain.customer.Customer
import net.straycalico.ecsample.domain.order.Order
import net.straycalico.ecsample.domain.order.OrderId
import net.straycalico.ecsample.domain.order.OrderRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RestController
import java.util.*
import javax.validation.Valid
import javax.validation.constraints.NotNull
import javax.validation.constraints.Size

@RestController
class OrderController {
    data class OrderForm(
            @field:NotNull
            @field:Size(min = 4, max = 32)
            val name: String
    )

    @Autowired
    lateinit var repository: OrderRepository

    @GetMapping("order")
    fun getOrders() = repository.findAll()

    @PostMapping("order")
    fun createOrder(@Valid @RequestBody form: OrderForm): Order {
        val orderId = OrderId(Random().nextInt(Int.MAX_VALUE).toLong())
        val customer = Customer(form.name, Contact("dummy", "00000"))
        val order = Order(orderId, customer)
        return repository.saveAndFlush(order)
    }
}