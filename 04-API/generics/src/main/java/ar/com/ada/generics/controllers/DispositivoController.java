package ar.com.ada.generics.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ar.com.ada.generics.entities.Dispositivo;



@RestController
@RequestMapping("/dispositivos")
public class DispositivoController extends ControllerBase<Dispositivo> {
    
    
}
