
package Vistas;

import Controlador.AbstractControlador;
import DTOSistemaAmortizacion.DtoSistema;
import Validar.Valida;
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
    public void crearSistema(){
        try {
            String nombre = obtenerString("Digite su nombre:\n", "Nombre ingresado invalido", 
                    Valida.class.getMethod("validaNombre",String.class));
            Double monto = obtenerDouble("Digite el monto del sistema de amortizacion:\n", "Monto insuficiente",
                    Valida.class.getMethod("validaMonto", Double.class));
            Integer periodo=obtenerInt("Digite el total de periodos:", "Monto ingresado invalido",
                    Valida.class.getMethod("validaPeriodos", Integer.class));
            Double interes = obtenerDouble("Digite la tasa de interes del sistema de amortizacion:\n", "Cantidad insuficiente",
                    Valida.class.getMethod("validaInteres", Double.class));
            int posicionSistema=obtenerInt("Seleccione el tipo de sistema:\n","Sistema de amortizacion inexistente",
                    Valida.class.getMethod("validaIdentificador", String.class,String.class,String.class),"sistema", sistemas);
            String sistema= sistemas[posicionSistema].toLowerCase();
            int posicionMoneda=obtenerInt("Seleccione el tipo de Moneda:\n","Tipo de moneda inexistente",
                    Valida.class.getMethod("validaIdentificador", String.class,String.class,String.class),"sistema", monedas);
            String moneda=monedas[posicionMoneda].toLowerCase();
            DtoSistema dto = new DtoSistema(monto, interes, periodo, moneda, sistema, nombre);
            controlador.crearSistemaAhorro(dto);
        } catch (NoSuchMethodException ex) {
            Logger.getLogger(Consola.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SecurityException ex) {
            Logger.getLogger(Consola.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    private Double obtenerDouble(String mensaje,String mensajeError,Method validar){
        Double resultado;
        while(true){
            try{
                mostrarMensaje(mensaje);
                String dato= leerDato();
                resultado= Double.parseDouble(dato);
                if ((Boolean)validar.invoke(null,new Object[]{resultado})){
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
        Integer resultado;
        while(true){
            try{
                mostrarMensaje(mensaje);
                String dato= leerDato();
                resultado= Integer.parseInt(dato);
                if ((Boolean)validar.invoke(null,new Object[]{resultado})){
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
    private int obtenerInt(String mensaje,String MensajeError,Method validar,String llave,String[] opciones){
        Integer resultado;
        while(true){
            try{
                mostrarMensaje(mensaje);
                mostrarOpciones(opciones);
                String dato= leerDato();
                resultado= Integer.parseInt(dato);
                if(resultado > opciones.length){
                    mostrarMensaje("Opcion elegida es incorrecta");
                }else{  
                    String id = opciones[resultado];
                    if ((Boolean)validar.invoke(null ,new Object[]{"identificadores",llave,id})){
                        break;
                    }else{                        
                        mostrarMensaje(MensajeError);
                    }
                }
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
                if ((Boolean)validar.invoke(null,new Object[]{resultado})){
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
