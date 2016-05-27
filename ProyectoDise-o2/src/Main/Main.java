package Main;

import Controlador.AbstractControlador;
import Vistas.GUI;

public class Main {

    public static void main(String[] args) {
        GUI gui = new GUI();
        AbstractControlador o = new AbstractControlador(gui);
        gui.setControlador(o);
        gui.setVisible(true);
    }
    
}

