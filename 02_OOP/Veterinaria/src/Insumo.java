import java.util.Date;

public class Insumo {
    public String nombre;

    public Date fechaDeIngreso;

    public String codigoDelInsumo;

    public Date fechaDeCaducidad;

    public double precio;

    public double costo;

    public boolean estaVencido(){
        Date hoy = new Date(); //date es un objeto en java genera por defecto la fecha de hoy

        //this.fechaDeCaducidad >= hoy
        if (this.fechaDeCaducidad.after(hoy)){
            return true;       
        }
        return false;
        
    }
}
