package practica_1;

import java.util.Scanner;
import java.util.Random;

public class Practica_1 {
    public static int[][] matriz1 = {{2, 4, 6, 8, 10}, {12, 14, 16, 18, 20}, {22, 24, 26, 28, 30}, {32, 34, 36, 38, 40}, {42, 44, 46, 48, 50}};
    public static int[][] matriz2 = {{10, 8, 6, 4, 2}, {20, 18, 16, 14, 12}, {30, 28, 26, 24, 22}, {40, 38, 36, 34, 32}, {50, 48, 46, 44, 42}};
    
    public static void main(String[] args) {
        
        
        Scanner scanner = new Scanner(System.in);
        
        
        int fila=8;
        int columna=8;
        boolean[][] tablaCompara = casillasConCastigo(fila,columna);
        int EleccionMenu=menu();
        String[][] tabla = new String[fila][columna];
        int posicionJugador =1;
        String[][] tablaMatrizR;
        
        
        //Matrices que usaremos en los problemas
        int[][] matrizD1 = {{2, 3, 5, 7, 11}, {13, 17, 19, 23, 29}, {31, 37, 41, 43, 47}, {53, 59, 61, 67, 71}, {73, 79, 83, 89, 97}};
        int[][] matrizD2 = {{11, 7, 5, 3, 2}, {29, 23, 19, 17, 13}, {47, 43, 41, 37, 31}, {71, 67, 61, 59, 53}, {97, 89, 83, 79, 73}};

        int[][] matrizD3 = {{1, 1, 1, 1, 1}, {2, 2, 2, 2, 2}, {3, 3, 3, 3, 3}, {4, 4, 4, 4, 4}, {5, 5, 5, 5, 5}};
        int[][] matrizD4 = {{0, 0, 0, 0, 0}, {1, 1, 1, 1, 1}, {2, 2, 2, 2, 2}, {3, 3, 3, 3, 3}, {4, 4, 4, 4, 4}};
               

        while(EleccionMenu!=4){
            
            if(EleccionMenu==2){
                System.out.println("\nNo hay partida en curso\n");
                EleccionMenu=menu();
            }
            
            if (EleccionMenu==3){
                System.out.println("\nDaniel Hernandez");
                System.out.println("202300512");
                System.out.println("Seccion E\n");
                
                
                EleccionMenu=menu();
            }
            if(EleccionMenu==1){
                tabla=modificarTabla(posicionJugador,tablaCompara,tabla);


                imprimirTabla(tabla);
                
                String tirarDado;
                boolean ciclo=true;
                while(ciclo){
                    System.out.println("Presiona 'd' para tirar el dado o 'p' para poner pausa ");
                    tirarDado= scanner.nextLine();

                    if(tirarDado.equalsIgnoreCase("d")){

                        posicionJugador=posicionJugador+dado();
                        tabla=modificarTabla(posicionJugador,tablaCompara,tabla);

                        imprimirTabla(tabla);
                        if(posicionJugador>64){
                            System.out.println("\nFIN DEL JUEGO\nHAZ GANADO\n");
                            ciclo=false;
                        }
                        
                    }
                    if(tirarDado.equalsIgnoreCase("p")){
                        boolean Submenu=true;
                        do{
                            System.out.println("================");
                            System.out.println("=     MENU     =");
                            System.out.println("================");
                            System.out.println("1. Iniciar Juego");
                            System.out.println("2. Retomar Juego");
                            System.out.println("3. Mostrar informacion del estudiante");
                            System.out.println("4. Salir");
                            int EleccionSubMenu = scanner.nextInt();
                            if(EleccionSubMenu==1){
                                System.out.println("\nPartida en Curso, no puedes realizar esta accion\n");
                            }
                            if(EleccionSubMenu==2){
                                Submenu=false;
                                imprimirTabla(tabla);
                            }

                            if(EleccionSubMenu==3){
                                System.out.println("\nDaniel Hernandez");
                                System.out.println("202300512");
                                System.out.println("Seccion E\n");                           
                            }
                            if(EleccionSubMenu==4){
                                System.out.println("\nBye Bye");
                                return;                       
                            }
                            
                            
                        }
                        while(Submenu);     
                        
                    }

                }
                
                EleccionMenu=menu();
                     
            }
          
        }    
           
    }
    
