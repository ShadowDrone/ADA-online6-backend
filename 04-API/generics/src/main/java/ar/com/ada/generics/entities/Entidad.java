package ar.com.ada.generics.entities;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;

import lombok.*;

import javax.persistence.*;

@MappedSuperclass
@Getter
@Setter
public class Entidad {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Integer id;
}
