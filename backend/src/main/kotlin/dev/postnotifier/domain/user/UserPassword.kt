package dev.postnotifier.domain.user

class UserPassword(private var value: String) {
    fun checkValue(): Boolean {
        return value.matches(Regex("""^(?=.*[A-Z])(?=.*[.?/-])[a-zA-Z0-9.?/-]{8,24}${'$'}"""))
    }

    fun getValue(): String {
        return value
    }

    fun setValue(encodedPassword: String) {
        value = encodedPassword
    }
}
