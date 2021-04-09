package app.personas;

import app.INominable;

public class Actor extends Persona implements INominable {

    @Override
    public boolean ganoPreviamente() {
        //Logica si fue nominado previamente
        return false;
    }

    @Override
    public void reproducirTrailerNominacion() {
        
        System.out.println("Mostrando trailer de escenas para el actor" + this.getNombre());
        
    }

   
    
}
