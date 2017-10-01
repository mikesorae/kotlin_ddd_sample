package net.straycalico.ecsample.controller

import net.straycalico.ecsample.domain.customer.Customer
import net.straycalico.ecsample.domain.customer.CustomerRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RestController

@RestController
class HomeController {
    @Autowired
    lateinit var repository: CustomerRepository

    @GetMapping("")
    fun index(): String {
        return "hello"
    }

    @GetMapping("customer")
    fun getCustomers() = repository.findAll()

    @PostMapping("customer")
    fun createCustomers() {
        val customer = Customer(name = "hoge")
        repository.save(customer)
    }
}