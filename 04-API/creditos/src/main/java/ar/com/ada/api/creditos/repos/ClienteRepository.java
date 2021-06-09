package ar.com.ada.api.creditos.repos;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.*;
import ar.com.ada.api.creditos.entities.*;

@Repository
public interface ClienteRepository extends JpaRepository<Cliente, Integer> {
    Cliente findByNombre(String nombreCliente);

    Cliente findByDni(Integer dni);

    // Este caso aplica al named query creado en el objeto cliente, fijarse que el
    // nombre del named query coincide con el nombre de este metodo
    // y ademas posee un parametro
    List<Cliente> findAllByNombreContiene(String nombre);

    // Igual al caso anterior pero con 2 parametros.
    List<Cliente> findAllByNombreAndDNI(String nombre, Integer dni);

    // Este caso es diferente y es el que recomiendo, se pone el @Query arriba del
    // metodo que queremos "crear" por interface
    // En este caso hace un select sobre las clientes ordenada por nombre
    // recordar que esta sintaxis es JPQL
    @Query("select h from Cliente h order by nombre")
    List<Cliente> findAllOrderByNombre();

    // Mismo caso anterior, salvo que en este se le pone "nombre" al paremtro. En
    // nuestro caso el nombre del parametro es ":dni"
    @Query("SELECT h FROM Cliente h WHERE h.dni = :dni")
    List<Cliente> findByDNIVersion2(@Param("dni") Integer descripcion);
}
