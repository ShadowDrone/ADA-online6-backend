public class Personaje {
    
    public String nombre; //atributo del personaje
    public int salud; //salud del personaje
    public String color; //color del personaje

    //Responsabilidades(metodos funciones):
    public void atacarA(Personaje enemigo, int danio){
        enemigo.salud = enemigo.salud - danio;
    }
}