    public static int menu(){
		Scanner input = new Scanner(System.in);
		String opString = ""; //Opción sin validar
		boolean bueno = false;
		int opcion = 0; //opcion para validar

		while (!bueno){
			System.out.println("--------------------------------");
			System.out.println("Menú");
			System.out.println("1. Iniciar Juego");
			System.out.println("2. Retotmar Juego");
			System.out.println("3. Mostrar Inforamción del jugador");
			System.out.println("4. Salir");
			System.out.println("\nSeleccione la opción que desea: ");
			opString = input.nextLine();
			try{
				opcion = Integer.parseInt(opString);
				if (opcion<1 || opcion>4) //Debe ser una opción válida
					System.out.println("Debe ingresar una de las opciones del menú");
				else
					bueno = true;
			}
			catch(Exception e){
				System.out.println("Debe ingresar un número entero\n");
			}
		}
		return opcion;
	}



    
    
    
    
    public static String[][] modificarTabla( int posicionJugador, boolean[][] tablaCompara, String[][] tabla){
        int fila=tabla.length;
        int columna=tabla[0].length;
        int[][] coordenadas=coordenadasJugador(posicionJugador, fila,columna);
        int x= coordenadas[0][1];
        int y= coordenadas[0][0];
        


        // Llenar la tabla con números secuenciales del 1 al 64
        int contador = 1;
        String texto="";
        
        for (int i = 0; i <fila ; i++) {
                     
            // Si la fila es par, llenar de derecha a izquierda
            if (i % 2 == 0) {
                
                for (int j =columna-1; j>=0; j--) {
                    boolean castigo=tablaCompara[i][j];
  
                    if(j==x && y==i){
                         texto= jugador(contador,castigo,true, tabla);
                        
                    }
                    else{
                        texto= jugador(contador,castigo,false, tabla);
                    }
                    
                    tabla[i][j] = texto;
                    contador++;
                }
            } else {
                // Si la fila es impar, llenar de izquierda a derecha
                for (int j = 0; j <columna; j++) {
                    boolean castigo=tablaCompara[i][j];
                    if(j==x && y==i){
                         texto= jugador(contador,castigo,true, tabla);
                    }
                    else{
                         texto= jugador(contador,castigo,false, tabla);
                    }
                    
                    tabla[i][j] = texto;
                    contador++;
                    
                }
            }
        }
        
      return tabla;  
    }
    
    public static String jugador(int correlativo, boolean penalizacion, boolean estar, String[][] tabla ){
        String casilla="";   
        if (penalizacion && estar) {
            casilla += "# " + Integer.toString(correlativo) + " @";

            System.out.print("\nHaz Caido en una Penalizacion\n");
            imprimirTabla(tabla);
            mostrarPenalizaciones();
               
            
        } else if (penalizacion && !estar) {
            casilla += "# " + Integer.toString(correlativo) + "  ";
        } else if (!penalizacion && estar) {
            casilla += "  " + Integer.toString(correlativo) + " @";
        } else {
            casilla += "  " + Integer.toString(correlativo) + "  ";
        }
        
        return casilla;
    }
    
    public static boolean[][] casillasConCastigo (int fila,int columna){
        boolean[][] tablaBoolean = new boolean[fila][columna];
        Random random = new Random();
        int numCastigos;
        int posCastigos;

        for (int i = 0; i < fila; i++) {
            numCastigos=random.nextInt(3)+2;

            int[] numUsados=new int[4];

            for (int j = 0; j < numCastigos; j++) {
                posCastigos=random.nextInt(columna);
                int k=0;
                while (k<numCastigos) {
                    if(numUsados[k]==posCastigos){
                        posCastigos=random.nextInt(columna);
                    }
                    else{
                        k++;
                    }
                }
                tablaBoolean[i][posCastigos]=true;
                numUsados[j]=posCastigos;


            }

        }
        return tablaBoolean;
    }
    
    
    public static void imprimirTabla(String[][] tabla){
        for (int i = tabla.length-1; i >=0; i--) {
            for (int j = 0; j < tabla[i].length; j++) {
                System.out.print("|\t" + tabla[i][j]+"\t|");
            }
            System.out.println("\n_________________________________________________________________________________________________________________________________"); 
            
        }
    }
    
