package net.straycalico.ecsample.domain.customer

import net.straycalico.ecsample.domain.common.IdentifiedDomainObject
import javax.persistence.*

@Embeddable
data class Contact(
        val mail: String,
        val tel: String
) {
    internal constructor(): this("", "")
}

/**
 * ECサイトの顧客を表す値オブジェクト
 *
 * @param name 名前
 * @param contact [[Contact]]
 */
@Entity
class Customer(
        val name: String,
        @Embedded
        @AttributeOverrides(
            AttributeOverride(name = "mail", column = Column(name = "mail")),
            AttributeOverride(name = "tel", column = Column(name = "tel"))
        )
        val contact: Contact
):IdentifiedDomainObject() {
    internal constructor(): this("", Contact())
}
