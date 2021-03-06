package net.straycalico.ecsample.domain.order

import net.straycalico.ecsample.domain.common.IdentifiedValueObject
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
data class Customer(
        @Convert(converter = FullnameConverter::class)
        val name: Fullname,
        @Embedded
        @AttributeOverrides(
            AttributeOverride(name = "mail", column = Column(name = "mail")),
            AttributeOverride(name = "tel", column = Column(name = "tel"))
        )
        val contact: Contact
):IdentifiedValueObject() {
    internal constructor(): this(Fullname("", ""), Contact())
}
