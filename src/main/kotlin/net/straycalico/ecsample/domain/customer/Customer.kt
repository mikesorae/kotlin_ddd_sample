package net.straycalico.ecsample.domain.customer

import java.io.Serializable
import javax.persistence.*

/**
 * ECサイトの顧客エンティティ
 *
 * @param name 名前
 */
@Entity
class Customer(
        @EmbeddedId val custmerId: CustomerId? = CustomerId(),
        val name: String
)
{
    // @Embeddableと@GeneratedValueは同時設定できないため、Schema側でAutoIncrementしておく必要がある
    // またはID発行専用のサービスを作成する
    @Embeddable
    data class CustomerId(
            // TODO repository.save()時にidが受け取れない問題の修正
            // @GeneratedValue(strategy = GenerationType.IDENTITY)
            val id: Long? = null
    ): Serializable
}