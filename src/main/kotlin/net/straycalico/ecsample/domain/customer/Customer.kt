package net.straycalico.ecsample.domain.customer

import net.straycalico.ecsample.domain.common.Identifier
import java.io.Serializable
import javax.persistence.*

@Embeddable
class CustomerId(
        @GeneratedValue(strategy = GenerationType.AUTO)
        @Column(name = "id")
        override val value: Long?
): Identifier<Long?>(value), Serializable {
    internal constructor(): this(value = null)
}

/**
 * ECサイトの顧客エンティティ
 *
 * @param name 名前
 */
@Entity
class Customer(
        @EmbeddedId
        val customerId: CustomerId? = CustomerId(),
        val name: String? = null
): net.straycalico.ecsample.domain.common.Entity<CustomerId>(customerId)
{
    // @Embeddableと@GeneratedValueは同時設定できないため、Schema側でAutoIncrementしておく必要がある
    // またはID発行専用のサービスを作成する
}