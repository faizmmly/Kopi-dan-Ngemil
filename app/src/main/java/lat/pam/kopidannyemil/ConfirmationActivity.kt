package lat.pam.kopidannyemil

import android.content.Intent
import android.os.Bundle
import android.view.animation.OvershootInterpolator
import androidx.activity.OnBackPressedCallback
import androidx.appcompat.app.AppCompatActivity
import lat.pam.kopidannyemil.data.Cart
import lat.pam.kopidannyemil.data.LastOrder
import lat.pam.kopidannyemil.data.UserSession
import lat.pam.kopidannyemil.databinding.ActivityConfirmationBinding

class ConfirmationActivity : AppCompatActivity() {

    private lateinit var binding: ActivityConfirmationBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityConfirmationBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val firstName = UserSession.fullName.trim().split(" ").firstOrNull().orEmpty()
        binding.tvGreeting.text = "Halo $firstName,"

        binding.tvOrderNo.text = LastOrder.number
        binding.tvPayment.text = LastOrder.payment
        binding.tvTotal.text = Cart.formatRupiah(LastOrder.total)
        binding.tvAddress.text = LastOrder.address

        Cart.clear()

        binding.okCircle.apply {
            scaleX = 0f
            scaleY = 0f
            animate().scaleX(1f).scaleY(1f)
                .setDuration(600)
                .setInterpolator(OvershootInterpolator())
                .start()
        }

        binding.btnOke.pressEffect()

        onBackPressedDispatcher.addCallback(this, object : OnBackPressedCallback(true) {
            override fun handleOnBackPressed() {
                backToHome()
            }
        })
    }

    private var leaving = false

    private fun backToHome() {
        if (leaving) return
        leaving = true
        val intent = Intent(this, HomeActivity::class.java)
        intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
        startActivity(intent)
    }
}