package dev.postnotifier.domain.user

class UserName(
    val value: String
) {
    fun checkValue(): Boolean {
        return value.length <= 64
    }
}
