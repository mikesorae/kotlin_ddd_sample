package net.straycalico.ecsample.domain.customer

data class Fullname(
        val first: String,
        val last: String
) {
    override fun toString(): String {
        return "$first $last"
    }
}
