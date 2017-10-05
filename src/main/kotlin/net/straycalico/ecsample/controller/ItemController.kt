package net.straycalico.ecsample.controller

import net.straycalico.ecsample.domain.item.Item
import net.straycalico.ecsample.domain.item.ItemRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController

@RestController
class ItemController {
    @Autowired
    lateinit var repository: ItemRepository

    @GetMapping("/items")
    fun getItems() = repository.findAll()
}