package lat.pam.kopidannyemil.data

import lat.pam.kopidannyemil.R
import lat.pam.kopidannyemil.model.MenuItem

object DummyData {
    val menuList = listOf(
        MenuItem("Kopi Susu Gula Aren", "Espresso, susu, gula aren", 22000, R.drawable.kopi_susu_aren, "Minuman", 4.8),
        MenuItem("Donat Cokelat", "Donat empuk, glaze cokelat", 12000, R.drawable.donat, "Makanan", 4.6),
        MenuItem("Sourdough Loaf", "Roti fermentasi alami", 35000, R.drawable.sourdough, "Makanan", 4.5),
        MenuItem("Cappuccino", "Espresso, foam susu lembut", 25000, R.drawable.cappuccino, "Minuman", 4.9),
        MenuItem("Matcha Latte", "Matcha Jepang, susu segar", 27000, R.drawable.matcha, "Minuman", 4.7),
        MenuItem("Caramel Macchiato", "Espresso, susu, sirup karamel", 28000, R.drawable.caramel_macchiato, "Minuman", 4.8),
        MenuItem("French Fries", "Kentang goreng, dengan bumbu gurih", 15000, R.drawable.fries, "Makanan", 4.5),
        MenuItem("Lemon Tea", "Teh segar dengan perasan jeruk lemon", 18000, R.drawable.lemon_tea, "Minuman", 4.6),
    )
}