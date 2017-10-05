package net.straycalico.ecsample.domain.customer

import javax.persistence.AttributeConverter

class FullnameConverter: AttributeConverter<Fullname, String> {
    override fun convertToDatabaseColumn(attribute: Fullname?): String {
        return attribute?.toString() ?: ""
    }

    override fun convertToEntityAttribute(dbData: String?): Fullname {
        if (dbData is String && dbData.contains(' ')) {
            val names = dbData.split(' ')
            return Fullname(names[0], names[1])
        }
        return Fullname("", "")
    }
}

data class Fullname(
        val first: String,
        val last: String
) {
    override fun toString(): String {
        return "$first $last"
    }

    override fun equals(other: Any?): Boolean {
        return when(other) {
            is Fullname -> this.toString() == other.toString()
            else -> false
        }
    }
}
