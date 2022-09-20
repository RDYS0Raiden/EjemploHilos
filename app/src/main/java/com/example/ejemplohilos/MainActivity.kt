package com.example.ejemplohilos

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.ejemplohilos.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var  binding: ActivityMainBinding
    private lateinit var movie:Movie

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //setContentView(R.layout.activity_main)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        movie = Movie("Avengers: End Game", 4)
        binding.btnIniciar.setOnClickListener { iniciarDescarga() }
    }

    private fun iniciarDescarga(){
        binding.txtDescarga.text = "Iniciando Descarga"
        Thread.sleep(8000)
        binding.txtDescarga.text = "Descarga Finalizando"
        binding.txtEjecucion.text = movie.play()

    }
    private fun iniciarHilo(){
        //los Threads trabajan con objetos llamados Runnable
        //Runnable: interfaz
        val hilo=Thread()
    }

}