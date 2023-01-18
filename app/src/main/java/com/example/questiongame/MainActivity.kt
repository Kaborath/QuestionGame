package com.example.questiongame

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.example.questiongame.databinding.ActivityMainBinding

/*  Esta Actividad es muy sencilla, es solo una activity que es de tipo View.OnClicklistener, quiere decir que todos los botones de la vista, si
* se le entrega el contexto, pueden ser usados para registrar una acción en particular. En este caso, la función onClick, esta ligada a los 3 botones que se muestran
*  en pantalla.
*
* Falta implementar, Si es que se quiere :
*
* 1.- Configuración(En caso de no necesitarse borrar el botón y mover la ui/layout)
* 2.- La Actividad esta, tiene un dato que hay que recoger buscando la geolocalización. El layout esta hecho, y se tiene el id "tv_zone"
* 3.- Navegación a través de la pagina app, ya que funciona de forma unidireccional, no se puede devolver, porque sino no funciona.
* 4.- El bluetooth (fue imposible, requería conocimientos de socket que no logramos hacer funcionar)
* 5.- Mejorar la actividad final de resultado.
* */
class MainActivity : AppCompatActivity(), View.OnClickListener {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnPlay.setOnClickListener(this)
        binding.btnTutorial.setOnClickListener(this)
        binding.btnConfig.setOnClickListener(this)

    }
    // La funcion elige entre elegir el modo de juego, al tutorial y a la configuración
    override fun onClick(v: View?) {
        when(v?.id){
            R.id.btn_Play->{
                val intent = Intent(this, ModeSelectActivity::class.java)
                startActivity(intent)
            }
            R.id.btn_Tutorial->{
                val intent = Intent(this, TutorialActivity::class.java)
                startActivity(intent)
            }
            // Esta funcionalidad falta implementarla. Que es la configuración de subir o bajar la fuente.
            R.id.btn_Config->{
            }
        }
    }


}
