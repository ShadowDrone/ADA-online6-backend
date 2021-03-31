public class Episodio {
    public int numero;
    public String nombre;
    public int duracion; //en minutos
    public Director director;
    public String sinopsis;

    public void reproducir(){
        System.out.println("Reproduciendo episodio " + nombre);
    }
}
