package ar.com.ada.generics.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import lombok.*;

@Getter
@Setter
@Entity
@Table(name = "dispositivo")
public class Dispositivo extends Entidad {
    
    private String nombre;

    @Override
    @Column(name="dispositivo_id")
    public Integer getId() {
        return super.getId();
    }
}
