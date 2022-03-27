package dev.postnotifier.domain.user

class UserPoint(
    val value: Int
) {
    fun checkValue(): Boolean {
        return value >= 0
    }
}
