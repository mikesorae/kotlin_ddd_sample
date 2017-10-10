package net.straycalico.ecsample.controller

import net.straycalico.ecsample.domain.cart.CartId
import net.straycalico.ecsample.domain.order.*
import org.hibernate.validator.constraints.Email
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
            val cartId: String,
            @field:Size(min = 4, max = 32)
            val firstName: String,
            @field:Size(min = 4, max = 32)
            val secondName: String,
            @field:Email
            val mail: String,
            val tel: String
    )

    @Autowired
    private lateinit var repository: OrderRepository

    @Autowired
    private lateinit var service: OrderService

    @GetMapping("/orders")
    fun getOrders() = repository.findAll()

    @PostMapping("/orders")
    fun createOrder(@Valid @RequestBody form: OrderForm): Order {
        val customer = Customer(Fullname(form.firstName, form.secondName), Contact(form.mail, form.tel))
        val order = service.createOrder(CartId(form.cartId), customer)
        return order
    }
}