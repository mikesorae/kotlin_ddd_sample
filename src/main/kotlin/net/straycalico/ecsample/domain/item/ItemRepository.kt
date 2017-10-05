package net.straycalico.ecsample.domain.item

import org.springframework.data.jpa.repository.JpaRepository

interface ItemRepository: JpaRepository<Item, Long>
