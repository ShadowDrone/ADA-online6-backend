package ar.com.ada.abmcliente.excepciones;

import ar.com.ada.abmcliente.entities.*;

/**
 * ClienteEdadException
 */
public class ClienteEdadException extends ClienteInfoException {

    public ClienteEdadException(Cliente cliente, String mensaje) {
        super(cliente, mensaje);
    }

}