package net.straycalico.ecsample.domain.common

import java.io.Serializable

/**
 * 代理主キーを隠蔽するためのスーパーレイヤ
 */
abstract class IdentifiedDomainObject: Serializable {
    protected var id: Long? = null
}