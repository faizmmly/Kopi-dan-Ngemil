package lat.pam.kopidannyemil

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import lat.pam.kopidannyemil.adapter.MenuAdapter
import lat.pam.kopidannyemil.data.DummyData
import lat.pam.kopidannyemil.data.UserSession
import lat.pam.kopidannyemil.databinding.ActivityHomeBinding

class HomeActivity : AppCompatActivity() {

    private lateinit var binding: ActivityHomeBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityHomeBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.rvMenu.layoutManager = LinearLayoutManager(this)
        binding.rvMenu.adapter = MenuAdapter(DummyData.menuList)

        binding.tabOrder.setOnClickListener {
            startActivity(Intent(this, AddressActivity::class.java))
        }
        binding.tabProfile.setOnClickListener {
            startActivity(Intent(this, ProfileActivity::class.java))
        }
    }

    override fun onResume() {
        super.onResume()
        binding.tvGreeting.text = "Halo ${UserSession.fullName},"
    }
}