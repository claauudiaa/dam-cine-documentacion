package objetos;

import java.util.Scanner;

public class Sala {

    private int numSala;
    private Pelicula pelicula;
    private int[][] butacas;

    public Sala(int numSala, Pelicula pelicula, int filas, int columnas) {
        this.numSala = numSala;
        this.pelicula = pelicula;
        this.butacas = new int[filas][columnas];

        for (int i = 0; i < filas; i++) {
            for (int j = 0; j < columnas; j++) {
                this.butacas[i][j] = 0; // 0 representa libre
            }
        }
    }

    /**
     * Este método muestra la información de la sala elegida, es decir, el número de la sala, el nombre de la pelicula
     * y su duración.
     * Estos dos últimos datos los saca de la clase Película.
     */
    public void mostrarInformacion() {
        System.out.println("\nNúmero de Sala: " + numSala);
        System.out.println("Pelicula: " + pelicula.getTitulo());
        System.out.println("Duración: " + pelicula.getDuracion() + " minutos");
    }

    /**
     * Este método permite reservar butaca según la sala que se seleccione.
     * Primero se muestra la matriz de las butacas, después te permite seleccionar un sitio y finalmente marca
     * tu asiento como ocupado (1).
     * En caso de que el asiento esté ocupado (1), no permitirá reservarlo.
     * Por último, muestra de nuevo la matriz de butacas con los sitios seleccionados.
     */
    public void reservarButaca() {

        Scanner entrada = new Scanner(System.in);
        int fila;
        int columna;
        System.out.println("\n");
        for (int i = 0; i < butacas.length; i++) {
            for (int j = 0; j < butacas[i].length; j++) {
                System.out.print(butacas[i][j] + " ");
            }
            System.out.println();
        }

        System.out.print("\nSelecciona una fila: ");
        fila = entrada.nextInt();
        System.out.print("Selecciona una columna: ");
        columna = entrada.nextInt();

        /* Esta parte impide que se reserve una butaca ocupada */

        if (butacas[fila][columna] == 1) {
            System.out.println("\nAsiento ocupado, por favor, seleccione otro asiento\n");
        } else {
            butacas[fila][columna] = 1; // El 1 representa una butaca ocupada
            System.out.println("\nAsiento reservado con éxito\n");
        }

        for (int i = 0; i < butacas.length; i++) {
            for (int j = 0; j < butacas[i].length; j++) {
                System.out.print(butacas[i][j] + " ");
            }
            System.out.println();
        }

    }
    public int getNumSala() {
        return numSala;
    }

    public void setNumSala(int numSala) {
        this.numSala = numSala;
    }

    public Pelicula getPelicula() {
        return pelicula;
    }

    public void setPelicula(Pelicula pelicula) {
        this.pelicula = pelicula;
    }

    public int[][] getButacas() {
        return butacas;
    }

    public void setButacas(int[][] butacas) {
        this.butacas = butacas;
    }

}