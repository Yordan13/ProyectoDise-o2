
package Modelo;

import java.util.ArrayList;

public abstract class SistemaAmortizacion {
    private Cliente cliente;
    protected Moneda monto;
    protected ArrayList<Cuota> cuotas;

    public SistemaAmortizacion(Cliente cliente, Moneda monto) {
        this.cliente = cliente;
        this.monto = monto;
    }
    protected abstract double calcularAmortizacion();
    protected abstract double calcularInteres();
    private void agregarCuota(){}
    private void actualizarMonto(double deduccion){
        double actual = monto.getMonto()-deduccion;
        monto.setMonto(actual);
    }
}
