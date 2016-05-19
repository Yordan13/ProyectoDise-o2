
package Factory;

import Modelo.Cliente;
import java.lang.reflect.InvocationTargetException;

public class FactoryCliente {
    public static Cliente instanciar(String nombre,String claseCliente) throws ClassNotFoundException, InstantiationException, NoSuchMethodException, IllegalAccessException, IllegalArgumentException, InvocationTargetException{
        Object[] parametros= new Object[]{nombre};
        Instanciador<Cliente> instanciador= new Instanciador<>();
        Class[] tiposDedatos = instanciador.getTipoDatos(parametros);
        return instanciador.crear(tiposDedatos, parametros, claseCliente);
    }
}
