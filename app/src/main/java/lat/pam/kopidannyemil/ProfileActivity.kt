package lat.pam.kopidannyemil

import android.content.Intent
import android.os.Bundle
import android.view.inputmethod.EditorInfo
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import lat.pam.kopidannyemil.data.UserSession
import lat.pam.kopidannyemil.databinding.ActivityProfileBinding

class ProfileActivity : AppCompatActivity() {

    private lateinit var binding: ActivityProfileBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityProfileBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnSave.pressEffect()
        showUser()
        binding.etName.setText(UserSession.fullName)

        binding.btnSave.setOnClickListener { save() }
        binding.etName.setOnEditorActionListener { _, actionId, _ ->
            if (actionId == EditorInfo.IME_ACTION_DONE) {
                save()
                true
            } else false
        }
        binding.etName.addTextChangedListener(object : android.text.TextWatcher {
            override fun beforeTextChanged(s: CharSequence?, st: Int, c: Int, a: Int) {}
            override fun onTextChanged(s: CharSequence?, st: Int, b: Int, c: Int) {
                binding.tilName.error = null
            }
            override fun afterTextChanged(s: android.text.Editable?) {}
        })

        binding.tabHome.setOnClickListener { finish() }
        binding.tabOrder.setOnClickListener {
            startActivity(Intent(this, AddressActivity::class.java))
            finish()
        }

        binding.tvLogout.setOnClickListener {
            AlertDialog.Builder(this)
                .setTitle("Keluar dari akun?")
                .setMessage("Kamu bisa masuk lagi kapan saja dengan akun yang sama.")
                .setNegativeButton("Batal", null)
                .setPositiveButton("Keluar") { _, _ ->
                    UserSession.isLoggedIn = false
                    val intent = Intent(this, SignUpActivity::class.java)
                    intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
                    startActivity(intent)
                }
                .show()
        }
    }

    private fun showUser() {
        val fullName = UserSession.fullName
        val firstName = fullName.trim().split(" ").firstOrNull().orEmpty()
        binding.tvGreeting.text = "Halo $firstName,"
        binding.tvAvatarBig.text = firstName.trim().take(1).uppercase()
        binding.tvUsername.text = "@${UserSession.username}"
    }

    private fun save() {
        val newName = binding.etName.text.toString().trim()
        if (newName.isEmpty()) {
            binding.tilName.error = "Nama tidak boleh kosong"
            return
        }
        UserSession.fullName = newName
        showUser()
        Toast.makeText(this, "Profil berhasil disimpan", Toast.LENGTH_SHORT).show()
    }
}