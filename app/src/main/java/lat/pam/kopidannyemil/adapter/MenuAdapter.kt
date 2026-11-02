package lat.pam.kopidannyemil.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import lat.pam.kopidannyemil.databinding.ItemMenuBinding
import lat.pam.kopidannyemil.model.MenuItem
import java.text.NumberFormat
import java.util.Locale

class MenuAdapter(private val items: List<MenuItem>) :
    RecyclerView.Adapter<MenuAdapter.MenuViewHolder>() {

    class MenuViewHolder(val binding: ItemMenuBinding) : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MenuViewHolder {
        val binding = ItemMenuBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return MenuViewHolder(binding)
    }

    override fun onBindViewHolder(holder: MenuViewHolder, position: Int) {
        val item = items[position]
        holder.binding.ivMenu.setImageResource(item.imageRes)
        holder.binding.tvName.text = item.name
        holder.binding.tvDesc.text = item.description
        holder.binding.tvPrice.text = formatRupiah(item.price)
    }

    override fun getItemCount() = items.size

    private fun formatRupiah(value: Int): String {
        val formatted = NumberFormat.getInstance(Locale("id", "ID")).format(value)
        return "Rp $formatted"
    }
}