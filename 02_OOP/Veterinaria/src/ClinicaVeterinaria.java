import java.util.*;

public class ClinicaVeterinaria {
    public String nombre;
    public String cuit;//identificador fiscal
    public String telefono;
    public String email;
    //Es un atributo de tipo "Lista".
    //van siempre el PLURAL
    //Y se declara:
    //publi List<Tipo> nombreVariablePlural;
    //adicionalmente van a agregar = new ArrayList<>(); para que sea
    //una lista VACIA, es decir una lista con 0 elementos
    // el <> es el operador Diamante/Diamond
    public List<Paciente> pacientes  = new ArrayList<>();
    public int capacidadMaxima = 20; //asigna un valor por defecto

    //devuelve true si el paciente paso bien la revision
    //si no, false.
    public boolean hacerRevision(Paciente paciente){

        System.out.println("Revisando al paciente "+paciente.nombre);
        return true;

    }

    //devuelve true si lo pudo ingresar
    //false si no
    public boolean ingresar(Paciente paciente){

        if (this.pacientes.size() < this.capacidadMaxima){
            this.pacientes.add(paciente);
            return true;
        }

        return false;
    }

    public void imprimirListadoPacientes(){
        
        System.out.println("***************LISTADO****************");
        //For each paciente en pacientes
        //es un ciclo for especial
        //que permite iterar/recorrer listas
        //asignando a una variable antes del : el valor
        //de cada elemento.
        for (Paciente paciente : pacientes) {
            //imprimo el atributo nombre del paciente
            System.out.println("Paciente Ingresado: " + paciente.nombre);
        }
        System.out.println("*****************************************");
    }
}
