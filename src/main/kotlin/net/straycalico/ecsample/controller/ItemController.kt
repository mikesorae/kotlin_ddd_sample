package net.straycalico.ecsample.controller

import net.straycalico.ecsample.domain.item.Item
import net.straycalico.ecsample.domain.item.ItemId
import net.straycalico.ecsample.domain.item.ItemRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RestController
import java.util.*
import javax.validation.Valid
import javax.validation.constraints.Min
import javax.validation.constraints.NotNull
import javax.validation.constraints.Size

@RestController
class ItemController {
    data class ItemForm(
            @field:NotNull
            @field:Size(min = 4, max = 32)
            val name: String,
            @field:NotNull
            val price: Long
    )

    @Autowired
    lateinit var repository: ItemRepository

    @GetMapping("/items")
    fun getItems() = repository.findAll()

    @PostMapping("/items")
    fun createItem(@Valid @RequestBody form: ItemForm): Item {
        val itemId = ItemId(UUID.randomUUID().toString())
        val item =  Item(itemId, form.name, form.price)

        return repository.save(item)
    }
}