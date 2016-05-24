 
package Modelo;

import DTOSistemaAmortizacion.DtoSistema;
import Factory.FactoryMoneda;
import java.util.ArrayList;
import java.util.Formatter;
import java.util.Locale;
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
        return new DtoSistema(monto.getMonto(), tasaInteres, periodo,monto.getTipo(),tipoSistema,cliente.getNombre() , obtenerStringCuotas(), String.valueOf(monto.getTipoCambio()),fecha);
    }
    private String obtenerStringCuotas(){
        String formatoLineas="%-15s%-15s%-15s%-15s%-20s\n";
        String formatoDecimales="%.2f";
        Formatter formateador=generarFormateador();
        formateador.format(formatoLineas, "Periodo", "Deuda inicial", "Interes(SK)","Amortización(vK)","Cuota(cK)");
        Double totalInteres=0.0;
        Double totalAmortizacion=0.0;
        Double totalCuotas=0.0;
        Double totalCuota=0.0;
        for(Cuota cuota:cuotas){
            totalCuota=cuota.getCuotaInteres().getMonto()+cuota.getAmortizacion().getMonto();
            totalCuotas+=totalCuota;
            totalInteres+=cuota.getCuotaInteres().getMonto();
            totalAmortizacion+=cuota.getAmortizacion().getMonto();
            formateador.format(formatoLineas, cuota.getPeriodo(), 
                formatoDecimales(formatoDecimales,cuota.getDeuda().getMonto()),
                formatoDecimales(formatoDecimales,cuota.getCuotaInteres().getMonto()),
                formatoDecimales(formatoDecimales,cuota.getAmortizacion().getMonto()),
                formatoDecimales(formatoDecimales,totalCuota));
          }
        formateador.format(formatoLineas,"Total","",formatoDecimales(formatoDecimales,totalInteres),
                formatoDecimales(formatoDecimales,totalAmortizacion),
                formatoDecimales(formatoDecimales,totalCuotas));
        return formateador.toString();
    }
    private Formatter generarFormateador(){
        StringBuilder lineas= new StringBuilder();
        Formatter formateador = new Formatter(lineas, Locale.US);
        return formateador;
    }
    private String formatoDecimales(String formato,Double numero){
        return String.format(formato,numero);
    }
}
