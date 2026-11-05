package lat.pam.kopidannyemil

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import lat.pam.kopidannyemil.data.UserSession
import lat.pam.kopidannyemil.databinding.ActivityLoginBinding

class LoginActivity : AppCompatActivity() {

    private lateinit var binding: ActivityLoginBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnLogin.setOnClickListener { doLogin() }

        binding.tvGoRegister.setOnClickListener {
            startActivity(Intent(this, RegisterActivity::class.java))
        }
    }

    private fun doLogin() {
        val username = binding.etUsername.text.toString().trim()
        val password = binding.etPassword.text.toString()

        binding.tilUsername.error = null
        binding.tilPassword.error = null

        if (username.isEmpty()) {
            binding.tilUsername.error = "Username tidak boleh kosong"
            return
        }
        if (password.isEmpty()) {
            binding.tilPassword.error = "Password tidak boleh kosong"
            return
        }

        // PERBAIKAN: Ditambah tanda seru (!) di depan UserSession
        if (!UserSession.isRegistered()) {
            binding.tilUsername.error = "Akun belum terdaftar, silakan register dulu"
            return
        }

        if (username != UserSession.username || password != UserSession.password) {
            binding.tilPassword.error = "Username atau password salah"
            return
        }

        // Set status login menjadi true setelah berhasil verifikasi
        UserSession.isLoggedIn = true

        val intent = Intent(this, HomeActivity::class.java)
        intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
        startActivity(intent)
        finish()
    }
}