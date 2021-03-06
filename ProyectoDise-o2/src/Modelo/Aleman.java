
package Modelo;

import java.util.Date;

public class Aleman extends SistemaAmortizacion{

    public Aleman(Cliente cliente, Moneda monto, Integer periodo,String fecha,Double tasaInteres,String tipoSistema) {
        super(cliente, monto, periodo,fecha,tasaInteres,tipoSistema);
    }
    protected double calcularAmortizacion() {
        return monto.getMonto()/periodo;
    }

    private double calcularCuotaInteres(int periodoActual) {
        return (periodo-periodoActual+1)*((monto.getMonto()*tasaInteres)/periodo);
    }

    @Override
    public void generarCuotas() throws Exception{
        double amortizacion=calcularAmortizacion();
        double cuotaInteres=0;
        double deudaActual=monto.getMonto();
        for(int periodoActual=1; periodoActual<=periodo;periodoActual++){
            cuotaInteres=calcularCuotaInteres(periodoActual);
            Cuota cuotaActual = crearCuota(periodoActual, cuotaInteres, deudaActual, amortizacion);
            agregarCuota(cuotaActual);
            deudaActual-=amortizacion;
        }
    }
    
}
