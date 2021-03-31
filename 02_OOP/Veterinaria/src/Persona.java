import java.util.Date;

//para crear una clase
//primero se especifia el accesor(public/hay otros)
//luego la palabra "class" yfinalmente
//el nombre de la clase, tiene que ser exacto al nombre
//del archiPvo. En este caso clase Persona esta en Persona.java
//si tienen que poner doble palabra usan PascalCase
//PascalCase: cada palabra comienza con mayuscula
//Ej: clase Cocna Cola, seria asi: CocaCola y su archivo CocaCola.java
//por defecto hereda de la clase Object
public class Persona {

    //atributos/variables de instancia
    //va el modificador de acceso: public/private/protected
    //public significa que TODAS las otras instancias
    //pueden acceder a mi propiedad nombre
    //despues viene el tipo de dato y finalmente el nombre del atributo
    public String nombre;
    public String dni;
    //el maximo de int es 2147483647
    //011-2525-6254 => con int se guardaria asi: 1125256254
    public String telefono; //+549117777777 //0-800-El-GATITO-FELIZ
    //Date 
    public Date fechaNacimiento;
    public String direccion;
    public String email;

}