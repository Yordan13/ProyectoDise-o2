package Modelo;


public class Cuota {
    private int periodo;
    private Moneda cuotaInteres;
    private Moneda deuda;
    private Moneda amortizacion;

    public Cuota(int periodo,Moneda cuotaInteres, Moneda deuda, Moneda amortizacion) {
        this.periodo=periodo;
        this.cuotaInteres = cuotaInteres;
        this.deuda = deuda;
        this.amortizacion = amortizacion;
    }

    public int getPeriodo() {
        return periodo;
    }

    public Moneda getCuotaInteres() {
        return cuotaInteres;
    }

    public Moneda getDeuda() {
        return deuda;
    }

    public Moneda getAmortizacion() {
        return amortizacion;
    }
    
}
