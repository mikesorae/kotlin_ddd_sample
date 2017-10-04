package net.straycalico.ecsample.controller

import net.straycalico.ecsample.domain.customer.Customer
import net.straycalico.ecsample.domain.customer.CustomerId
import net.straycalico.ecsample.domain.customer.CustomerRepository
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
class CustomerController {
    data class CustomerForm(
            @field:NotNull
            @field:Size(min = 4, max = 32)
            val name: String
    )

    @Autowired
    lateinit var repository: CustomerRepository

    @GetMapping("customer")
    fun getCustomers() = repository.findAll()

    @PostMapping("customer")
    fun createCustomers(@Valid @RequestBody form: CustomerForm): Customer {
        val customerId = CustomerId(123)
        val customer = Customer(customerId, form.name)
        return repository.saveAndFlush(customer)
    }
}