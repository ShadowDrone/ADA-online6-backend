//En este caso Cliente "hereda"(extends) de Persona
public class Cliente extends Persona {
    // int maximo : 2147483647
    public int codigoCliente;
    public String formaPago; //Tarjeta/Efectivo/Transferencia
    //en vez de public, sera privada
    private String palabraSecreta;

    public void generarPalabraSecreta(){
        this.palabraSecreta = "232329392929sfjfskdafdj";
    }
}
