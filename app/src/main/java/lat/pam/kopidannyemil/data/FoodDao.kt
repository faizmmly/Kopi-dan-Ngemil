package lat.pam.kopidannyemil.data

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update

@Dao
interface FoodDao {
    @Query("SELECT * FROM foods ORDER BY id ASC")
    suspend fun getAll(): List<FoodEntity>

    @Query("SELECT COUNT(*) FROM foods")
    suspend fun count(): Int

    @Insert
    suspend fun insert(food: FoodEntity)

    @Insert
    suspend fun insertAll(foods: List<FoodEntity>)

    @Update
    suspend fun update(food: FoodEntity)

    @Delete
    suspend fun delete(food: FoodEntity)
}