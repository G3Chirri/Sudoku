/**
 * ANDRES FELIPE GOMEZ PARRA
 * SUDOKU
 * Explicacion del codigo
 * Este código es una implementación del juego Sudoku en Java. A continuación, te explicaré el código línea por línea:
 *
 * Se inicia la declaración del programa con un comentario que indica el autor y el título del programa.
 * 3-9. Se importan las bibliotecas necesarias para el programa, incluyendo las clases de entrada y salida estándar, manipulación de archivos, manipulación de matrices y operaciones matemáticas.
 *
 * Se define la clase principal del programa llamada "Sudoku".
 *
 * Se declara una variable estática llamada "nivel" y se inicializa con el valor 1.
 *
 * 16-62. Se define un método llamado "cargar_juego" que genera y devuelve una matriz de números para el juego de Sudoku, dependiendo del nivel especificado como parámetro. El método utiliza una estructura switch-case para determinar el nivel y asignar los valores correspondientes a la matriz.
 *
 * 64-70. Se define un método llamado "es_origen" que verifica si una celda en la matriz del juego es un valor original (predefinido) o si ha sido modificado por el usuario.
 *
 * 72-85. Se define un método llamado "terminado" que verifica si el juego ha sido completado correctamente, es decir, si no hay celdas vacías en la matriz.
 *
 * 87-116. Se define un método llamado "mensaje" que imprime un mensaje formateado en la consola. Este método se utiliza para mostrar información al usuario de una manera estilizada.
 *
 * 118-172. Se define un método llamado "imprime_vector" que imprime la matriz del juego en la consola en forma de cuadrícula. También muestra los caracteres "ù" en las celdas que son valores originales.
 *
 * 174-194. Se define un método llamado "existe_fila" que verifica si un número dado existe en la fila especificada de la matriz.
 *
 * 196-221. Se define un método llamado "existe_columna" que verifica si un número dado existe en la columna especificada de la matriz.
 *
 * 223-233. Se define un método llamado "comprobar_indice" que verifica si un número dado existe en el rango válido de índices de fila o columna en la matriz.
 *
 * 235-245. Se define un método llamado "comprobar_valor" que verifica si un número dado está en el rango válido de valores permitidos en el juego.
 *
 * 247-297. Se define un método llamado "existe_caja" que verifica si un valor dado existe en la caja correspondiente a la fila y columna especificadas en la matriz.
 *
 * 299-448. Se define el método principal "main" que es el punto de entrada del programa. El método utiliza un bucle infinito para permitir al usuario ingresar valores y actualizar la matriz del juego. También muestra mensajes al usuario según el resultado de las validaciones. El bucle se repite hasta que el juego esté completado correctamente.
 *
 * Al final del programa, se incrementa el nivel del juego cuando se completa exitosamente y se carga una nueva matriz para el siguiente nivel.
 *
 * Esta es una explicación general del código. Cada método cumple una función específica para el funcionamiento del juego de Sudoku.
 */

//bibliotecas necesarias para el programa
import java.io.*;
import java.util.*;
import java.lang.*;
import java.math.*;

public class Sudoku {

    public static int nivel = 1;


    public static int[][] cargar_juego(int nivel) {
//Se encarga de generar y devolver una matriz de números para el juego de Sudoku, dependiendo del nivel especificado como parámetro.
        int[][] matriz = new int[9][9];

        switch (nivel) {

            case 2:

                matriz[0][0] = 7;
                matriz[0][4] = 5;
                matriz[0][6] = 4;
                matriz[1][0] = 4;
                matriz[1][3] = 1;
                matriz[1][4] = 9;
                matriz[1][6] = 6;
                matriz[1][7] = 2;
                matriz[1][8] = 7;
                matriz[2][2] = 6;
                matriz[2][8] = 9;
                matriz[3][0] = 9;
                matriz[3][2] = 3;
                matriz[3][6] = 8;
                matriz[4][3] = 4;
                matriz[4][5] = 3;
                matriz[5][2] = 8;
                matriz[5][6] = 5;
                matriz[5][8] = 2;
                matriz[6][0] = 5;
                matriz[6][6] = 2;
                matriz[7][0] = 2;
                matriz[7][1] = 9;
                matriz[7][2] = 1;
                matriz[7][4] = 4;
                matriz[7][5] = 7;
                matriz[7][8] = 8;
                matriz[8][2] = 7;
                matriz[8][4] = 1;
                matriz[8][8] = 5;

                break;


            case 1:
            default:

                matriz[0][2] = 9;
                matriz[0][5] = 8;
                matriz[0][6] = 5;
                matriz[0][7] = 4;
                matriz[1][8] = 7;
                matriz[2][1] = 5;
                matriz[2][2] = 4;
                matriz[2][4] = 9;
                matriz[2][6] = 1;
                matriz[3][5] = 6;
                matriz[3][6] = 3;
                matriz[3][7] = 2;
                matriz[4][1] = 8;
                matriz[4][2] = 2;
                matriz[4][6] = 4;
                matriz[4][7] = 1;
                matriz[5][1] = 3;
                matriz[5][2] = 5;
                matriz[5][3] = 2;
                matriz[6][2] = 7;
                matriz[6][4] = 3;
                matriz[6][6] = 2;
                matriz[6][7] = 5;
                matriz[7][0] = 9;
                matriz[8][1] = 4;
                matriz[8][2] = 3;
                matriz[8][3] = 8;
                matriz[8][7] = 9;

                break;

        }

        return matriz;
    }


