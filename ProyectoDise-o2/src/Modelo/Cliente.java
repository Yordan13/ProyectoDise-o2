
package Modelo;

public abstract class Cliente {
    private String nombre;

    public Cliente(String nombre) {
        this.nombre = nombre;
    }
    public String getNombre(){
        return nombre;
    }
}
