
package Factory;

import Datos.Datos;
import Modelo.Moneda;
import java.lang.reflect.InvocationTargetException;

public class FactoryMoneda {
    public static Moneda instanciar(String claseMoneda,Double monto,Double tipoCambio) throws Exception{
        Object[] parametros= new Object[]{monto,tipoCambio,claseMoneda};
        Instanciador<Moneda> instanciador= new InstanciadorReflexion<>();
        Class[] tiposDedatos = instanciador.getTipoDatos(parametros);
        String nombreClase= Datos.obtenerDatoString("moneda", claseMoneda);
        return instanciador.crear(tiposDedatos, parametros, nombreClase);
    }
    public static Moneda instanciar(String claseMoneda,Double monto) throws Exception{
        Object[] parametros= new Object[]{monto,claseMoneda};
        Instanciador<Moneda> instanciador= new InstanciadorReflexion<>();
        Class[] tiposDedatos = instanciador.getTipoDatos(parametros);
        String nombreClase= Datos.obtenerDatoString("moneda", claseMoneda);
        return instanciador.crear(tiposDedatos, parametros, nombreClase);
    }
}
