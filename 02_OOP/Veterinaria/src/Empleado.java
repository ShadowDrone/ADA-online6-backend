import java.util.Date;

public class Empleado extends Persona {
    
    public int numeroDeLegajo;
    public String numeroDeCuil;
    public Date fechaDeIngreso;
    public String diasDeTrabajo;// Lunes a Viernes. 
    public String turnoDeTrabajo; //Mañana/Tarde/Noche
    public String cbu; 
    public double sueldo;

    
    public boolean esValidoCBU() {
        if (this.cbu.length()==23) {
            return true;
        }
        return false;
    }

}
