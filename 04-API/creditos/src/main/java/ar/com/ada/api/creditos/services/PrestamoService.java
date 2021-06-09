package ar.com.ada.api.creditos.services;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ar.com.ada.api.creditos.entities.Prestamo;
import ar.com.ada.api.creditos.repos.PrestamoRepository;

@Service
public class PrestamoService {

    @Autowired
    PrestamoRepository prestamoRepo;

    public void grabar(Prestamo prestamo) {

        prestamoRepo.save(prestamo);
    }

    public Prestamo buscarPorId(int prestamoId) {

        Optional<Prestamo> b = prestamoRepo.findById(prestamoId);

        if (b.isPresent())
            return b.get();

        return null;
    }

    public boolean baja(int prestamoId) {

        Prestamo prestamo = buscarPorId(prestamoId);

        if (prestamo == null)
            return false;

        return baja(prestamo);
    }

    public boolean baja(Prestamo prestamo) {

        prestamoRepo.delete(prestamo);
        return true;
    }

    public List<Prestamo> getPrestamos() {

        return prestamoRepo.findAll();
    }

    public List<Prestamo> buscarPrestamosPorNombre(String nombre) {

        return prestamoRepo.findByNombreCliente(nombre);
    }

}