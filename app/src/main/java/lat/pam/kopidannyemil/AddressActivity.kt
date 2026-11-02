package lat.pam.kopidannyemil

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import lat.pam.kopidannyemil.data.UserSession
import lat.pam.kopidannyemil.databinding.ActivityAddressBinding

class AddressActivity : AppCompatActivity() {

    private lateinit var binding: ActivityAddressBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityAddressBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.etName.setText(UserSession.fullName)

        binding.btnOrder.setOnClickListener { doOrder() }

        binding.tabHome.setOnClickListener { finish() }

        binding.tabProfile.setOnClickListener {
            startActivity(Intent(this, ProfileActivity::class.java))
            finish()
        }
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

        startActivity(Intent(this, ConfirmationActivity::class.java))
    }
}