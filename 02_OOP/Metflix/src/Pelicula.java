import personas.*;
public class Pelicula extends Contenido {
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

}
