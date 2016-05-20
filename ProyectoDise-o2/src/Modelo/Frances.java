
package Modelo;

import java.util.Date;

public class Frances extends SistemaAmortizacion{

    public Frances(Cliente cliente, Moneda monto, Integer periodo, String fecha, Double tasaInteres) {
        super(cliente, monto, periodo, fecha, tasaInteres);
    }
    private double calcularAmortizacion(double cuota, int periodoActual) {
        return dividirConCalculoElevadoTasaInteres(cuota,periodoActual);
    }
    private double dividirConCalculoElevadoTasaInteres(double denominador,int periodoActual){
        return denominador/calculoElevadoTasaInteres(periodo+1-periodoActual);
    }
    private double calcularCuotaInteres(double cuota,int periodoActual) {
        return cuota*(1-dividirConCalculoElevadoTasaInteres(1,periodoActual));
    }
    private double calcularCuotaConstante(){
        return monto.getMonto()*auxCalcularCuotaConstante();
    }
    private double calculoElevadoTasaInteres(double exponente){
        return Math.pow(1+tasaInteres, exponente);
    }
    private double auxCalcularCuotaConstante(){
        double calculoElevado=calculoElevadoTasaInteres(periodo);
        return (calculoElevado*tasaInteres)/(calculoElevado-1);
    }
    @Override
    public void generarCuotas() throws Exception{
        double cuotaConstante=calcularCuotaConstante();
        double amortizacion=0;
        double cuotaInteres=0;
        double deudaActual=monto.getMonto();
        for(int periodoActual=1;periodoActual<=periodo;periodoActual++){
            amortizacion=calcularAmortizacion(cuotaConstante, periodoActual);
            cuotaInteres=calcularCuotaInteres(cuotaConstante, periodoActual);
            Cuota cuotaActual=crearCuota(periodoActual, cuotaInteres, deudaActual, amortizacion);
            agregarCuota(cuotaActual);
            deudaActual-=amortizacion;
        }
    }
}
    
