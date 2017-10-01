package net.straycalico.ecsample.domain.customer

import java.io.Serializable
import javax.persistence.*

@Entity
class Customer(
        @EmbeddedId val custmerId: CustomerId? = CustomerId(),
        val name: String
)
{
    // @Embeddableと@GeneratedValueは同時に設定できないため、Schema側でAutoIncrementしておく必要がある
    @Embeddable
    data class CustomerId(
            val id: Long? = null
    ): Serializable
}