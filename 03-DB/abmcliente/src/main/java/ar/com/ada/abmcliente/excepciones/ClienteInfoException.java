package ar.com.ada.abmcliente.excepciones;

import ar.com.ada.abmcliente.entities.*;

/**
 * ClienteInfoException
 */
public class ClienteInfoException extends Exception {

    private Cliente cliente;

    public ClienteInfoException(Cliente cliente, String mensaje) {

        super(cliente.getNombre() + ":" + mensaje);
        this.cliente = cliente;
    }
}
