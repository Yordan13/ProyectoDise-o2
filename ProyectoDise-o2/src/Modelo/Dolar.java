package Modelo;

public class Dolar extends Moneda {
    
    public Dolar(double monto) {
        super(monto);
    }
    public Dolar(double monto, double tipoCambio){
        super(monto/tipoCambio,tipoCambio);
    }
}
