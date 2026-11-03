package lat.pam.kopidannyemil

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.core.widget.doOnTextChanged
import androidx.recyclerview.widget.LinearLayoutManager
import lat.pam.kopidannyemil.adapter.MenuAdapter
import lat.pam.kopidannyemil.data.Cart
import lat.pam.kopidannyemil.data.DummyData
import lat.pam.kopidannyemil.data.UserSession
import lat.pam.kopidannyemil.databinding.ActivityHomeBinding

class HomeActivity : AppCompatActivity() {

    private lateinit var binding: ActivityHomeBinding
    private lateinit var adapter: MenuAdapter
    private var selectedCategory = "Semua"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityHomeBinding.inflate(layoutInflater)
        setContentView(binding.root)

        adapter = MenuAdapter(DummyData.menuList) { updateCartBar() }
        binding.rvMenu.layoutManager = LinearLayoutManager(this)
        binding.rvMenu.adapter = adapter

        binding.etSearch.doOnTextChanged { _, _, _, _ -> applyFilter() }

        binding.chipAll.setOnClickListener { selectCategory("Semua") }
        binding.chipDrink.setOnClickListener { selectCategory("Minuman") }
        binding.chipFood.setOnClickListener { selectCategory("Makanan") }

        val openOrder = View.OnClickListener {
            startActivity(Intent(this, AddressActivity::class.java))
        }
        binding.tabOrder.setOnClickListener(openOrder)
        binding.cartBar.setOnClickListener(openOrder)

        binding.tabProfile.setOnClickListener {
            startActivity(Intent(this, ProfileActivity::class.java))
        }
    }

    override fun onResume() {
        super.onResume()
        val firstName = UserSession.fullName.trim().split(" ").firstOrNull().orEmpty()
        binding.tvGreeting.text = "Halo $firstName,"
        binding.tvAvatar.text = firstName.take(1).uppercase()
        applyFilter()
        updateCartBar()
    }

    private fun selectCategory(category: String) {
        selectedCategory = category
        val chips = listOf<Pair<TextView, String>>(
            binding.chipAll to "Semua",
            binding.chipDrink to "Minuman",
            binding.chipFood to "Makanan"
        )
        for ((chip, name) in chips) {
            val selected = name == category
            chip.setBackgroundResource(
                if (selected) R.drawable.bg_chip_selected else R.drawable.bg_chip
            )
            chip.setTextColor(getColor(if (selected) R.color.white else R.color.black))
        }
        applyFilter()
    }

    private fun applyFilter() {
        adapter.filter(binding.etSearch.text.toString(), selectedCategory)
        binding.tvEmpty.visibility =
            if (adapter.itemCount == 0) View.VISIBLE else View.GONE
    }

    private fun updateCartBar() {
        val count = Cart.totalCount()
        if (count == 0) {
            binding.cartBar.visibility = View.GONE
        } else {
            binding.cartBar.visibility = View.VISIBLE
            binding.tvCartInfo.text = "$count item  •  ${Cart.formatRupiah(Cart.totalPrice())}"
        }
    }
}