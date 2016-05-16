
package Modelo;

public abstract class Moneda {
    private double monto;
    private static double tipoCambio;

    protected Moneda(double monto) {
        this.monto = monto;
    }
    public Moneda(double monto, double tipoCambio) {
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
