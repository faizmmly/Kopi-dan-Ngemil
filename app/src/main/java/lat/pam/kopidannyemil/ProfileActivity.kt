package lat.pam.kopidannyemil

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import lat.pam.kopidannyemil.data.UserSession
import lat.pam.kopidannyemil.databinding.ActivityProfileBinding

class ProfileActivity : AppCompatActivity() {

    private lateinit var binding: ActivityProfileBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityProfileBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.tvGreeting.text = "Halo ${UserSession.fullName},"
        binding.etName.setText(UserSession.fullName)

        binding.btnSave.setOnClickListener {
            val newName = binding.etName.text.toString().trim()
            binding.tilName.error = null

            if (newName.isEmpty()) {
                binding.tilName.error = "Nama tidak boleh kosong"
                return@setOnClickListener
            }

            UserSession.fullName = newName
            binding.tvGreeting.text = "Halo $newName,"
            Toast.makeText(this, "Profil berhasil disimpan", Toast.LENGTH_SHORT).show()
        }

        binding.tabHome.setOnClickListener { finish() }

        binding.tabOrder.setOnClickListener {
            startActivity(Intent(this, AddressActivity::class.java))
        }
    }
}