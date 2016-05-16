
package Modelo;

import java.util.ArrayList;
import java.util.Date;

public abstract class SistemaAmortizacion {
    private Cliente cliente;
    private Date fecha;
    protected int periodo;
    protected Moneda monto;
    protected ArrayList<Cuota> cuotas;
    protected double tasaInteres;
    

    public SistemaAmortizacion(Cliente cliente, Moneda monto,int periodo,Date fecha,double tasaInteres) {
        this.cliente = cliente;
        this.monto = monto;
        this.periodo=periodo;
        this.fecha=fecha;
        this.tasaInteres=tasaInteres;
        cuotas=new ArrayList<>();
    }
    private void agregarCuota(){}
    private void actualizarMonto(double deduccion){
        double actual = monto.getMonto()-deduccion;
        monto.setMonto(actual);
    }
    protected void agregarCuota(Cuota cuota){
        cuotas.add(cuota);
    }
    protected Cuota crearCuota(int periodoActual,double cuotaInteres,double deuda, double amortizacion){
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    protected abstract void generarCuotas();
}
