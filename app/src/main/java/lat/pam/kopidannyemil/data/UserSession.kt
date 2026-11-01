package lat.pam.kopidannyemil.data

object UserSession {
    var fullName: String = ""
    var username: String = ""
    var password: String = ""

    fun isRegistered(): Boolean = username.isNotEmpty()
}