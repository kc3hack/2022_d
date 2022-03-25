package dev.postnotifier.domain.user

class UserEmail(private val value: String) {
    fun checkValue(): Boolean {
        return value.matches(
            Regex("""^[a-zA-Z0-9_+-]+(.[a-zA-Z0-9_+-]+)*@([a-zA-Z0-9][a-zA-Z0-9-]*[a-zA-Z0-9]*\.)+[a-zA-Z]{2,}${'$'}""")
        )
    }

    fun getValue(): String {
        return value
    }
}
