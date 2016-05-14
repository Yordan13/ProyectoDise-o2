
package Modelo;

public abstract class Moneda {
    private double monto;
    private static double tipoCambio;

    public Moneda(double monto) {
        this.monto = monto;
        this.tipoCambio = tipoCambio;
    }
    public double getTipoCambio(){
        return tipoCambio;
    }
    
    public double getMonto(){
        return monto;
    }
    public void setMonto(double cantidad){
        monto=cantidad;
    }
}
