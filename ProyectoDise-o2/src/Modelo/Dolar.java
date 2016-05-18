package Modelo;

public class Dolar extends Moneda {
    
    public Dolar(Double monto,String tipo) {
        super(monto,tipo);
    }
    public Dolar(Double monto, Double tipoCambio,String tipo){
        super(monto/tipoCambio,tipoCambio,tipo);
    }
}
