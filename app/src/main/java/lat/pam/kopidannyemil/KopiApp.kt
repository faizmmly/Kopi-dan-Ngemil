package lat.pam.kopidannyemil

import android.app.Application
import lat.pam.kopidannyemil.data.UserSession

class KopiApp : Application() {
    override fun onCreate() {
        super.onCreate()
        UserSession.init(this)
    }
}