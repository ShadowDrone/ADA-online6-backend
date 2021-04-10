package app;

import java.util.*;

public class App {

    public static Scanner Teclado = new Scanner(System.in);

    public static void main(String[] args) throws Exception {
        //A partir de Metflix, buscar la temporada 5 episodio 1 de la serie
        //How I met your mother y 
        //reproducir el episodio.

        Metflix miMetflix = new Metflix();

        System.out.println("Inicializando catalogo de Metflix");

        miMetflix.inicializarCatalogo();//Estoy llamando al metodo que crea las pelis y series.

        //miMetflix.mostrarNominaciones();

        System.out.println("Ingrese nro temporada: ");

        int nroTemporada = Teclado.nextInt();
        Teclado.nextLine();

        System.out.println("Ingrese nro episodio: ");
        int nroEpisodio = Teclado.nextInt();
        Teclado.nextLine();

        miMetflix.reproducirEpisodioDeSerie("How I met your mother", nroTemporada, nroEpisodio);

    }
}
