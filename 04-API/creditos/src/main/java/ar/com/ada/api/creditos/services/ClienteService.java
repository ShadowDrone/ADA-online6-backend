package ar.com.ada.api.creditos.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ar.com.ada.api.creditos.entities.*;
import ar.com.ada.api.creditos.repos.*;

@Service
public class ClienteService {

    @Autowired
    ClienteRepository clienteRepo;

    public boolean crearCliente(Cliente cliente) {

        if (existe(cliente.getDni()))
            return false;

        grabar(cliente);
        return true;
    }

    public boolean actualizarCliente(Cliente clienteOriginal, Cliente clienteConInfoNueva) {
        // Aca solo dejamos que se actualize el nombre y domicilio solamente

        clienteOriginal.setNombre(clienteConInfoNueva.getNombre());
        clienteOriginal.setDireccion(clienteConInfoNueva.getDireccion());
        clienteOriginal.setDireccionAlternativa(clienteConInfoNueva.getDireccionAlternativa());

        grabar(clienteOriginal);

        return true;
    }

    public void grabar(Cliente cliente) {

        clienteRepo.save(cliente);
    }

    public Cliente buscarPorId(int clienteId) {

        Optional<Cliente> b = clienteRepo.findById(clienteId);

        if (b.isPresent())
            return b.get();
        return null;
    }

    public boolean baja(int clienteId) {

        Cliente cliente = buscarPorId(clienteId);

        if (cliente == null)
            return false;

        return baja(cliente);
    }

    public boolean baja(Cliente cliente) {

        clienteRepo.delete(cliente);
        return true;
    }

    public boolean bajaPorDNI(int dni) {

        Cliente cliente = clienteRepo.findByDni(dni);

        if (cliente == null)
            return false;

        return baja(cliente);
    }

    public List<Cliente> buscarTodos() {

        return clienteRepo.findAll();
    }

    public List<Cliente> buscarTodosOrdenadoPorNombre() {

        return clienteRepo.findAllOrderByNombre();
    }

    public Cliente buscarPorNombre(String nombre) {

        return clienteRepo.findByNombre(nombre);
    }

    public List<Cliente> buscarTodosPorNombre(String nombre) {

        return clienteRepo.findAllByNombreContiene(nombre);
    }

    public Cliente buscarPorDni(int dni) {

        return clienteRepo.findByDni(dni);
    }

    public boolean existe(int dni) {

        Cliente cliente = buscarPorDni(dni);

        return cliente != null;

    }

}