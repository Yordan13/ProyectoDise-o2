package DTOSistemaAmortizacion;


public class DtoSistema {
    private double monto;
    private double interes;
    private int periodo;
    private String tipoMoneda;
    private String SistemaAmortizacion;
    private String nombreCliente;

    public DtoSistema(double monto, double interes, int periodo, String tipoMoneda, String SistemaAmortizacion, String nombreCliente) {
        this.monto = monto;
        this.interes = interes;
        this.periodo = periodo;
        this.tipoMoneda = tipoMoneda;
        this.SistemaAmortizacion = SistemaAmortizacion;
        this.nombreCliente = nombreCliente;
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
