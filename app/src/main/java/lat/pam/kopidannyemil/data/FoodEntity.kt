package lat.pam.kopidannyemil.data

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "foods")
data class FoodEntity(
    @PrimaryKey(autoGenerate = true) val id: Int = 0,
    val name: String,
    val description: String,
    val price: Int,
    val imageName: String,
    val category: String,
    val rating: Double
)