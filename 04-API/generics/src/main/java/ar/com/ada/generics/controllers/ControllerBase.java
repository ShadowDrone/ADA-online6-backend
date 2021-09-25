package ar.com.ada.generics.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.*;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;

import ar.com.ada.generics.entities.Entidad;
import ar.com.ada.generics.models.response.GenericResponse;
import ar.com.ada.generics.services.Servicio;

public class ControllerBase<T extends Entidad> {

    @Autowired
    Servicio<T> service;

    @GetMapping
    public ResponseEntity<List<T>> traerTodos() {
        return ResponseEntity.ok(service.traerTodos());
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> traerPorId(@PathVariable Integer id) {
        T entidad = service.buscarPorId(id);
        if (entidad == null)
            return ResponseEntity.notFound().build();
        return ResponseEntity.ok(entidad);
    }

    @PostMapping()
    public ResponseEntity<?> crear(@RequestBody T entidad) {

        GenericResponse r = new GenericResponse();
        service.crear(entidad);
        r.isOk = true;
        r.id = entidad.getId();
        r.message = "Entidad Creada con exito";
        return ResponseEntity.ok(r);
    }
}
