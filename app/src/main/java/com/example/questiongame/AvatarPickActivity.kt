package com.example.questiongame

import android.content.Intent
import android.content.res.ColorStateList
import android.graphics.Color
import android.graphics.Typeface
import android.graphics.drawable.ColorDrawable
import android.graphics.drawable.Drawable
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.content.res.AppCompatResources
import androidx.appcompat.widget.AppCompatImageButton
import androidx.core.content.ContextCompat
import com.example.questiongame.Constants.Equipo_1.Jugadores1
import com.example.questiongame.Constants.Equipo_1.team1Avatar
import com.example.questiongame.Constants.Equipo_1.team1BirthDate
import com.example.questiongame.Constants.Equipo_1.team1Name
import com.example.questiongame.Constants.Equipo_1.team1Players
import com.example.questiongame.Constants.Equipo_2.Jugadores2
import com.example.questiongame.Constants.Equipo_2.team2Avatar
import com.example.questiongame.Constants.Equipo_2.team2BirthDate
import com.example.questiongame.Constants.Equipo_2.team2Name
import com.example.questiongame.Constants.Equipo_2.team2Players
import com.example.questiongame.Constants.Equipo_3.Jugadores3
import com.example.questiongame.Constants.Equipo_3.team3Avatar
import com.example.questiongame.Constants.Equipo_3.team3BirthDate
import com.example.questiongame.Constants.Equipo_3.team3Name
import com.example.questiongame.Constants.Equipo_3.team3Players
import com.example.questiongame.Constants.GlobalVariable.PlayerDrawable
import com.example.questiongame.Constants.GlobalVariable.fechaDeNacimiento1
import com.example.questiongame.Constants.GlobalVariable.player1Name
import com.example.questiongame.Constants.Partida.matchQuestions
import com.example.questiongame.Constants.Partida.singlePlayer
import com.example.questiongame.Constants.Partida.teamSize
import com.example.questiongame.databinding.ActivityAvatarPickBinding
import kotlinx.android.synthetic.main.activity_avatar_pick.view.*

/*
* Esta Actividad lo que hace es setear el avatar de tanto los grupos como el single player
*
* */

class AvatarPickActivity : AppCompatActivity(), View.OnClickListener{

    private lateinit var binding : ActivityAvatarPickBinding
    private var actualDrawable : Drawable = ColorDrawable(Color.TRANSPARENT) // El dibujo seleccionado actual
    private var iTeam1 : Int = 1 //Una variable iteracion para cada uno de los equipos
    private var iTeam2 : Int = 0
    private var iTeam3 : Int = 0
    private var totalPlayers : Int = team1Players + team2Players + team3Players // la cantidad de jugdores totales en el juego, determinado por la pantalla anterior
    private var jugadores : Int = 0 // Variable que sirve para condicionar una igualdad para proceder a la siguiente actividad

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityAvatarPickBinding.inflate(layoutInflater)

        // Inicializa los avatares la primera primericima vez en la pantalla
        if (singlePlayer){
            binding.tvAvatarPickTittle.text = "Ingrese su Avatar, su nombre y fecha de nacimiento"
        }else{
            binding.tvAvatarPickTittle.text = "Ingrese los datos del participante 1 del equipo 1"
        }
        setContentView(binding.root)

