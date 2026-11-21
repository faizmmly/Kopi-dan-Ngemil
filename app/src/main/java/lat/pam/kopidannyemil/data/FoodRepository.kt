package lat.pam.kopidannyemil.data

import android.content.Context
import lat.pam.kopidannyemil.model.MenuItem

class FoodRepository(private val context: Context) {

    private val dao = AppDatabase.get(context).foodDao()

    private val seed = listOf(
        FoodEntity(name = "Kopi Susu Gula Aren", description = "Espresso, susu, gula aren", price = 22000, imageName = "kopi_susu_aren", category = "Minuman", rating = 4.8),
        FoodEntity(name = "Donat Cokelat", description = "Donat empuk, glaze cokelat", price = 12000, imageName = "donat", category = "Makanan", rating = 4.6),
        FoodEntity(name = "Sourdough Loaf", description = "Roti fermentasi alami", price = 35000, imageName = "sourdough", category = "Makanan", rating = 4.5),
        FoodEntity(name = "Cappuccino", description = "Espresso, foam susu lembut", price = 25000, imageName = "cappuccino", category = "Minuman", rating = 4.9),
        FoodEntity(name = "Matcha Latte", description = "Matcha Jepang, susu segar", price = 27000, imageName = "matcha", category = "Minuman", rating = 4.7),
        FoodEntity(name = "Caramel Macchiato", description = "Espresso, susu, sirup karamel", price = 28000, imageName = "caramel_macchiato", category = "Minuman", rating = 4.8),
        FoodEntity(name = "French Fries", description = "Kentang goreng, dengan bumbu gurih", price = 15000, imageName = "fries", category = "Makanan", rating = 4.5),
        FoodEntity(name = "Lemon Tea", description = "Teh segar dengan perasan jeruk lemon", price = 18000, imageName = "lemon_tea", category = "Minuman", rating = 4.6)
    )

    suspend fun getMenu(): List<MenuItem> {
        if (dao.count() == 0) dao.insertAll(seed)
        return dao.getAll().map { it.toMenuItem() }
    }

    private fun FoodEntity.toMenuItem(): MenuItem {
        val res = context.resources.getIdentifier(imageName, "drawable", context.packageName)
        return MenuItem(
            name = name,
            description = description,
            price = price,
            imageRes = if (res != 0) res else lat.pam.kopidannyemil.R.drawable.placeholder_food,
            category = category,
            rating = rating
        )
    }
}