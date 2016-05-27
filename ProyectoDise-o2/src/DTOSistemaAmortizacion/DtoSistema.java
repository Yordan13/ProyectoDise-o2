package DTOSistemaAmortizacion;

import Modelo.Cuota;
import java.util.ArrayList;


public class DtoSistema {
    private double monto;
    private double interes;
    private int periodo;
    private String tipoMoneda;
    private String SistemaAmortizacion;
    private String nombreCliente;
    private String cuotas;
    private String tipoCambio;
    private String fecha;

    public DtoSistema(double monto, double interes, int periodo, String tipoMoneda, String SistemaAmortizacion, String nombreCliente) {
        this.monto = monto;
        this.interes = interes;
        this.periodo = periodo;
        this.tipoMoneda = tipoMoneda;
        this.SistemaAmortizacion = SistemaAmortizacion;
        this.nombreCliente = nombreCliente;
    }
    public DtoSistema(double monto, double interes, int periodo, String tipoMoneda, String SistemaAmortizacion, String nombreCliente, String cuotas,String tipoCambio,String fecha) {
        this.monto = monto;
        this.interes = interes;
        this.periodo = periodo;
        this.tipoMoneda = tipoMoneda;
        this.SistemaAmortizacion = SistemaAmortizacion;
        this.nombreCliente = nombreCliente;
        this.cuotas=cuotas;
        this.tipoCambio=tipoCambio;
        this.fecha=fecha;
    }
    public String toString(){
        String resultado="Tipo de cambio compra BCCR: "+tipoCambio+"\n"+
                "Datos de la consulta:\n"+
                "Cliente: "+nombreCliente+"\n"+
                "Monto del préstamo otorgado: "+String.format("%.2f", monto)+" de "+tipoMoneda+"\n"+
                "Plazo del préstamo: "+periodo+" años\n"+
                "Interés anual: "+interes * 100+" %\n"+ 
                "Sistema de amortización: "+SistemaAmortizacion+"\n\n"+
                "Tabla de Amortización\n\n"+
                cuotas+"\n\n"+
                fecha;
        return resultado;
    }
    
    public double getMonto() {
        return monto;
    }

    public double getInteres() {
        return interes;
    }

    public int getPeriodo() {
        return periodo;
    }

    public String getTipoMoneda() {
        return tipoMoneda;
    }

    public String getSistemaAmortizacion() {
        return SistemaAmortizacion;
    }

    public String getNombreCliente() {
        return nombreCliente;
    }
    
}
