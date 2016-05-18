package Modelo;


public class Colon extends Moneda{
    
    public Colon(Double monto,String tipo) {
        super(monto,tipo);
    }
    public Colon(Double monto,Double tipocambio,String tipo){
        super(monto, tipocambio,tipo);
    }
}
