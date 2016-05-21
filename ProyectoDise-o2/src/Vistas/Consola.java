
package Vistas;

import Controlador.AbstractControlador;
import DTOSistemaAmortizacion.DtoSistema;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;


public class Consola implements Vista{
    private AbstractControlador controlador; 
    private String[] sistemas= new String[]{"Aleman,Frances,Americano"};
    private String[] monedas =new String[]{"Dolares,Colones"};
    public Consola() {
    }

    @Override
    public void mostrarMensaje(String mensaje) {
        System.out.println(mensaje);
    }

    @Override
    public void mostrarInformacion(DtoSistema dto) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public void setControlador(AbstractControlador controlador) {
        this.controlador = controlador;
    }
    private Double obtenerDouble(String mensaje,String mensajeError,Method validar){
        Double resultado;
        while(true){
            try{
                mostrarMensaje(mensaje);
                String dato= leerDato();
                resultado= Double.parseDouble(dato);
                if ((Boolean)validar.invoke((Object)dato)){
                    break;
                }
                mostrarMensaje(mensajeError);
            }
            catch(NumberFormatException error){
                mostrarMensaje("Formato de numero ingresado invalido");
            } catch (IllegalAccessException ex) {
                Logger.getLogger(Consola.class.getName()).log(Level.SEVERE, null, ex);
            } catch (IllegalArgumentException ex) {
                Logger.getLogger(Consola.class.getName()).log(Level.SEVERE, null, ex);
            } catch (InvocationTargetException ex) {
                Logger.getLogger(Consola.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return resultado;
    }
    private int obtenerInt(String mensaje,String mensajeError,Method validar){
        int resultado;
        while(true){
            try{
                mostrarMensaje(mensaje);
                String dato= leerDato();
                resultado= Integer.getInteger(dato);
                if ((Boolean)validar.invoke((Object)dato)){
                    break;
                }            
                mostrarMensaje(mensajeError);
            }
            catch(NumberFormatException error){
                mostrarMensaje("Formato de numero ingresado invalido");
            } catch (IllegalAccessException ex) {
                Logger.getLogger(Consola.class.getName()).log(Level.SEVERE, null, ex);
            } catch (IllegalArgumentException ex) {
                Logger.getLogger(Consola.class.getName()).log(Level.SEVERE, null, ex);
            } catch (InvocationTargetException ex) {
                Logger.getLogger(Consola.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return resultado;
    }
    private String obtenerString(String mensaje,String mensajeError,Method validar){
        String resultado;
        while(true){
            try{
                mostrarMensaje(mensaje);
                resultado= leerDato();
                if ((Boolean)validar.invoke((Object)resultado)){
                    break;
                }            
                mostrarMensaje(mensajeError);
            }
            catch(NumberFormatException error){
                mostrarMensaje("Formato de numero ingresado invalido");
            } catch (IllegalAccessException ex) {
                Logger.getLogger(Consola.class.getName()).log(Level.SEVERE, null, ex);
            } catch (IllegalArgumentException ex) {
                Logger.getLogger(Consola.class.getName()).log(Level.SEVERE, null, ex);
            } catch (InvocationTargetException ex) {
                Logger.getLogger(Consola.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return resultado;
    }
    private void mostrarOpciones(String[] opciones){
        String mensaje="Opciones: ";
        for (int contador=0;contador<opciones.length;contador++){
            mensaje+= (mensaje+1).toString()+"    "+opciones[contador];
        }
        mostrarMensaje(mensaje+"\n");
    }
    private String leerDato(){
        Scanner lector= new Scanner(System.in);
        String dato=lector.next();
        return dato;
    }
}
