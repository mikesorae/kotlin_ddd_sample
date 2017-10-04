package net.straycalico.ecsample.domain.common

import java.io.Serializable

abstract class IdentifiedDomainObject: Serializable {
    protected var id: Long = -1;
}