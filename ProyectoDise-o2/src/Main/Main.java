package Main;

import Controlador.AbstractControlador;
import Vistas.Consola;
import Vistas.GUI;

public class Main {

    public static void main(String[] args) {
       //GUI();
       CONSOLA();
    }
    static void GUI(){
        GUI gui = new GUI();
        AbstractControlador controlador = new AbstractControlador(gui);
        gui.setControlador(controlador);
        gui.setVisible(true);
    }
    static void CONSOLA(){
        Consola consola = new Consola();
        AbstractControlador controlador = new AbstractControlador(consola);
        consola.setControlador(controlador);
        consola.crearSistema();
    }
    
}

