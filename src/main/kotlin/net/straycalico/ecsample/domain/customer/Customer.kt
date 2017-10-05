package net.straycalico.ecsample.domain.customer

import net.straycalico.ecsample.domain.common.Identifier
import java.io.Serializable
import javax.persistence.*

@Embeddable
class CustomerId(
        @Column(name = "customer_id")
        override val value: Long?
): Identifier<Long?>(value), Serializable {
    internal constructor(): this(value = null)
}

@Embeddable
data class Contact(
        val mail: String,
        val tel: String
) {
    internal constructor(): this("", "")
}

/**
 * ECサイトの顧客エンティティ
 *
 * @param name 名前
 */
@Entity
class Customer(
        @EmbeddedId
        val customerId: CustomerId,
        val name: String,
        @Embedded
        @AttributeOverrides(
            AttributeOverride(name = "mail", column = Column(name = "mail")),
            AttributeOverride(name = "tel", column = Column(name = "tel"))
        )
        val contact: Contact
): net.straycalico.ecsample.domain.common.Entity<CustomerId>(customerId) {
    private constructor(): this(CustomerId(), "", Contact())
}
