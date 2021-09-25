package ar.com.ada.generics.services;

import java.util.List;

import ar.com.ada.generics.entities.Entidad;

//
public interface IServicio<T extends Entidad> {
    
    void crear(T t); //insert
    void grabar(T t); //update
    void delete(T t);
    List<T> traerTodos();
    T buscarPorId(Integer id);
    boolean esValido(T t);
    boolean existe(T t);

}
