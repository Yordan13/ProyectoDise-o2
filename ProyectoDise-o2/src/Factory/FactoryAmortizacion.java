
package Factory;

import Datos.Datos;
import Modelo.Cliente;
import Modelo.Moneda;
import Modelo.SistemaAmortizacion;
import java.lang.reflect.InvocationTargetException;


public class FactoryAmortizacion {
    public static SistemaAmortizacion instanciar(Cliente cliente,Moneda monto,
            Integer periodo,String fecha,double tasaInteres,String claseSistema) throws Exception{
        Object[] parametros= new Object[]{cliente,monto,periodo,fecha,tasaInteres,claseSistema};
        Instanciador<SistemaAmortizacion> instanciador= new InstanciadorReflexion<>();
        Class[] tiposDedatos = instanciador.getTipoDatos(parametros);
        String nombreClase= Datos.obtenerDatoString("identificadores","sistema", claseSistema);
        return instanciador.crear(tiposDedatos, parametros, nombreClase);
    }
}
