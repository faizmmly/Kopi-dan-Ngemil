package lat.pam.kopidannyemil.model

data class MenuItem(
    val name: String,
    val description: String,
    val price: Int,
    val imageRes: Int,
    val category: String,
    val rating: Double = 4.7
)