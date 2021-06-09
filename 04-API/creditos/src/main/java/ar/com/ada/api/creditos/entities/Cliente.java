package ar.com.ada.api.creditos.entities;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.*;

import org.hibernate.annotations.NaturalId;

import ar.com.ada.api.creditos.excepciones.*;

import java.util.*;

@Entity
@Table(name = "cliente")
// Named query usando JPQL donde se hace SELECT sobre el Objeto Cliente. En este
// caso se usa un Like para traer aquellos que contengan ese nombre
// El parametro ?1 indica que al query se le pasara UN parametro.
// El campo nombre indica el nombre de la funcion que debe tener en el
// Repository
// Yo recomiendo usar los NamedQueries en el Repo para no llenarlo en el objecto
@NamedQuery(name = "Cliente.findAllByNombreContiene", query = "FROM Cliente WHERE nombre like CONCAT('%', ?1,'%')")
// Este es un caso de named query igual al anterior, solo con 2 parametros
@NamedQuery(name = "Cliente.findAllByNombreAndDNI", query = "SELECT h FROM Cliente h WHERE h.nombre = ?1 AND h.dni = ?2")
// Este caso es un query usando SQL Puro, los parametros van en formato ? y se
// deben pasar en orden a la funcion del repo(ver PersonaRepository)
@NamedNativeQuery(name = "Cliente.findAllByNombreConAndDNISQLNativo", query = "SELECT * FROM cliente WHERE nombre like CONCAT('%', ?,'%') AND dni = ?", resultClass = Cliente.class)
public class Cliente {
    @Id
    @Column(name = "cliente_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int clienteId;
    private String nombre;
    @NaturalId
    private int dni;

    private String direccion;

    @Column(name = "direccion_alternativa")
    private String direccionAlternativa;

    @Column(name = "fecha_nacimiento")
    @Temporal(TemporalType.DATE) //SOLO Poner esto si no queremos manejar HORA en el DB Server.
    private Date fechaNacimiento;

    @OneToMany(mappedBy = "cliente", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JsonIgnore
    private List<Prestamo> prestamos = new ArrayList<>();

    public Cliente(String nombre) {
        this.nombre = nombre;

    }

    public Cliente() {
    }

    public int getClienteId() {
        return clienteId;
    }

    public void setClienteId(int clienteId) {
        this.clienteId = clienteId;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setDni(int dni) throws ClienteDNIException {

        if (dni < 0) {
            // no se ejecuta nada mas despues del throw
            throw new ClienteDNIException(this, "ocurrio un error con el DNI");

        }
        this.dni = dni;
    }

    public int getDni() {
        return dni;
    }

    @Override
    public String toString() {
        return "Cliente [id=" + clienteId + ", dni=" + dni + ", nombre=" + nombre + "]";
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getDireccionAlternativa() {
        return direccionAlternativa;
    }

    public void setDireccionAlternativa(String direccionAlternativa) {
        this.direccionAlternativa = direccionAlternativa;
    }

    public Date getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(Date fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public List<Prestamo> getPrestamos() {
        return prestamos;
    }

    public void setPrestamos(List<Prestamo> prestamos) {
        this.prestamos = prestamos;
    }

    public void agregarPrestamo(Prestamo prestamo) {
        this.prestamos.add(prestamo);
    }
}