package app;

import app.personas.*;
public class Pelicula extends Contenido implements INominable {
    private int duracion; //en minutos
    private Director director = new Director();
    private boolean filmadaEnIMAX;

    public int getDuracion() {
        return this.duracion;
    }

    public void setDuracion(int duracion) {
        this.duracion = duracion;
    }

    public Director getDirector() {
        return this.director;
    }

    public void setDirector(Director director) {
        this.director = director;
    }

    public boolean getFilmadaEnIMAX() {
        return this.filmadaEnIMAX;
    }

    public void setFilmadaEnIMAX(boolean filmadaEnIMAX) {
        this.filmadaEnIMAX = filmadaEnIMAX;
    }

    @Override
    public boolean ganoPreviamente() {
        //ACA va nuestra logica, dde saber
        //si una peli fue nominada o no
        return false;
    }

    @Override
    public void reproducirTrailerNominacion() {
        System.out.println("Reproduciendo avances de "+ this.getNombre());
    }

}
