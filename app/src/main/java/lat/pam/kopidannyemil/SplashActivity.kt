package lat.pam.kopidannyemil

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.view.animation.OvershootInterpolator
import androidx.appcompat.app.AppCompatActivity
import lat.pam.kopidannyemil.databinding.ActivitySplashBinding

class SplashActivity : AppCompatActivity() {

    private lateinit var binding: ActivitySplashBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySplashBinding.inflate(layoutInflater)
        setContentView(binding.root)

        playIntro()

        binding.btnStart.setOnClickListener {
            startActivity(Intent(this, SignUpActivity::class.java))
        }
    }

    private fun playIntro() {
        // Logo: membesar dengan efek memantul
        binding.logoCircle.apply {
            alpha = 0f
            scaleX = 0.4f
            scaleY = 0.4f
            animate().alpha(1f).scaleX(1f).scaleY(1f)
                .setDuration(700)
                .setInterpolator(OvershootInterpolator())
                .start()
        }

        // Teks dan tombol: naik sambil muncul, berurutan
        slideUp(binding.tvAppName, 400)
        slideUp(binding.tvTagline, 600)
        slideUp(binding.btnStart, 800)
    }

    private fun slideUp(view: View, delay: Long) {
        view.alpha = 0f
        view.translationY = 40f
        view.animate().alpha(1f).translationY(0f)
            .setStartDelay(delay)
            .setDuration(500)
            .start()
    }
}