package com.example.questiongame
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.graphics.drawable.Drawable

object Constants {

    // Constantes que vamos a usar para pasar parametros al jugador singular. Este sirve solo en modo Single Player
    object GlobalVariable {
        var timeline = 1
        var player1Name : String = ""
        var fechaDeNacimiento1 : String = ""
        var PlayerDrawable: Drawable = ColorDrawable(Color.TRANSPARENT)
        var playerPoints: Int = 0
        var playerPos: Float = 0f
    }
    // Aca tenemos objetos particulares que guardan diferentes datos de un equipo en particular. Esto se repite hasta un maximo de 3 equipos
    object Equipo_1{
        var team1Name : String = ""
        var team1BirthDate: String = ""
        var team1Avatar: Drawable = ColorDrawable(Color.TRANSPARENT)
        var Jugadores1 = ArrayList<Player>()
        var team1Players : Int = 0
        var team1Points: Int = 0
        var team1Pos : Float = 0f
    }
    object Equipo_2{
        var team2Name : String = ""
        var team2BirthDate: String = ""
        var team2Avatar: Drawable = ColorDrawable(Color.TRANSPARENT)
        var Jugadores2 = ArrayList<Player>()
        var team2Players : Int = 0
        var team2Points: Int = 0
        var team2Pos : Float = 0f
    }
    object Equipo_3{
        var team3Name : String = ""
        var team3BirthDate: String = ""
        var team3Avatar: Drawable = ColorDrawable(Color.TRANSPARENT)
        var Jugadores3 = ArrayList<Player>()
        var team3Players : Int = 0
        var team3Points: Int = 0
        var team3Pos : Float = 0f
    }
    // Aca estan los datos especificos de la partida. como por ejemplo
    object Partida{
        var singlePlayer : Boolean = false
        var teamSize : Int = 0
        var turno : Int = 1
        var matchWinner : Int = 0
        var matchQuestions = ArrayList<Pregunta>()
        var answerType: Boolean = false
    }
    // esta funcion arma todas las preguntas ( Se hace un shuffle al final)
    fun getPreguntas(): ArrayList<Pregunta>{
        val listaPreguntas = ArrayList<Pregunta>()

        val pregunta1 = Pregunta(
            1,
            encabezado = "¿En donde ocurrió el bombardeo atómico ocurrido en 1945?",
            opcionUno = "Nagasaki",
            opcionDos = "Ozawa",
            opcionTres = "Tokio",
            opcionCuatro = "Kioto",
            respuestaCorrecta = 1
        )
        listaPreguntas.add(pregunta1)

        val pregunta2 = Pregunta(
            2,
            encabezado = "¿En que año terminó la segunda guerra mundial",
            opcionUno = "1943",
            opcionDos = "1945",
            opcionTres = "1949",
            opcionCuatro = "1947",
            respuestaCorrecta = 2
        )
        listaPreguntas.add(pregunta2)

        val pregunta3 = Pregunta(
            3,
            encabezado = "¿En que año murió Adolf Hitler?",
            opcionUno = "1943",
            opcionDos = "1945",
            opcionTres = "1949",
            opcionCuatro = "1947",
            respuestaCorrecta = 2
        )
        listaPreguntas.add(pregunta3)

        val pregunta4 = Pregunta(
            4,
            encabezado = "¿En que año inició la guerra fria?",
            opcionUno = "1943",
            opcionDos = "1949",
            opcionTres = "1945",
            opcionCuatro = "1947",
            respuestaCorrecta = 4
        )
        listaPreguntas.add(pregunta4)

        val pregunta5 = Pregunta(
            5,
            encabezado = "¿Como fue llamado a los disturbios generados en la Capital de Colombia tras conocerse la trágica noticia de que el líder izquierdista del Partido Liberal, Jorge Eliécer Gaitán, había sido asesinado?",
            opcionUno = "El bogotazo",
            opcionDos = "El capitalazo",
            opcionTres = "El colombianazo",
            opcionCuatro = "El gaitanazo",
            respuestaCorrecta = 1
        )
        listaPreguntas.add(pregunta5)

        val pregunta6 = Pregunta(
            6,
            encabezado = "¿En qué año inicio el primer campeonato del futbol profesional colombiano?",
            opcionUno = "1945",
            opcionDos = "1948",
            opcionTres = "1949",
            opcionCuatro = "1947",
            respuestaCorrecta = 2
        )
        listaPreguntas.add(pregunta6)

        val pregunta7 = Pregunta(
            7,
            encabezado = "¿En qué año fue el alunizaje del apolo 11?",
            opcionUno = "1965",
            opcionDos = "1969",
            opcionTres = "1961",
            opcionCuatro = "1963",
            respuestaCorrecta = 2
        )
        listaPreguntas.add(pregunta7)

        val pregunta8 = Pregunta(
            8,
            encabezado = "¿Como se llamaba el primer avión que logro un viaje supersónico exitoso con enfoque comercial en 1969?",
            opcionUno = "Boing 747",
            opcionDos = "Sonic 292",
            opcionTres = "Concorde",
            opcionCuatro = "Airbus 323",
            respuestaCorrecta = 3
        )
        listaPreguntas.add(pregunta8)

        val pregunta9 = Pregunta(
            9,
            encabezado = "¿En qué año finalizo la construcción del muro de Berlín?",
            opcionUno = "1964",
            opcionDos = "1968",
            opcionTres = "1966",
            opcionCuatro = "1962",
            respuestaCorrecta = 4
        )
        listaPreguntas.add(pregunta9)

        val pregunta10 = Pregunta(
            10,
            encabezado = "¿En qué año se aprobó la primera píldora anticonceptiva",
            opcionUno = "1960",
            opcionDos = "1962",
            opcionTres = "1964",
            opcionCuatro = "1966",
            respuestaCorrecta = 1
        )
        listaPreguntas.add(pregunta10)

        val pregunta11 = Pregunta(
            11,
            encabezado = "¿Cómo se llamaba el presidente estadounidense asesinado en 1963?",
            opcionUno = "Abraham Lincoln",
            opcionDos = "John F. Kennedy",
            opcionTres = "Franklin D. Roosevelt",
            opcionCuatro = "Warren G. Harding",
            respuestaCorrecta = 2
        )
        listaPreguntas.add(pregunta11)

        val pregunta12 = Pregunta(
            12,
            encabezado = "¿En qué año se realiza el primer trasplante exitoso de corazón",
            opcionUno = "1968",
            opcionDos = "1961",
            opcionTres = "1967",
            opcionCuatro = "1963 ",
            respuestaCorrecta = 3
        )
        listaPreguntas.add(pregunta12)

        val pregunta13 = Pregunta(
            13,
            encabezado = "¿En qué año el Apollo 13 regreso a la tierra con sus tripulantes a salvo?",
            opcionUno = "1973",
            opcionDos = "1970",
            opcionTres = "1976",
            opcionCuatro = "1978",
            respuestaCorrecta = 2
        )
        listaPreguntas.add(pregunta13)

        val pregunta14 = Pregunta(
            14,
            encabezado = "¿En qué año fue fundada la empresa de tecnología Microsoft?",
            opcionUno = "1973",
            opcionDos = "1971",
            opcionTres = "1975",
            opcionCuatro = "1978",
            respuestaCorrecta = 3
        )
        listaPreguntas.add(pregunta14)

        val pregunta15 = Pregunta(
            15,
            encabezado = "¿En qué año fue fundada la empresa de tecnología Apple?",
            opcionUno = "1973",
            opcionDos = "1971",
            opcionTres = "1978",
            opcionCuatro = "1976",
            respuestaCorrecta = 4
        )
        listaPreguntas.add(pregunta15)

        val pregunta16 = Pregunta(
            16,
            encabezado = "¿Cómo fue nombrado el papa elegido en el año de 1978?",
            opcionUno = "Juan Pablo II",
            opcionDos = "San Pablo VI",
            opcionTres = "San Juan XXIII",
            opcionCuatro = "Juan Pablo I",
            respuestaCorrecta = 1
        )
        listaPreguntas.add(pregunta16)

        val pregunta17 = Pregunta(
            17,
            encabezado = "¿En qué año Sony realizo el lanzamiento del Walkman?",
            opcionUno = "1975",
            opcionDos = "1971",
            opcionTres = "1979",
            opcionCuatro = "1977",
            respuestaCorrecta = 3
        )
        listaPreguntas.add(pregunta17)

        val pregunta18 = Pregunta(
            18,
            encabezado = "¿En qué año sucedió la caída del muro de Berlín?",
            opcionUno = "1981",
            opcionDos = "1985",
            opcionTres = "1987",
            opcionCuatro = "1989",
            respuestaCorrecta = 4
        )
        listaPreguntas.add(pregunta18)

        val pregunta19 = Pregunta(
            19,
            encabezado = "¿En qué año se identificó el VIH?",
            opcionUno = "1983",
            opcionDos = "1985",
            opcionTres = "1987",
            opcionCuatro = "1989",
            respuestaCorrecta = 1
        )
        listaPreguntas.add(pregunta19)

        val pregunta20 = Pregunta(
            20,
            encabezado = "¿En qué año ocurrió el atentado contra el papa Juan Pablo II?",
            opcionUno = "1985",
            opcionDos = "1981",
            opcionTres = "1983",
            opcionCuatro = "1987",
            respuestaCorrecta = 2
        )
        listaPreguntas.add(pregunta20)

        val pregunta21 = Pregunta(
            21,
            encabezado = "¿En qué año IBM lanzo el primer computador personal?",
            opcionUno = "1987",
            opcionDos = "1989",
            opcionTres = "1981",
            opcionCuatro = "1983",
            respuestaCorrecta = 3
        )
        listaPreguntas.add(pregunta21)

        val pregunta22 = Pregunta(
            22,
            encabezado = "¿Cómo se llamaba el transbordador espacial que exploto en el aire en 1986?",
            opcionUno = "Apolo 11",
            opcionDos = "Frontiers",
            opcionTres = "Apolo 3",
            opcionCuatro = "Challenger",
            respuestaCorrecta = 4
        )
        listaPreguntas.add(pregunta22)

        val pregunta23 = Pregunta(
            23,
            encabezado = "¿En qué año ocurrió el desastre nuclear de Chernobyl?",
            opcionUno = "1986",
            opcionDos = "1988",
            opcionTres = "1981",
            opcionCuatro = "1985",
            respuestaCorrecta = 1
        )
        listaPreguntas.add(pregunta23)

        val pregunta24 = Pregunta(
            24,
            encabezado = "¿Qué colombiano Gano el premio Nobel de Literatura en 1982?",
            opcionUno = "Rafel Pombo",
            opcionDos = "Laura Restrepo",
            opcionTres = "Santiago Gamboa",
            opcionCuatro = "Gabriel García Márquez",
            respuestaCorrecta = 4
        )
        listaPreguntas.add(pregunta24)

        val pregunta25 = Pregunta(
            25,
            encabezado = "¿Qué colombiano Gano el premio Nobel de Literatura en 1982?",
            opcionUno = "Rafel Pombo",
            opcionDos = "Laura Restrepo",
            opcionTres = "Santiago Gamboa",
            opcionCuatro = "Gabriel García Márquez",
            respuestaCorrecta = 4
        )
        listaPreguntas.add(pregunta25)

        val pregunta26 = Pregunta(
            26,
            encabezado = "¿En qué año sucedió la tragedia de Armero en Colombia?",
            opcionUno = "1985",
            opcionDos = "1987",
            opcionTres = "1982",
            opcionCuatro = "1989",
            respuestaCorrecta = 1
        )
        listaPreguntas.add(pregunta26)

        val pregunta27 = Pregunta(
            27,
            encabezado = "¿En qué año sucedió el asalto al palacio de justifica de Colombia?",
            opcionUno = "1982",
            opcionDos = "1985",
            opcionTres = "1987",
            opcionCuatro = "1989",
            respuestaCorrecta = 2
        )
        listaPreguntas.add(pregunta27)

        val pregunta28 = Pregunta(
            28,
            encabezado = "¿En qué año la World Wide Web fue expuesta al público de manera masiva?",
            opcionUno = "1993",
            opcionDos = "1995",
            opcionTres = "1991",
            opcionCuatro = "1997",
            respuestaCorrecta = 3
        )
        listaPreguntas.add(pregunta28)

        val pregunta29 = Pregunta(
            29,
            encabezado = "¿En qué año ocurrió la disolución de la Unión Soviética?",
            opcionUno = "1997",
            opcionDos = "1995",
            opcionTres = "1993",
            opcionCuatro = "1991",
            respuestaCorrecta = 4
        )
        listaPreguntas.add(pregunta29)

        val pregunta30 = Pregunta(
            30,
            encabezado = "¿En qué año Nelson Mandela fue nombrado presidente de Sudáfrica?",
            opcionUno = "1994",
            opcionDos = "1992",
            opcionTres = "1996",
            opcionCuatro = "1998",
            respuestaCorrecta = 1
        )
        listaPreguntas.add(pregunta30)

        val pregunta31 = Pregunta(
            31,
            encabezado = "¿Cuál fue el primer mamífero clonado a partir de una célula adulta?",
            opcionUno = "El ratón Pérez",
            opcionDos = "La oveja Dolly",
            opcionTres = "El gato Tom",
            opcionCuatro = "El bulldog ingles",
            respuestaCorrecta = 2
        )
        listaPreguntas.add(pregunta31)

        val pregunta32 = Pregunta(
            32,
            encabezado = "¿En 1994 Nelson Mandela fue elegido presidente de qué país?",
            opcionUno = "Haití",
            opcionDos = "Marruecos",
            opcionTres = "Sudáfrica",
            opcionCuatro = "Nigeria",
            respuestaCorrecta = 3
        )
        listaPreguntas.add(pregunta32)

        val pregunta33 = Pregunta(
            33,
            encabezado = "La Constituyente de 1991 de Colombia ¿durante que gobierno fue establecida?",
            opcionUno = "Gobierno de Virgilio Barco Vargas",
            opcionDos = "Gobierno de César Gaviria Trujillo",
            opcionTres = "Gobierno de Belisario Betancur Cuartas",
            opcionCuatro = "Gobierno de Ernesto Samper Pizano",
            respuestaCorrecta = 2
        )
        listaPreguntas.add(pregunta33)

        val pregunta34 = Pregunta(
            34,
            encabezado = "¿En qué año fue por fin abatido el narcotraficante Pablo Escobar?",
            opcionUno = "1997",
            opcionDos = "1995",
            opcionTres = "1993",
            opcionCuatro = "1991",
            respuestaCorrecta = 3
        )
        listaPreguntas.add(pregunta34)

        val pregunta35 = Pregunta(
            35,
            encabezado = "¿En qué año ocurrieron los atentados del 11 de septiembre en Estados Unidos?",
            opcionUno = "2009",
            opcionDos = "2001",
            opcionTres = "2004",
            opcionCuatro = "2007",
            respuestaCorrecta = 2
        )
        listaPreguntas.add(pregunta35)

        val pregunta36 = Pregunta(
            36,
            encabezado = "¿En qué año murió el papa Juan Pablo II?",
            opcionUno = "2001",
            opcionDos = "2003",
            opcionTres = "2005",
            opcionCuatro = "2009",
            respuestaCorrecta = 3
        )
        listaPreguntas.add(pregunta36)

        val pregunta37 = Pregunta(
            37,
            encabezado = "¿En qué año una persona recibió un trasplante de corazón artificial permanente?",
            opcionUno = "2009",
            opcionDos = "2006",
            opcionTres = "2003",
            opcionCuatro = "2000",
            respuestaCorrecta = 4
        )
        listaPreguntas.add(pregunta37)

        val pregunta38 = Pregunta(
            38,
            encabezado = "¿Quién fue el primer presidente afroamericano de los Estados Unidos?",
            opcionUno = "Barack Obama",
            opcionDos = "Nelson Mandela",
            opcionTres = "Nieto Gil",
            opcionCuatro = "Ninguna opción es correcta",
            respuestaCorrecta = 1
        )
        listaPreguntas.add(pregunta38)

        val pregunta39 = Pregunta(
            39,
            encabezado = "¿En qué año confirman la presencia de agua en Marte?",
            opcionUno = "2002",
            opcionDos = "2008",
            opcionTres = "2003",
            opcionCuatro = "No se ha detectado agua en marte",
            respuestaCorrecta = 2
        )
        listaPreguntas.add(pregunta39)

        val pregunta40 = Pregunta(
            40,
            encabezado = "¿Quiénes realizaron la falsa predicción del mundo del 2012?",
            opcionUno = "Aztecas",
            opcionDos = "Chibchas",
            opcionTres = "Mayas",
            opcionCuatro = "Ninguna de las opciones es correcta",
            respuestaCorrecta = 3
        )
        listaPreguntas.add(pregunta40)

        val pregunta41 = Pregunta(
            41,
            encabezado = "¿En qué año inicio la pandemia del COVID?",
            opcionUno = "2021",
            opcionDos = "2020",
            opcionTres = "2018",
            opcionCuatro = "2019",
            respuestaCorrecta = 4
        )
        listaPreguntas.add(pregunta41)

        val pregunta42 = Pregunta(
            42,
            encabezado = "¿En qué año ocurrió el gran terremoto de Haití que dejo su capital bajo los escombros?",
            opcionUno = "2010",
            opcionDos = "2014",
            opcionTres = "2016",
            opcionCuatro = "2012",
            respuestaCorrecta = 1
        )
        listaPreguntas.add(pregunta42)

        val pregunta43 = Pregunta(
            43,
            encabezado = "¿En qué año ocurrió el terremoto y tsunami en Japón?",
            opcionUno = "2015",
            opcionDos = "2011",
            opcionTres = "2013",
            opcionCuatro = "2017",
            respuestaCorrecta = 2
        )
        listaPreguntas.add(pregunta43)

        val pregunta44 = Pregunta(
            44,
            encabezado = "¿En qué año fue puesto a cargo el primer papa latinoamericano?",
            opcionUno = "2010",
            opcionDos = "2015",
            opcionTres = "2013",
            opcionCuatro = "2017",
            respuestaCorrecta = 3
        )
        listaPreguntas.add(pregunta44)

        val pregunta45 = Pregunta(
            45,
            encabezado = "¿En qué año un grupo de terroristas yihadistas armados con armas automáticas y cinturones explosivos atacaron varios objetivos en los alrededores de París de forma coordinada?",
            opcionUno = "2011",
            opcionDos = "2019",
            opcionTres = "2017",
            opcionCuatro = "2015",
            respuestaCorrecta = 4
        )
        listaPreguntas.add(pregunta45)

        val pregunta46 = Pregunta(
            46,
            encabezado = "¿En qué año se firmó la Paz entre el gobierno colombiano y las FARC?",
            opcionUno = "2016",
            opcionDos = "2012",
            opcionTres = "2018",
            opcionCuatro = "2010",
            respuestaCorrecta = 1
        )
        listaPreguntas.add(pregunta46)

        val pregunta47 = Pregunta(
            47,
            encabezado = "¿En qué año se iniciaron los diálogos de Paz entre el gobierno colombiano y las FARC en la Habana, Cuba?",
            opcionUno = "2010",
            opcionDos = "2012",
            opcionTres = "2014",
            opcionCuatro = "2016",
            respuestaCorrecta = 2
        )
        listaPreguntas.add(pregunta47)

        // Luego las reordena de forma random, cosa de que todas las partidas tengan un orden diferente.
        // listaPreguntas.shuffle()
        return listaPreguntas
    }

}

