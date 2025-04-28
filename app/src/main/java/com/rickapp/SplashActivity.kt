package com.rickapp

import android.animation.ValueAnimator
import android.app.ActivityOptions
import android.content.Intent
import android.media.MediaPlayer
import android.os.Bundle
import android.transition.Fade
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.rickapp.databinding.ActivitySplashBinding
import com.rickapp.util.createFade

class SplashActivity : AppCompatActivity() {

    private lateinit var binding: ActivitySplashBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivitySplashBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        setActivityAnimation()
        startButtonAnimation()
        setOnClick()
    }

      fun setActivityAnimation() {
       val fadeOut = createFade()
        window.exitTransition = fadeOut
    }

    fun setOnClick() {
        binding.startButton.setOnClickListener {

            var mediaPlayer = MediaPlayer.create(this, R.raw.sound_rick)
            mediaPlayer.start()

            val intento = Intent(this, HomeActivity::class.java)
            val options = ActivityOptions.makeSceneTransitionAnimation(this)
            startActivity(intento, options.toBundle())

        }
    }

    fun startButtonAnimation() {

        ValueAnimator.ofFloat(0f, 1f).apply {
            duration = 1100
            repeatMode = ValueAnimator.REVERSE
            repeatCount = ValueAnimator.INFINITE

            addUpdateListener {
                binding.startButton.alpha = it.animatedValue as Float
            }

            start()
        }

    }

}