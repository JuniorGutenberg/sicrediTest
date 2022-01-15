package com.sicredi.sicrediteste.view.activity

import android.content.Intent
import android.os.Build
import android.os.Bundle
import android.os.CountDownTimer
import android.view.animation.Animation
import android.view.animation.AnimationUtils
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import com.sicredi.sicrediteste.R
import com.sicredi.sicrediteste.databinding.ActivitySplashBinding

class SplashActivity:AppCompatActivity() {

    private lateinit var binding: ActivitySplashBinding
    private lateinit var animationTop:Animation
    private lateinit var animationBottom:Animation
    private val SEGUNDOS:Long = 5000
    private val INTERVALO:Long = 1000


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySplashBinding.inflate(layoutInflater)
        setContentView(binding.root)

        changeStatusBarColor()
        setAnimation()
        countDown()
    }

    private fun setAnimation(){
        animationTop = AnimationUtils.loadAnimation(this, R.anim.top_to_bottom_splash)
        animationBottom = AnimationUtils.loadAnimation(this, R.anim.bottom_to_top_splash)

        binding.apply {
            iv.animation = animationTop
            tvDesenvolvido.animation = animationBottom
            tvProcesso.animation = animationBottom
        }
    }
    private fun changeStatusBarColor(){
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            window.statusBarColor = ContextCompat.getColor(this,R.color.fundo)
        }
    }
    private fun countDown(){
        val timer = object: CountDownTimer(SEGUNDOS, INTERVALO) {
            override fun onTick(millisUntilFinished: Long) {}

            override fun onFinish() {
                finalizar()
            }
        }
        timer.start()
    }
    private fun finalizar(){
        val intent = Intent(this@SplashActivity,MainActivity::class.java)
        startActivity(intent)
        finish()
    }
}