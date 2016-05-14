package Modelo;


public class Cuota {
    private Moneda interes;
    private Moneda deuda;
    private Moneda amortizacion;

    public Cuota(Moneda interes, Moneda deuda, Moneda amortizacion) {
        this.interes = interes;
        this.deuda = deuda;
        this.amortizacion = amortizacion;
    }
    
}
