package lat.pam.kopidannyemil.data

import android.content.Context
import android.content.SharedPreferences

object UserSession {

    private const val PREF_NAME = "kopi_nyemil_pref"
    private lateinit var prefs: SharedPreferences

    fun init(context: Context) {
        if (!::prefs.isInitialized) {
            prefs = context.applicationContext
                .getSharedPreferences(PREF_NAME, Context.MODE_PRIVATE)
        }
    }

    var fullName: String
        get() = prefs.getString("fullName", "") ?: ""
        set(value) = prefs.edit().putString("fullName", value).apply()

    var username: String
        get() = prefs.getString("username", "") ?: ""
        set(value) = prefs.edit().putString("username", value).apply()

    var password: String
        get() = prefs.getString("password", "") ?: ""
        set(value) = prefs.edit().putString("password", value).apply()

    fun isRegistered(): Boolean = username.isNotEmpty()

    var isLoggedIn: Boolean
        get() = prefs.getBoolean("loggedIn", false)
        set(value) = prefs.edit().putBoolean("loggedIn", value).apply()

    fun logout() {
        prefs.edit().putBoolean("loggedIn", false).apply()
        // Jika ingin menghapus semua data sesi termasuk username/password, gunakan:
        // prefs.edit().clear().apply()
    }
}