package lat.pam.kopidannyemil.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import lat.pam.kopidannyemil.data.Cart
import lat.pam.kopidannyemil.databinding.ItemMenuBinding
import lat.pam.kopidannyemil.model.MenuItem

class MenuAdapter(
    private val allItems: List<MenuItem>,
    private val onCartChanged: () -> Unit
) : RecyclerView.Adapter<MenuAdapter.MenuViewHolder>() {

    private var shown: List<MenuItem> = allItems

    class MenuViewHolder(val binding: ItemMenuBinding) : RecyclerView.ViewHolder(binding.root)

    fun filter(query: String, category: String) {
        shown = allItems.filter {
            (category == "Semua" || it.category == category) &&
                    it.name.contains(query.trim(), ignoreCase = true)
        }
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MenuViewHolder {
        val binding = ItemMenuBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return MenuViewHolder(binding)
    }

    override fun onBindViewHolder(holder: MenuViewHolder, position: Int) {
        val item = shown[position]
        val b = holder.binding
        val qty = Cart.qty(item)

        b.ivMenu.setImageResource(item.imageRes)
        b.tvName.text = item.name
        b.tvDesc.text = item.description
        b.tvRating.text = "★ ${item.rating}"
        b.tvPrice.text = Cart.formatRupiah(item.price)

        b.btnAdd.visibility = if (qty == 0) View.VISIBLE else View.GONE
        b.layoutQty.visibility = if (qty == 0) View.GONE else View.VISIBLE
        b.tvQty.text = qty.toString()

        val addAction = View.OnClickListener {
            Cart.add(item)
            notifyItemChanged(holder.bindingAdapterPosition)
            onCartChanged()
        }
        b.btnAdd.setOnClickListener(addAction)
        b.btnPlus.setOnClickListener(addAction)
        b.btnMinus.setOnClickListener {
            Cart.remove(item)
            notifyItemChanged(holder.bindingAdapterPosition)
            onCartChanged()
        }
    }

    override fun getItemCount() = shown.size
}