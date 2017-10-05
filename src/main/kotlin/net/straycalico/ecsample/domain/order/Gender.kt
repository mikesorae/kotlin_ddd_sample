package net.straycalico.ecsample.domain.order

import javax.persistence.AttributeConverter

class GenderConverter: AttributeConverter<Gender, String> {
    override fun convertToDatabaseColumn(attribute: Gender?): String {
        return attribute?.toString() ?: "UNKNOWN"
    }

    override fun convertToEntityAttribute(dbData: String?): Gender {
        return dbData?.let { Gender.valueOf(it) } ?: Gender.UNKNOWN
    }
}

enum class Gender {
    MALE, FEMALE, OTHER, UNKNOWN
}