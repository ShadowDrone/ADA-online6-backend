public class Episodio {
    private int numero;
    private String nombre;
    private int duracion; //en minutos
    public Director director;
    public String sinopsis;

    //GETTERS/SETTERS
    //GETTER => permite leer un valor de atributo
    //SETTER => permite asignar un valor a un atributo

    //GETTER
    public int getNumero() {
        return this.numero;
    }

    //SETTER: palabra "set"+ Nombre attrib + (parametro)
    public void setNumero(int numero) {
        this.numero = numero;
    }

    public String getNombre() {
        return this.nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getDuracion() {
        return this.duracion;
    }

    public void setDuracion(int duracion) {
        this.duracion = duracion;
    }

    public void reproducir() {
        System.out.println("Reproduciendo episodio " + nombre);
    }
}
