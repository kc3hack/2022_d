package dev.postnotifier.exception

enum class ErrorCode(val message: String, val errorStatus: Int) {
    NOT_FOUND_AUTH_PARAMETER("Password and email address are required.", 1400),

    DUPLICATION_EMAIL("This email address is already in use.", 2400),

    INVALID_EMAIL("The format of the e-mail address is invalid.", 3400),

    INVALID_PASSWORD(
        "Passwords must be at least 8 and no more than 24 characters long and contain uppercase letters and symbols (period (.)). slash (/), question mark (?) and hyphen (-)).",
        4400
    ),

    MISMATCH_CURRENT_PASSWORD("Enter your current password.", 5400),

    INVALID_NAME("User names should be limited to 64 characters.", 6400),

    MISMATCH_PASSWORD("Password is incorrect.", 1401),

    NOT_FOUND_USER("We are Unable to find a user with this email address.", 2401),

    NOT_FOUND_DATA("This data is not found.", 1404),

    UNKNOWN_ERROR("Unknown error occurred.", 1503),

    DATA_ACCESS_ERROR("Data access failed.", 2503)
}
