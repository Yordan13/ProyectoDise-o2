
package Modelo;

public abstract class Moneda {
    private double monto;
    private String tipo;
    private static double tipoCambio;

    public Moneda(double monto,String tipo) {
        this.monto = monto;
        this.tipo=tipo;
    }
    public Moneda(double monto, double tipoCambio,String tipo) {
        this.monto = monto;
        this.tipo=tipo;
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
    public String getTipo(){
        return tipo;
    }
}
