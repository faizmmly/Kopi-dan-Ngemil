package lat.pam.kopidannyemil

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import lat.pam.kopidannyemil.data.Cart
import lat.pam.kopidannyemil.data.LastOrder
import lat.pam.kopidannyemil.data.UserSession
import lat.pam.kopidannyemil.databinding.ActivityAddressBinding
import lat.pam.kopidannyemil.databinding.ItemOrderRowBinding

class AddressActivity : AppCompatActivity() {

    private lateinit var binding: ActivityAddressBinding
    private val shippingFee = 5000

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityAddressBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.etName.setText(UserSession.fullName)
        renderSummary()

        binding.btnOrder.setOnClickListener {
            if (Cart.totalCount() == 0) finish() else doOrder()
        }

        binding.tabHome.setOnClickListener { finish() }
        binding.tabProfile.setOnClickListener {
            startActivity(Intent(this, ProfileActivity::class.java))
            finish()
        }
    }

    private fun renderSummary() {
        val entries = Cart.entries()
        val empty = entries.isEmpty()

        binding.cardEmpty.visibility = if (empty) View.VISIBLE else View.GONE
        binding.layoutContent.visibility = if (empty) View.GONE else View.VISIBLE
        binding.btnOrder.text = if (empty) "Pilih menu dulu" else "Order dan Kirim"

        binding.llItems.removeAllViews()
        for ((item, qty) in entries) {
            val row = ItemOrderRowBinding.inflate(layoutInflater, binding.llItems, false)
            row.tvRowName.text = item.name
            row.tvRowPrice.text = Cart.formatRupiah(item.price * qty)
            row.tvRowQty.text = qty.toString()
            row.btnRowPlus.setOnClickListener {
                Cart.add(item)
                renderSummary()
            }
            row.btnRowMinus.setOnClickListener {
                Cart.remove(item)
                renderSummary()
            }
            binding.llItems.addView(row.root)
        }

        val subtotal = Cart.totalPrice()
        binding.tvSubtotal.text = Cart.formatRupiah(subtotal)
        binding.tvShipping.text = Cart.formatRupiah(shippingFee)
        binding.tvTotal.text = Cart.formatRupiah(subtotal + shippingFee)
    }

    private fun doOrder() {
        val name = binding.etName.text.toString().trim()
        val address = binding.etAddress.text.toString().trim()
        val detail = binding.etDetail.text.toString().trim()

        binding.tilName.error = null
        binding.tilAddress.error = null
        binding.tilDetail.error = null

        if (name.isEmpty()) {
            binding.tilName.error = "Nama lengkap tidak boleh kosong"
            return
        }
        if (address.isEmpty()) {
            binding.tilAddress.error = "Alamat tidak boleh kosong"
            return
        }
        if (detail.isEmpty()) {
            binding.tilDetail.error = "Patokan atau detail tidak boleh kosong"
            return
        }

        LastOrder.number = "KN-" + (10000 + (System.currentTimeMillis() % 90000)).toString()
        LastOrder.total = Cart.totalPrice() + shippingFee
        LastOrder.address = "$address ($detail)"
        LastOrder.payment = when (binding.rgPayment.checkedRadioButtonId) {
            R.id.rbQris -> "QRIS"
            R.id.rbTransfer -> "Transfer bank"
            else -> "Bayar di tempat (COD)"
        }

        startActivity(Intent(this, ConfirmationActivity::class.java))
    }
}