    public static int[][] coordenadasJugador(int correlativo, int filas, int columnas){

        correlativo--;
        int coordenadas[][] = new int[1][2];
        coordenadas[0][0] = correlativo / filas;

        if (filas % 2 == 1) {
            coordenadas[0][1] = (correlativo % columnas);
        } else {
            if (coordenadas[0][0] % 2 == 0) {
                coordenadas[0][1] = columnas - 1 - (correlativo % columnas);
            } else {
                coordenadas[0][1] = (correlativo % columnas);
            }
        }

    return coordenadas;
}
    public static int dado(){
        Random random = new Random();
        int numDado=random.nextInt(5)+2;
        
        return numDado;
    }
    

    
    public static void imprimirMatrizProblemas(int[][] matriz) {
        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz[0].length; j++) {
                System.out.print(matriz[i][j] + "\t");
            }
            System.out.println();
        }
    }
    
    public static int[][] sumarMatricesAB() {
        int[][] matriz1 = {{7, 48, 5, 0, 1}, {57, 8, 4, 6, 14}, {11, 12, 13, 14, 15}, {16, 17, 18, 19, 20}, {21, 22, 23, 24, 25}};
        int[][] matriz2 = {{5, 4, 3, 2, 1}, {10, 9, 8, 7, 6}, {15, 14, 13, 12, 11}, {20, 19, 18, 17, 16}, {25, 24, 23, 22, 21}};
        int filas = matriz1.length;
        int columnas = matriz1[0].length;
        int[][] resultado = new int[filas][columnas];
        
        for (int i = 0; i < filas; i++) {
            for (int j = 0; j < columnas; j++) {
                resultado[i][j] = matriz1[i][j] + matriz2[i][j];
            }
        }
        
        return resultado;
    }
    
    public static int[][] sumarMatricesCD() {
        int[][] matriz1 = {{7, 48, 5, 0, 1}, {57, 8, 4, 6, 14}, {11, 12, 13, 14, 15}, {16, 17, 18, 19, 20}, {21, 22, 23, 24, 25}};
        int[][] matriz2 = {{5, 4, 3, 2, 1}, {10, 9, 8, 7, 6}, {15, 14, 13, 12, 11}, {20, 19, 18, 17, 16}, {25, 24, 23, 22, 21}};
        int filas = matriz1.length;
        int columnas = matriz1[0].length;
        int[][] resultado = new int[filas][columnas];
        
        for (int i = 0; i < filas; i++) {
            for (int j = 0; j < columnas; j++) {
                resultado[i][j] = matriz1[i][j] + matriz2[i][j];
            }
        }
        
        return resultado;
    }
    
    public static int[][] sumarMatricesEF() {
        int[][] matriz1 = {{2, 4, 6, 8, 10}, {12, 14, 16, 18, 20}, {22, 24, 26, 28, 30}, {32, 34, 36, 38, 40}, {42, 44, 46, 48, 50}};
        int[][] matriz2 = {{10, 8, 6, 4, 2}, {20, 18, 16, 14, 12}, {30, 28, 26, 24, 22}, {40, 38, 36, 34, 32}, {50, 48, 46, 44, 42}};
        int filas = matriz1.length;
        int columnas = matriz1[0].length;
        int[][] resultado = new int[filas][columnas];
        
        for (int i = 0; i < filas; i++) {
            for (int j = 0; j < columnas; j++) {
                resultado[i][j] = matriz1[i][j] + matriz2[i][j];
            }
        }
        
        return resultado;
    }
    
    public static boolean mostrarPenalizaciones(){
        int[][] matriz=ingresarDatosMatriz(5,5);
        System.out.print("\nHaz caido en una Penalización\nResuelve la siguiente operacion\n");
        System.out.print("\nSuma las siguientes Matrices\n");
        imprimirMatrizProblemas(matriz1);
        imprimirMatrizProblemas(matriz2);
        System.out.print("\nTu resultado es: \n"+matriz);
        if(matriz==sumarMatricesAB()){
            System.out.print("\nFelicidades lo haz logrado\n");
            imprimirMatrizProblemas(sumarMatricesAB());
            
            return true;
            
        }
        else{
            System.out.print("\nHaz perdido\n");
            return false;
        }
        
                
    }
    
    public static int[][] ingresarDatosMatriz(int filas, int columnas) {
        Scanner scanner = new Scanner(System.in);
        int[][] matriz = new int[filas][columnas];

        System.out.println("Ingrese los datos para la matriz de " + filas + "x" + columnas + ":");

        for (int i = 0; i < filas; i++) {
            for (int j = 0; j < columnas; j++) {
                System.out.print("Ingrese el valor para la posición [" + i + "][" + j + "]: ");
                matriz[i][j] = scanner.nextInt();
            }
        }

        return matriz;
    }
    
    
       
}
    
