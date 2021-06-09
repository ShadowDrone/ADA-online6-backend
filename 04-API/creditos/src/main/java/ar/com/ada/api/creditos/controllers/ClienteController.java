package ar.com.ada.api.creditos.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ar.com.ada.api.creditos.entities.Cliente;
import ar.com.ada.api.creditos.models.response.GenericResponse;
import ar.com.ada.api.creditos.services.ClienteService;

@RestController
public class ClienteController {

    @Autowired
    ClienteService clienteService;

    /**
     * Este metodo tiene un queryString que viene por url y es opcional, este campo
     * servira para buscar las clientes con un nombre especifico. ejemplo:
     * /clientes -> devuelve la lista de todas los clientes. En este caso la lista
     * de clientes ordenadas usando el service+repo creado ejemplo2:
     * /clientes?nombre=Analia -> trae todas las personas que tengan el nombre
     * analia. la busqueda la hace a traves del service+repo(query creado en repo)
     * 
     * @param nombre
     * @return
     */
    @GetMapping("/clientes")
    public List<Cliente> getClientees(@RequestParam(value = "nombre", required = false) String nombre) {
        List<Cliente> lh;

        if (nombre == null) {
            lh = clienteService.buscarTodosOrdenadoPorNombre();
        } else {
            lh = clienteService.buscarTodosPorNombre(nombre);
        }

        return lh;
    }

    /**
     * Version devolviendo diferentes tipos de status segun se requiera se hace
     * usando la clase ResponseEntity. En este caso devuelve un "Ok(Cliente)" o un
     * ResponseEntity notfound (404) El responseEntity se le debe pasar en el
     * operador diamante el tipo de objeto a devolver.
     * 
     * @param id
     * @return
     */
    @GetMapping("/clientes/{id}")
    public ResponseEntity<Cliente> getClienteById(@PathVariable int id) {
        Cliente h = clienteService.buscarPorId(id);

        if (h == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return ResponseEntity.ok(h);
    }

    @PostMapping("/clientes")
    public ResponseEntity<?> postCliente(@RequestBody Cliente req) {

        GenericResponse r = new GenericResponse();

        boolean resultado = clienteService.crearCliente(req);

        if (resultado) {
            r.isOk = true;
            r.id = req.getClienteId();
            r.message = "Creaste una cliente con éxito.";
            return ResponseEntity.ok(r);
        } else {

            r.isOk = false;
            r.message = "No se pudo crear el cliente! ya existe alguien con ese DNI.";

            return ResponseEntity.badRequest().body(r);
        }

    }

    @PutMapping("/clientes/{id}")
    public ResponseEntity<?> postCliente(@PathVariable int id, @RequestBody Cliente req) {

        GenericResponse r = new GenericResponse();

        Cliente clienteOriginal = clienteService.buscarPorId(id);

        if (clienteOriginal == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        boolean resultado = false;
        resultado = clienteService.actualizarCliente(clienteOriginal, req);

        if (resultado) {
            r.isOk = true;
            r.id = id;
            r.message = "Cliente actualizado con éxito.";
            return ResponseEntity.ok(r);
        } else {

            r.isOk = false;
            r.message = "No se pudo actualizra el cliente.";

            return ResponseEntity.badRequest().body(r);
        }

    }

}