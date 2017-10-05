package net.straycalico.ecsample.domain.common

import java.io.Serializable
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id
import javax.persistence.MappedSuperclass

/**
 * 代理主キーを隠蔽するためのスーパーレイヤ
 */
@MappedSuperclass
abstract class IdentifiedDomainObject() {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    protected val id: Long? = null

}