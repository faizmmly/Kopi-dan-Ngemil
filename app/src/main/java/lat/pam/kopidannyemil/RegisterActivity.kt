package lat.pam.kopidannyemil

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import lat.pam.kopidannyemil.data.UserSession
import lat.pam.kopidannyemil.databinding.ActivityRegisterBinding

class RegisterActivity : AppCompatActivity() {

    private lateinit var binding: ActivityRegisterBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityRegisterBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnRegister.setOnClickListener { doRegister() }

        binding.tvGoLogin.setOnClickListener {
            startActivity(Intent(this, LoginActivity::class.java))
        }
    }

    private fun doRegister() {
        val fullName = binding.etFullName.text.toString().trim()
        val username = binding.etUsername.text.toString().trim()
        val password = binding.etPassword.text.toString()
        val confirm = binding.etConfirm.text.toString()

        binding.tilFullName.error = null
        binding.tilUsername.error = null
        binding.tilPassword.error = null
        binding.tilConfirm.error = null

        if (fullName.isEmpty()) {
            binding.tilFullName.error = "Nama lengkap tidak boleh kosong"
            return
        }
        if (username.isEmpty()) {
            binding.tilUsername.error = "Username tidak boleh kosong"
            return
        }
        if (password.length < 6) {
            binding.tilPassword.error = "Password minimal 6 karakter"
            return
        }
        if (confirm != password) {
            binding.tilConfirm.error = "Konfirmasi password tidak sama"
            return
        }

        UserSession.fullName = fullName
        UserSession.username = username
        UserSession.password = password

        UserSession.isLoggedIn = true

        val intent = Intent(this, HomeActivity::class.java)
        intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
        startActivity(intent)
    }
}