    public static boolean es_origen(int fila, int columna, int[][] matriz) {
//verifica si una celda en la matriz del juego es un valor original (predefinido) o si ha sido modificado por el usuario.
        boolean resultado = false;
        if (matriz[fila][columna] != 0) {
            resultado = true;
        }

        return resultado;

    }


    public static boolean terminado(int[][] matriz) {
//verifica si el juego ha sido completado correctamente, es decir, si no hay celdas vacías en la matriz.
        boolean resultado = true;

        for (int f = 0; f < matriz.length; f++) {
            for (int c = 0; c < matriz[0].length; c++) {
                if (matriz[f][c] == 0) {
                    resultado = false;
                }
            }
        }


        return resultado;

    }

    public static void mensaje(String mensaje) {
//Imprime la forma de la matriz
        //CABECERA.
        System.out.print("É");
        for (int i = 0; i < (mensaje.length() + 20); i++) {
            System.out.print("Í");
        }
        System.out.print("»\n");

        //CUERPO.
        System.out.print("º          ");
        System.out.print(mensaje);
        System.out.print("          º\n");

        //PIE
        System.out.print("È");
        for (int i = 0; i < (mensaje.length() + 20); i++) {
            System.out.print("Í");
        }

        System.out.print("¼\n\n");


    }

    //METODO QUE IMPRIME EL VECTOR.
    public static void imprime_vector(int[][] matriz) {
//verifica si un número dado existe en la fila especificada de la matriz.

        System.out.println(" °°°°°°°°°°°°²°°°°°°°°°°°²°°°°°°°°°°°° ");

        for (int f = 0; f < matriz.length; f++) {

            System.out.print(" ° ");

            for (int c = 0; c < matriz.length; c++) {

                if (matriz[f][c] != 0) {
                    System.out.print(matriz[f][c]);
                } else {
                    System.out.print(" ");
                }

                if (es_origen(f, c, cargar_juego(nivel))) {
                    System.out.print("ù");
                } else {
                    System.out.print(" ");
                }

                if (c == 2 || c == 5) {
                    System.out.print("² ");
                } else {
                    System.out.print("° ");
                }

            }
            System.out.println();
            if (f != 2 && f != 5) {
                System.out.print(" °°°°°°°°°°°°²°°°°°°°°°°°²°°°°°°°°°°°° ");
            } else {
                System.out.print(" ²²²²²²²²²²²²²²²²²²²²²²²²²²²²²²²²²²²²² ");
            }
            System.out.println();
        }
    }

    //METODO PARA COMPROBAR FILAS.
    public static boolean existe_fila(int numero, int fila, int[][] matriz) {
//Mira si el numero que metimos si es un numero de fila
        boolean resultado = false;

        for (int i = 0; i < matriz.length; i++) {
            if (matriz[(fila - 1)][i] == numero) {
                resultado = true;
                break;
            }
        }
        return resultado;

    }

    //METODO PARA COMPROBAR COLUMNAS.
    public static boolean existe_columna(int numero, int columna, int[][] matriz) {
//Mira si el numero que metimos si es un numero de columna
        boolean resultado = false;

        for (int i = 0; i < matriz.length; i++) {
            if (matriz[i][(columna - 1)] == numero) {
                resultado = true;
                break;
            }
        }

        //COMPROBAMOS SI ES 0.
        if (numero == 0) {
            resultado = false;
        }

        return resultado;

    }


    public static boolean comprobar_indice(int indice) {
//verifica si un número dado existe en la columna especificada de la matriz.
        if (indice > 0 && indice < 10) {
            return true;
        } else {
            return false;
        }

    }

    // METODO PARA COMPROBAR LOS VALORES.
    public static boolean comprobar_valor(int valor) {
//Comprueba si el numero esta en el rango que necesitamos
        if (valor >= 0 && valor < 10) {
            return true;
        } else {
            return false;
        }

    }

