package com.example.ejemplohilos

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.ejemplohilos.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var  binding: ActivityMainBinding
    private lateinit var movie:Movie

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //setContentView(R.layout.activity_main) cunado se utiliza el binding ya no es necesario esta parte
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        movie = Movie("Avengers: End Game", 4)
        binding.btnIniciar.setOnClickListener { iniciarDescarga()
        iniciarHilo()
        }

    }

    private fun iniciarDescarga(){

        //Thread.sleep(8000)

        binding.txtEjecucion.text = movie.play()

    }
    private fun iniciarHilo(){
        binding.txtDescarga.text = "Iniciando Descarga"

        //los Threads trabajan con objetos llamados Runnable
        //Runnable: interfaz anonima.. que existe que implemente
        //una regla del juego llamada run()
        //run-- contiene todas las instrucciones que van a ejecutar
        //en esegundo plano
        val hilo=Thread(Runnable {
            try {
                Thread.sleep(8000)
                //si quieres hablar con la interfaz de usuario
                //desde un hilo paralelo tienes que hacerlo o
                //con un handler o usando un metodo llamando runOnUiThread
                binding.txtDescarga.text = "Descarga Finalizando"
            }catch (e:InterruptedException){
                e.printStackTrace()
            }
        })
        //arrancar el hilo
        hilo.start()
    }

}