    binding.ivImg1.setOnClickListener(this)
    binding.ivImg2.setOnClickListener(this)
    binding.ivImg3.setOnClickListener(this)
    binding.ivImg4.setOnClickListener(this)
    binding.ivImg5.setOnClickListener(this)
    binding.ivImg6.setOnClickListener(this)
    binding.btnPlayerInfoSubmit.setOnClickListener(this)
    }

    override fun onClick(v: View?) {
        when (v?.id){
            //cada botón llama a las funciones OptionsView y getPic, las cuales estan descritas mas abajo
            R.id.iv_img_1->{
                optionsView(binding.ivImg1)
                getPic(binding.ivImg1)
            }
            R.id.iv_img_2->{
                optionsView(binding.ivImg2)
                getPic(binding.ivImg2)
            }
            R.id.iv_img_3->{
                optionsView(binding.ivImg3)
                getPic(binding.ivImg3)
            }
            R.id.iv_img_4->{
                optionsView(binding.ivImg4)
                getPic(binding.ivImg4)
            }
            R.id.iv_img_5->{
                optionsView(binding.ivImg5)
                getPic(binding.ivImg5)
            }
            R.id.iv_img_6->{
                optionsView(binding.ivImg6)
                getPic(binding.ivImg6)
            }
            // Este botón basicamente contiene toda la funcionalidad de casi toda la actividad
            R.id.btn_PlayerInfoSubmit->{
                //Primero, si es que los campos de texto estan vacios, emite un Toast que dice "Rellena tus datos por favor"
                if (binding.etName.text.toString().isEmpty() || binding.etDate.text.toString().isEmpty()){
                    Toast.makeText(this,"Rellena tus datos por favor", Toast.LENGTH_SHORT).show()
                }else{
                    //Ahora, si estan completos, revisa si es un juego de un jugador o de multiples
                    // Si es un juego single, simplemente setea las preguntas y asigna los datos "PlayerDrawable","Player1Name", "fechaDeNacimiento1"
                    if ( singlePlayer ){
                        matchQuestions = Constants.getPreguntas()
                        val intent = Intent(this, QuestionActivity::class.java)
                        PlayerDrawable = actualDrawable
                        player1Name = binding.etName.text.toString()
                        fechaDeNacimiento1 = binding.etDate.text.toString()
                        startActivity(intent)
                    }else{
                        //Ahora bien, en caso de que sea un juego multi player, se hace lo siguiente:
                        // Primero, se guarda el jugador actual en una variable jugador


                        val jugador = Player(actualDrawable,binding.etName.text.toString(),binding.etDate.text.toString())

                        /* Luego se setea una variable "ingresado" para que cuando ingresemos un jugador, y cambiemos al siguiente grupo de jugadores
                        no se ingrese el jugador imediatamente a la lista equivocada */
                            var ingresado : Boolean = false
                        /*  La lógica es la siguiente :
                        * Primero vemos si es que la variable iteam es menor o igual a la cantidad de jugadores totales del equipo, los cuales fueron seleccionados
                        * en la actividad anterior y tambén, que no sea 0 esta misma variable.  * */
                            if (iTeam1 <= team1Players && iTeam1 != 0){
                                //Cuando iTeam1 tenga un determinado valor (1,2,3), dependiendo si la la i es igual o no a la cnatidad de jugadores totales por equipo
                                when (iTeam1){
                                    1->{
                                        /*Si la i es igual a los jugadores totales del equipo, se añade un jugador y se aumenta la cantidad de jugadores
                                        , se cambia el texto, se setea el iteam1  en 0 para que no entre a al if de arriba,
                                         se agrega true al ingresado, cosa que no se ingrese automaticamente al if del equipo 2 */
                                        if (iTeam1 == team1Players){
                                            Jugadores1.add(jugador)
                                            jugadores++
                                            binding.tvAvatarPickTittle.text =
                                                "Ingrese los datos del participante numero 1 del equipo 2"
                                            iTeam1 = 0
                                            iTeam2 = 1
                                            ingresado = true
                                            println("if11")
                                        }else{
                                            // Caso contrario, se añade el jugador, se suman los jugadores, se le suma 1 al iteam1 para que entre una segunda vez
                                            // No le borré los print, porque por ahí puede servir para saber si existe algún problema posteriormente
                                            Jugadores1.add(jugador)
                                            jugadores++
                                            iTeam1++
                                            binding.tvAvatarPickTittle.text =
                                                "Ingrese los datos del participante numero " + iTeam1 +  " del equipo 1"
                                            ingresado = true
                                            println("else11")
                                        }
                                    }
                                    2->{
                                        if (iTeam1 == team1Players){
                                            Jugadores1.add(jugador)
                                            jugadores++
                                            binding.tvAvatarPickTittle.text =
                                                "Ingrese los datos del participante numero 1 del equipo 2"
                                            iTeam1 = 0
                                            iTeam2++
                                            ingresado = true
                                            println("if12")
                                        }else{
                                            Jugadores1.add(jugador)
                                            jugadores++
                                            iTeam1++
                                            binding.tvAvatarPickTittle.text =
                                                "Ingrese los datos del participante numero " + iTeam1 +  " del equipo 1"
                                            ingresado = true
                                            println("else12")
                                        }
                                    }
                                    3->{
                                        if (iTeam1 == team1Players){
                                            Jugadores1.add(jugador)
                                            jugadores++
                                            binding.tvAvatarPickTittle.text =
                                                "Ingrese los datos del participante numero 1 del equipo 2"
                                            iTeam1 = 0
                                            iTeam2 = 1
                                            ingresado = true
                                            println("if13")
                                        }else{
                                            Jugadores1.add(jugador)
                                            jugadores++
                                            iTeam1++
                                            binding.tvAvatarPickTittle.text =
                                                "Ingrese los datos del participante numero " + iTeam1 +  " del equipo 1"
                                            println("else13")
                                            ingresado = true
                                        }
                                    }
                                }
                            }
                            if (iTeam2 <= team2Players && iTeam2 != 0 && !ingresado ){
                                when (iTeam2){
                                    1->{
                                        if (iTeam2 == team2Players){
                                            Jugadores2.add(jugador)
                                            jugadores++
                                            binding.tvAvatarPickTittle.text =
                                                "Ingrese los datos del participante numero 1 del equipo 3"
                                            iTeam2 = 0
                                            iTeam3 = 1
                                            ingresado = true
                                            println("if21")
                                        }else{
                                            Jugadores2.add(jugador)
                                            jugadores++
                                            iTeam2++
                                            binding.tvAvatarPickTittle.text =
                                                "Ingrese los datos del participante numero " + iTeam2 +  " del equipo 2"
                                            ingresado = true
                                            println("else21")
                                        }
                                    }
                                    2->{
                                        if (iTeam2 == team2Players){
                                            Jugadores2.add(jugador)
                                            jugadores++
                                            binding.tvAvatarPickTittle.text =
                                                "Ingrese los datos del participante numero 1 del equipo 3"
                                            iTeam2 = 0
                                            iTeam3 = 1
                                            ingresado = true
                                            println("if22")
                                        }else{
                                            Jugadores2.add(jugador)
                                            jugadores++
                                            iTeam2++
                                            binding.tvAvatarPickTittle.text =
                                                "Ingrese los datos del participante numero " + iTeam2 +  " del equipo 2"
                                            ingresado = true
                                            println("else22")
                                        }
                                    }
                                    3->{
                                        if (iTeam2 == team2Players){
                                            Jugadores2.add(jugador)
                                            jugadores++
                                            binding.tvAvatarPickTittle.text =
                                                "Ingrese los datos del participante numero 1 del equipo 3"
                                            iTeam2 = 0
                                            iTeam3 = 1
                                            ingresado = true
                                            println("if23")
                                        }else{
                                            Jugadores2.add(jugador)
                                            jugadores++
                                            iTeam2++
                                            binding.tvAvatarPickTittle.text =
                                                "Ingrese los datos del participante numero " + iTeam2 +  " del equipo 2"
                                            ingresado = true
                                            println("else23")
                                        }
                                    }
                                }
                            }
                            if (iTeam3 <= team3Players && iTeam3 != 0 && !ingresado){
                                when (iTeam3){
                                    1->{
                                        if (iTeam3 == team3Players){
                                            Jugadores3.add(jugador)
                                            jugadores++
                                            println("if31")
                                        }else{
                                            Jugadores3.add(jugador)
                                            jugadores++
                                            iTeam3++
                                            binding.tvAvatarPickTittle.text =
                                                "Ingrese los datos del participante numero " + iTeam3 +  " del equipo 3"
                                            println("else31")
                                        }
                                    }
                                    2->{
                                        if (iTeam3 == team3Players){
                                            Jugadores3.add(jugador)
                                            jugadores++
                                            println("if32")
                                        }else{
                                            Jugadores3.add(jugador)
                                            jugadores++
                                            iTeam3++
                                            binding.tvAvatarPickTittle.text =
                                                "Ingrese los datos del participante numero " + iTeam3 +  " del equipo 3"
                                            println("else32")
                                        }
                                    }
                                    3->{
                                        if (iTeam3 == team3Players){
                                            Jugadores3.add(jugador)
                                            jugadores++
                                            println("if33")
                                        }else{
                                            Jugadores3.add(jugador)
                                            jugadores++
                                            iTeam3++
                                            binding.tvAvatarPickTittle.text =
                                                "Ingrese los datos del participante numero " + iTeam3 +  " del equipo 3"
                                            println("else33")
                                        }
                                    }
                                }
                            }
                        // Una vez esten los jugadores listos, eso quiere decir, que sean iguales a la cantidad total de jugadores, va a irse hacia la siguiente actividad
                        // Además, se crean las listas de jugadores en cada una de las constantes, además de las preguntas para la partida.
                        if (jugadores == totalPlayers){
                            when( teamSize ){
                                2->{
                                    setLista2Player(Jugadores1, Jugadores2)
                                }
                                3->{
                                    setListas(Jugadores1, Jugadores2, Jugadores3)
                                }
                            }
                            matchQuestions = Constants.getPreguntas()
                            val intent = Intent(this, QuestionActivity::class.java)
                            startActivity(intent)
                        }
                        ingresado = false
                        resetSelected()
                    }
                }
            }
        }
    }

    // Esta función recibe el botón seleccionado (cualquiera de los avatares), Y guarda la imagen en el drawable global
    fun getPic(imageButton: AppCompatImageButton){
        val drawable: Drawable = imageButton.drawable
        actualDrawable = drawable
    }


    // Esta funcion, setea todos los botones en fondo blanco, excepto el seleccionado
    private fun optionsView(imageButton: AppCompatImageButton){
        val options = ArrayList<AppCompatImageButton>()
        options.add(0,binding.ivImg1)
        options.add(1,binding.ivImg2)
        options.add(2,binding.ivImg3)
        options.add(3,binding.ivImg4)
        options.add(4,binding.ivImg5)
        options.add(5,binding.ivImg6)
        for (option in options){
            val color = ColorStateList.valueOf(Color.WHITE)
            option.backgroundTintList = color
        }
        val selectedColor = ColorStateList.valueOf(Color.BLACK)
        imageButton.backgroundTintList = selectedColor
    }

    // Esta función lo que hace es resetear todos los campos y el avatar cuando se aprete el botón submit
    fun resetSelected(){
        binding.ivImg1.backgroundTintList = ColorStateList.valueOf(Color.WHITE)
        binding.ivImg2.backgroundTintList = ColorStateList.valueOf(Color.WHITE)
        binding.ivImg3.backgroundTintList = ColorStateList.valueOf(Color.WHITE)
        binding.ivImg4.backgroundTintList = ColorStateList.valueOf(Color.WHITE)
        binding.ivImg5.backgroundTintList = ColorStateList.valueOf(Color.WHITE)
        binding.ivImg6.backgroundTintList = ColorStateList.valueOf(Color.WHITE)
        binding.etName.text!!.clear()
        binding.etName.clearFocus()
        binding.etDate.text!!.clear()
        binding.etDate.clearFocus()
    }
    // Función que ingresa los datos correspondientes de los participantes a las variables globales que corresponden
    fun setListas(Lista_1 : ArrayList<Player>, Lista_2 : ArrayList<Player>, Lista_3 : ArrayList<Player>){
        getDetailsForTeam(Lista_1,1)
        getDetailsForTeam(Lista_2,2)
        getDetailsForTeam(Lista_3,3)
    }
    fun setLista2Player(Lista_1 : ArrayList<Player>, Lista_2 : ArrayList<Player>){
        getDetailsForTeam(Lista_1,1)
        getDetailsForTeam(Lista_2,2)
    }

    fun getDetailsForTeam(Lista : ArrayList<Player>, index: Int){
        val edades = ArrayList<Int>()
        var avatar :Drawable = ColorDrawable(Color.TRANSPARENT)
        var nombre : String = ""
        var oldest : Int = 0

        // Si la lista es == 1, asigna directamente, cosa que no se muera cuando el equipo sea de tamaño 1
        if ( Lista.size == 1){
            println(Lista.size)
            println(Lista)
            avatar = Lista[0].playerAvatar
            nombre = Lista[0].name
            oldest = Lista[0].birthDate.toInt()
        }else{
            //En caso que no sea de tamaño 1, se hace un for desde 1 hasta el size maximo.
            for ( i in 1..Lista.size){
                edades[i] = Lista[i].birthDate.toInt()
            }
            edades.sort()
            oldest = edades.first()
            for ( i in 1..Lista.size){
                if (Lista[i].birthDate.toInt() == oldest){
                    avatar = Lista[i].playerAvatar
                }
            }
            for ( i in 1..Lista.size){
                if (Lista[i].birthDate.toInt() == oldest){
                    nombre = Lista[i].name
                }
            }
        }
        // según el index que le pase, se asignan detalles al equipo.
        when( index ){
            1->{
                team1Avatar = avatar
                team1Name = nombre
                team1BirthDate = oldest.toString()
            }
            2->{
                team2Avatar = avatar
                team2Name = nombre
                team2BirthDate = oldest.toString()
            }
            3->{
                team3Avatar = avatar
                team3Name = nombre
                team3BirthDate = oldest.toString()
            }
        }
    }
}