package ar.com.ada.abmcliente.managers;

import java.util.List;
import java.util.logging.Level;

import javax.persistence.Query;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

import ar.com.ada.abmcliente.entities.*;

public class ClienteManager {

    protected SessionFactory sessionFactory;

    public void setup() {

        java.util.logging.Logger.getLogger("org.hibernate").setLevel(Level.OFF);
        final StandardServiceRegistry registry = new StandardServiceRegistryBuilder().configure() // configures settings
                                                                                                  // from
                                                                                                  // hibernate.cfg.xml
                .build();
        try {
            sessionFactory = new MetadataSources(registry).buildMetadata().buildSessionFactory();
        } catch (Exception ex) {
            StandardServiceRegistryBuilder.destroy(registry);
            throw ex;
        }

    }

    public void exit() {
        sessionFactory.close();
    }

    public void create(Cliente cliente) {

        Session session = sessionFactory.openSession();
        session.beginTransaction();

        session.save(cliente);


        session.getTransaction().commit();
        session.close();
    }

    public Cliente read(int clienteId) {
        Session session = sessionFactory.openSession();

        Cliente cliente = session.get(Cliente.class, clienteId);

        session.close();

        return cliente;
    }

    public Cliente readByDNI(int dni) {
        Session session = sessionFactory.openSession();

        Cliente cliente = session.byNaturalId(Cliente.class).using("dni", dni).load();

        session.close();

        return cliente;
    }

    public void update(Cliente cliente) {

        Session session = sessionFactory.openSession();
        session.beginTransaction();

        session.update(cliente);

        session.getTransaction().commit();
        session.close();
    }

    public void delete(Cliente cliente) {

        Session session = sessionFactory.openSession();
        session.beginTransaction();

        session.delete(cliente);

        session.getTransaction().commit();
        session.close();
    }

    /**
     * Este metodo en la vida real no debe existir ya qeu puede haber miles de
     * usuarios
     * 
     * @return
     */
    public List<Cliente> buscarTodos() {

        Session session = sessionFactory.openSession();

        /// NUNCA HARCODEAR SQLs nativos en la aplicacion.
        // ESTO es solo para nivel educativo
        Query query = session.createNativeQuery("SELECT * FROM cliente", Cliente.class);
        //query = session.createQuery("From Obse")
        List<Cliente> todos = query.getResultList();

        return todos;

    }

    /**
     * Busca una lista de clientes por el nombre completo Esta armado para que se
     * pueda generar un SQL Injection y mostrar commo NO debe programarse.
     * 
     * @param nombre
     * @return
     */
    public List<Cliente> buscarPor(String nombre) {

        Session session = sessionFactory.openSession();

        // SQL Injection vulnerability exposed.
        // Deberia traer solo aquella del nombre y con esto demostrarmos que trae todas
        // si pasamos
        // como nombre: "' or '1'='1"
        Query query = session.createNativeQuery("SELECT * FROM cliente where nombre = '" + nombre + "'", Cliente.class);

        List<Cliente> clientes = query.getResultList();

        return clientes;

    }


}