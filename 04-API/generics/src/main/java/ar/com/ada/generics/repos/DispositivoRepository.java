package ar.com.ada.generics.repos;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import ar.com.ada.generics.entities.Dispositivo;

@Repository
public interface DispositivoRepository extends JpaRepository<Dispositivo,Integer> {
    
}
