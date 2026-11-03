package lat.pam.kopidannyemil.data

import lat.pam.kopidannyemil.model.MenuItem
import java.text.NumberFormat
import java.util.Locale

object Cart {
    private val items = LinkedHashMap<MenuItem, Int>()

    fun add(item: MenuItem) {
        items[item] = (items[item] ?: 0) + 1
    }

    fun remove(item: MenuItem) {
        val q = (items[item] ?: 0) - 1
        if (q <= 0) items.remove(item) else items[item] = q
    }

    fun qty(item: MenuItem): Int = items[item] ?: 0

    fun totalCount(): Int = items.values.sum()

    fun totalPrice(): Int = items.entries.sumOf { it.key.price * it.value }

    fun entries(): List<Pair<MenuItem, Int>> = items.entries.map { it.key to it.value }

    fun clear() = items.clear()

    fun formatRupiah(value: Int): String =
        "Rp " + NumberFormat.getInstance(Locale("id", "ID")).format(value)
}