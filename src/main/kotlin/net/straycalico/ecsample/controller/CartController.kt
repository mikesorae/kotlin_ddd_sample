package net.straycalico.ecsample.controller

import net.straycalico.ecsample.domain.cart.*
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RestController
import java.util.*
import javax.validation.Valid

@RestController
class CartController {
    data class CartForm(
            val id: Long
    )

    @Autowired
    lateinit var repository: CartRepository

    @GetMapping("/carts")
    fun getCarts() = repository.findAll()

    @PostMapping("/carts")
    fun createCart(@Valid @RequestBody form: CartForm): Cart {
        val cartId = CartId(form.id)
        val cart = Cart(cartId)
        return repository.saveAndFlush(cart)
    }
}