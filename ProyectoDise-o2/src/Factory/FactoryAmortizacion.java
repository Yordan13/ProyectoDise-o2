
package Factory;

import Modelo.Cliente;
import Modelo.Moneda;
import Modelo.SistemaAmortizacion;
import java.lang.reflect.InvocationTargetException;


public class FactoryAmortizacion {
    public static SistemaAmortizacion instanciar(Cliente cliente,Moneda monto,
            Integer periodo,String fecha,double tasaInteres,String claseSistema) throws ClassNotFoundException, InstantiationException, NoSuchMethodException, IllegalAccessException, IllegalArgumentException, InvocationTargetException{
        Object[] parametros= new Object[]{cliente,monto,periodo,fecha,tasaInteres};
        Instanciador<SistemaAmortizacion> instanciador= new Instanciador<>();
        Class[] tiposDedatos = instanciador.getTipoDatos(parametros);
        return instanciador.crear(tiposDedatos, parametros, claseSistema);
    }
}
