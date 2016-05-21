
package Modelo;

import DTOSistemaAmortizacion.DtoSistema;
import Factory.FactoryMoneda;
import java.util.ArrayList;
import java.util.concurrent.ExecutionException;

public abstract class SistemaAmortizacion {
    private Cliente cliente;
    private String fecha;
    private String tipoSistema;
    protected int periodo;
    protected Moneda monto;
    protected ArrayList<Cuota> cuotas;
    protected double tasaInteres;
    

    public SistemaAmortizacion(Cliente cliente, Moneda monto,int periodo,String fecha,double tasaInteres,String tipoSistema) {
        this.cliente = cliente;
        this.monto = monto;
        this.periodo=periodo;
        this.fecha=fecha;
        this.tasaInteres=tasaInteres;
        this.tipoSistema=tipoSistema;
        cuotas=new ArrayList<>();
        
    }
    private void actualizarMonto(double deduccion){
        double actual = monto.getMonto()-deduccion;
        monto.setMonto(actual);
    }
    protected void agregarCuota(Cuota cuota){
        cuotas.add(cuota);
    }
    protected Cuota crearCuota(int periodoActual,double cuotaInteres,double deuda, double amortizacion)throws Exception{
        Moneda cuotaInteresMoneda=FactoryMoneda.instanciar(monto.getTipo(), cuotaInteres);
        Moneda amortizacionMoneda=FactoryMoneda.instanciar(monto.getTipo(), amortizacion);
        Moneda deudaMoneda=FactoryMoneda.instanciar(monto.getTipo(), deuda);
        return new Cuota(periodoActual,cuotaInteresMoneda,deudaMoneda,amortizacionMoneda);
    }
    public abstract void generarCuotas()throws Exception;
    public DtoSistema getDTO(){
        return new DtoSistema(monto.getMonto(), tasaInteres, periodo,monto.getTipo(),tipoSistema , fecha, cuotas);
    }
}
