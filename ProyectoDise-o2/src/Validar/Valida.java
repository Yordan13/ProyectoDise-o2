
package Validar;

import Datos.Datos;


public class Valida {
    public static Boolean validaMonto(Double monto){
        return monto>Datos.obtenerDatoDouble("montoMinimoSistema");
    }
    public static Boolean validaInteres(Double tasaInteres){
        return tasaInteres>Datos.obtenerDatoDouble("tasaInteresMinimo");
    }
    public static Boolean validaNombre(String nombre){
        return nombre.length()>0;
    }
    public static Boolean validaIdentificador(String identifacor,String tipo, String llave){
        return Datos.validarLlave(identifacor,tipo, llave);
    }
}
