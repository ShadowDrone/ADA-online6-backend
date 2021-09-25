package ar.com.ada.generics.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;

import ar.com.ada.generics.entities.Entidad;

public class Servicio<T extends Entidad> implements IServicio<T> {

    @Autowired
    JpaRepository<T, Integer> repo;

    @Override
    public void crear(T t) {
        repo.save(t);

    }

    @Override
    public void grabar(T t) {

        repo.save(t);

    }

    @Override
    public void delete(T t) {

        repo.delete(t);

    }

    @Override
    public List<T> traerTodos() {
        // log
        return repo.findAll();
    }

    @Override
    public T buscarPorId(Integer id) {

        Optional<T> value = repo.findById(id);
        if (value.isPresent())
            return value.get();
        return null;
    }

    @Override
    public boolean esValido(T t) {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public boolean existe(T t) {

        return true;
    }

}
