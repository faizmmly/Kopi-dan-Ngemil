package lat.pam.kopidannyemil.data

import lat.pam.kopidannyemil.R
import lat.pam.kopidannyemil.model.MenuItem

object DummyData {
    val menuList = listOf(
        MenuItem("Kopi Susu Gula Aren", "Espresso, susu, gula aren", 22000, R.drawable.kopi_susu_aren),
        MenuItem("Donat Cokelat", "Donat empuk, glaze cokelat", 12000, R.drawable.donat),
        MenuItem("Sourdough Loaf", "Roti fermentasi alami", 35000, R.drawable.sourdough),
        MenuItem("Cappuccino", "Espresso, foam susu lembut", 25000, R.drawable.cappuccino),
        MenuItem("Matcha Latte", "Matcha Jepang, susu segar", 27000, R.drawable.matcha)
    )
}