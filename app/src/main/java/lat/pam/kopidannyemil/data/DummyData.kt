package lat.pam.kopidannyemil.data

import lat.pam.kopidannyemil.R
import lat.pam.kopidannyemil.model.MenuItem

object DummyData {
    val menuList = listOf(
        MenuItem("Kopi Susu Gula Aren", "Espresso, susu, gula aren", 22000, R.drawable.placeholder_food),
        MenuItem("Donat Cokelat", "Donat empuk, glaze cokelat", 12000, R.drawable.placeholder_food),
        MenuItem("Sourdough Loaf", "Roti fermentasi alami", 35000, R.drawable.placeholder_food),
        MenuItem("Cappuccino", "Espresso, foam susu lembut", 25000, R.drawable.placeholder_food),
        MenuItem("Matcha Latte", "Matcha Jepang, susu segar", 27000, R.drawable.placeholder_food)
    )
}