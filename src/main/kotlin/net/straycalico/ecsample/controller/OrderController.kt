package net.straycalico.ecsample.controller

import net.straycalico.ecsample.domain.order.Contact
import net.straycalico.ecsample.domain.order.Customer
import net.straycalico.ecsample.domain.order.Fullname
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
import javax.validation.constraints.Size

@RestController
class OrderController {
    data class OrderForm(
            @field:Size(min = 4, max = 32)
            val firstName: String,
            @field:Size(min = 4, max = 32)
            val secondName: String
    )

    @Autowired
    lateinit var repository: OrderRepository

    @GetMapping("/orders")
    fun getOrders() = repository.findAll()

    @PostMapping("/orders")
    fun createOrder(@Valid @RequestBody form: OrderForm): Order {
        val orderId = OrderId(Random().nextInt(Int.MAX_VALUE).toLong())
        val customer = Customer(Fullname(form.firstName, form.secondName), Contact("dummy", "00000"))
        val order = Order(orderId, customer)
        return repository.saveAndFlush(order)
    }
}