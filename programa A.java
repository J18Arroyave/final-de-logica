import  org.fusesource.jansi.AnsiConsole ;
importar  org.fusesource.jansi.Ansi. * estático ;
importar  org.fusesource.jansi.Ansi.Color. * estático ;
import  java.util.Random ;


 Programa de clase  pública {

    public  static  String  convertirUnicode ( String  letra , String  cadena ) {
        
        StringBuilder str =  new  StringBuilder (cadena);
        int indice =  - 1 ;
        char caracter =  0 ;
        índice = str . lastIndexOf (letra);
        
        si (índice > = 0 )
        {
            switch (letra) {
                caso  " á " : caracter =  ' \ u 00E1 ' ;
                          romper ;
                caso  " é " : caracter =  ' \ u 00E9 ' ;
                          romper ;
                caso  " í " : caracter =  ' \ u 00ED ' ;
                          romper ;
                caso  " ó " : caracter =  ' \ u 00F3 ' ;
                          romper ;
                case  " ú " : caracter =  ' \ u 00FA ' ;
                          romper ;
                caso  " ñ " : caracter =  ' \ u 00F1 ' ;
                          romper ;
            }
            // System.out.println ("\\ u" + Integer.toHexString ('÷' | 0x10000) .substring (1));
            str . reemplazar (índice, índice + 2 , " " + carácter );
        }

        return str . Encadenar();
    }

    public  static  void  imprimir ( String  cadena )
    {
        String str;
        str = convertirUnicode ( " á " , cadena);
        str = convertirUnicode ( " é " , str);
        str = convertirUnicode ( " í " , str);
        str = convertirUnicode ( " ó " , str);
        str = convertirUnicode ( " ú " , str);
        str = convertirUnicode ( " ñ " , str);

        Sistema . fuera . println (str);
    }

    public  static  StringBuilder  obtenerLetraCancion ( int  inicio , int  fin , String [] data )
    {
        StringBuilder str =  new  StringBuilder ();

        para ( int i = inicio; i <= fin; i ++ )
        {
            str . añadir (datos [i] + " \ n " );
        }

        return str;
    }

	public  static  void  main ( String [] args ) {
		Sistema . fuera . println ( "  .____ .__ __  " );
		Sistema . fuera . println ( " | | | __ | _______ / | _ ____ ____ _____ ____  " );
		Sistema . fuera . println ( " | | | | / ___ / \ __ \ / __ \ / \ / \ _ / __ \   " );
		Sistema . fuera . println ( " | | ___ | | \ ___ \ | | \ ___ / | | \ | YY \ ___ /   " );
        Sistema . fuera . println ( " | _______ \ __ / ____> | __ | \ ___> ___ | / | __ | _ | / \ ___>  " );
        Sistema . fuera . println ( "         \ / \ / \ / \ / \ / \ /    " );


		AnsiConsole . systemInstall ();
    	Audio audio =  nuevo  Audio ();
        Random randomGenerator =  new  Random ();
    	int centinela =  0 ;
        int indice_cancion =  0 ;
        int inicio_letra =  0 , fin_letra =  0 ;
		Rand aleatorio =  nuevo  Random ();
		int randomcancion;
        int randomInt = randomGenerator . nextInt ( 300 ) +  1 ;
    	String [] canciones =  ConsoleFile . read ( " recursos / letras.csv " );
    	String [] [] info_canciones =  ConsoleData . dataList (canciones);
        StringBuilder letra_cancion;
        // para (int f = 0; f <info_canciones.length; f ++) {
        //     para (int i = 0; i <8; i ++) {
        //         System.out.print (info_canciones [f] [i] + "");
        //    }
        //     System.out.println ("");
        // }
        

        Sistema . fuera . println ( " ¡Hola! Bienvenido a GuessTheSong, estas son las opciones de juego: " );
        Sistema . fuera . println ( " 1. Presione 1 para iniciar el juego, sonara una cancion aleatoria, intenta adivinar cual es y digita su nombre. " );
        Sistema . fuera . println ( " 2. Detener cancion. " );
        Sistema . fuera . println ( " 3. En caso de apoyo, presione 2 para ver un fragmento de la letra, en caso de adivinar la cancion ingrese su nombre. " );
        Sistema . fuera . println ( " 3. Imprima las letras de las canciones. " );
        Sistema . fuera . println ( " 4. Salir del juego. " );
        centinela =  ConsoleInput . getInt ();
	hacer {

    	si (centinela == 1 )
    	{ 
            randomcancion = rand . nextInt ( 14 ) + 1 ;
			Sistema . fuera . println ( " El numero aleatorio es: "  + randomcancion);
            audio . seleccionarCancion (info_canciones [randomcancion] [ ConsoleData . RUTA_CANCION ]);
    		audio . reproducir ();	
    	}
        si (centinela ==  3 )
                {
                    imprimir ( " Ingrese indice de la cancion, entre 0 y " + (info_canciones . longitud - 1 ));
                    indice_cancion =  ConsoleInput . getInt ();

                    inicio_letra =  ConsoleInput . stringToInt (info_canciones [indice_cancion] [ ConsoleData . INICIO_CANCION ]);
                    fin_letra =  ConsoleInput . stringToInt (info_canciones [indice_cancion] [ ConsoleData . FIN_CANCION ]);
                    
                    letra_cancion = obtenerLetraCancion (inicio_letra, fin_letra, canciones);


                    imprimir (letra_cancion . toString () . replace ( " ; " , "  " ) . substring ( 0 , randomInt));
                }



        Sistema . fuera . println ( " ¡Hola! Bienvenido a GuessTheSong, estas son las opciones de juego: " );
        Sistema . fuera . println ( " 1. Presione 1 para iniciar el juego, sonara una cancion aleatoria, intenta adivinar cual es y digita su nombre. " );
        Sistema . fuera . println ( " 2. Detener cancion. " );
        Sistema . fuera . println ( " 3. En caso de apoyo, presione 2 para ver un fragmento de la letra, en caso de adivinar la cancion ingrese su nombre. " );
        Sistema . fuera . println ( " 3. Imprima las letras de las canciones. " );
        Sistema . fuera . println ( " 4. Salir del juego. " );
        centinela =  ConsoleInput . getInt ();		
    } mientras (centinela ! = 4 );
}
}