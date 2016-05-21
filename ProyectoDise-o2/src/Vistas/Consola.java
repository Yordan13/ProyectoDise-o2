
package Vistas;

import Controlador.AbstractControlador;
import DTOSistemaAmortizacion.DtoSistema;


public class Consola implements Vista{
    private AbstractControlador controlador; 
    private String[] sistemas= new String[]{"Aleman,Frances,Americano"};
    private String[] monedas =new String[]{"Dolares,Colones"};
    public Consola() {
    }

    @Override
    public void mostrarMensaje(String mensaje) {
        System.out.println(mensaje);
    }

    @Override
    public void mostrarInformacion(DtoSistema dto) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public void setControlador(AbstractControlador controlador) {
        this.controlador = controlador;
    }
    
}