    //METODO PARA COMPROBAR LAS CAJAS.
    public static boolean existe_caja(int valor, int fila, int columna, int[][] matriz) {

        //VARIABLES.
        int minimo_fila;
        int maximo_fila;
        int minimo_columna;
        int maximo_columna;
        boolean resultado = false;

        //DETERMINAMOS LAS FILAS DE LA CAJA.
        if (fila > 0 && fila < 4) {
            minimo_fila = 0;
            maximo_fila = 2;
        } else if (fila > 3 && fila < 7) {
            minimo_fila = 3;
            maximo_fila = 5;
        } else {
            minimo_fila = 6;
            maximo_fila = 8;
        }

        //DETERMINAMOS LAS COLUMNAS DE LA CAJA.
        if (columna > 0 && columna < 4) {
            minimo_columna = 0;
            maximo_columna = 2;
        } else if (columna > 3 && columna < 7) {
            minimo_columna = 3;
            maximo_columna = 5;
        } else {
            minimo_columna = 6;
            maximo_columna = 8;
        }

        //RECORREMOS EL RANGO DE LA CAJA, Y BUSCAMOS EL VALOR.
        for (int f = minimo_fila; f <= maximo_fila; f++) {
            for (int c = minimo_columna; c <= maximo_columna; c++) {
                if (matriz[f][c] == valor) {
                    resultado = true;
                    break;

                }
            }
        }


        //COMPROBAMOS SI ES 0.
        if (valor == 0) {
            resultado = false;
        }

        //REGRESAMOS EL VALOR BOOLEANO.
        return resultado;



    }

    //METODO PRINCIPAL
    public static void main(String[] args) throws Exception {

        //VARIABLES.
        BufferedReader teclado = new BufferedReader(new InputStreamReader(System.in));
        int[][] sudoku = new int[9][9];
        int fila = 0;
        int columna = 0;
        int valor = 0;

        //CARGAMOS EL JUEGO.
        sudoku = cargar_juego(nivel);

        while (true) {

            //IMPRIMIMOS EL VECTOR.
            imprime_vector(sudoku);

            //PEDIMOS LOS DATOS.
            System.out.println("Inserte las coordenadas (fila/columna): ");

            //FILA.
            System.out.print("[fila]: ");
            fila = Integer.parseInt(teclado.readLine());

            //COLUMNA.
            System.out.print("[columna]: ");
            columna = Integer.parseInt(teclado.readLine());

            //VALOR.
            System.out.print("[valor]: ");
            valor = Integer.parseInt(teclado.readLine());

            //COMPROBAMOS LA FILA ESTA EN RANGO.
            if (!comprobar_indice(fila)) {
                mensaje("El valor de la fila no es correcto..");
            } //COMPROBAMOS LA COLUMNA ESTA EN RANGO.


            else if (!comprobar_indice(columna)) {
                mensaje("El valor de la columna no es correcto.");
            } //COMPROBAMOS QUE EL VALOR ESTA EN RANGO.

            else if (!comprobar_valor(valor)) {
                mensaje("El valor introducido no es valido..");
            } //COMPROBAMOS QUE USE CASILLAS DISPONIBLES.

            else if (es_origen((fila - 1), (columna - 1), cargar_juego(nivel))) {
                mensaje("Ese valor es predeterminado del juego...");
            } //COMPRUEBA QUE NO SE REPITA EL VALOR EN LA FILA.

            else if (existe_fila(valor, fila, sudoku)) {
                mensaje("[X] El valor " + valor + " ya ha sido usado en la fila..");
            } //COMPRUEBA QUE NO SE REPITA EL VALOR EN LA COLUMNA..

            else if (existe_columna(valor, columna, sudoku)) {
                mensaje("[X] El valor " + valor + " ya ha sido usado en la columna..");
            } //COMPRUEBA QUE EL VALOR NO ESTÉ EN LA CAJA.

            else if (existe_caja(valor, fila, columna, sudoku)) {
                mensaje("[X] El valor ya existe en la caja..");
            } //INTRODUCIMOS EL VALOR A LA MATRIZ.

            else {
                sudoku[(fila - 1)][(columna - 1)] = valor;
                mensaje("[" + fila + "," + columna + "]=" + valor + " Correcto.");
            }


            //COMPRUEBA SI SE TERMINÓ EL JUEGO.
            if (terminado(sudoku)) {
                mensaje("FELICIDADES!!!! HAS TERMINADO EL JUEGO!!");
                imprime_vector(sudoku);
                System.out.println("Presiona una tecla para continuar en el siguiente nivel..");
                teclado.readLine();

                //AUMENTAMOS EL NIVEL DEL JUEGO.
                nivel++;
                sudoku = cargar_juego(nivel);
                mensaje("SUDOKU NIVEL " + nivel);
            }


        }

    }
}