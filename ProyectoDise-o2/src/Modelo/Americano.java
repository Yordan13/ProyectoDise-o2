
package Modelo;

import java.util.Date;

public class Americano extends SistemaAmortizacion{

    public Americano(Cliente cliente, Moneda monto, Integer periodo, String fecha, Double tasaInteres) {
        super(cliente, monto, periodo, fecha, tasaInteres);
    }
    private double calcularCuotaInteres(){
        return monto.getMonto()*tasaInteres;
    }
    private double calcularAmortizacion(){
        return monto.getMonto();
    }
    @Override
    protected void generarCuotas() {
        double amortizacion=0;
        double cuotaInteres=calcularCuotaInteres();
        double deudaActual=monto.getMonto();
        for(int periodoActual=1;periodoActual<periodo;periodoActual++){
            Cuota cuotaActual=crearCuota(periodoActual, cuotaInteres, deudaActual, amortizacion);
            deudaActual-=amortizacion;
        }
        amortizacion=calcularAmortizacion();
        Cuota cuotaActual=crearCuota(periodo, cuotaInteres, deudaActual, amortizacion);
    }
}
