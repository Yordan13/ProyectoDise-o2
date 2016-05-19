
package Factory;

import Modelo.Moneda;
import java.lang.reflect.InvocationTargetException;

public class FactoryMoneda {
    public static Moneda instanciar(String claseMoneda,Double monto,Double tipoCambio) throws ClassNotFoundException, InstantiationException, NoSuchMethodException, IllegalAccessException, IllegalArgumentException, InvocationTargetException{
        Object[] parametros= new Object[]{monto,tipoCambio,claseMoneda};
        Instanciador<Moneda> instanciador= new Instanciador<>();
        Class[] tiposDedatos = instanciador.getTipoDatos(parametros);
        return instanciador.crear(tiposDedatos, parametros, claseMoneda);
    }
    public static Moneda instanciar(String claseMoneda,Double monto) throws ClassNotFoundException, InstantiationException, NoSuchMethodException, IllegalAccessException, IllegalArgumentException, InvocationTargetException{
        Object[] parametros= new Object[]{monto,claseMoneda};
        Instanciador<Moneda> instanciador= new Instanciador<>();
        Class[] tiposDedatos = instanciador.getTipoDatos(parametros);
        return instanciador.crear(tiposDedatos, parametros, claseMoneda);
    }
}
