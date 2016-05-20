
package Factory;

import Datos.Datos;
import Modelo.Cliente;
import java.lang.reflect.InvocationTargetException;

public class FactoryCliente {
    public static Cliente instanciar(String nombre,String claseCliente) throws Exception{
        Object[] parametros= new Object[]{nombre};
        Instanciador<Cliente> instanciador= new InstanciadorReflexion<>();
        Class[] tiposDedatos = instanciador.getTipoDatos(parametros);
        String nombreClase= Datos.obtenerDatoString("cliente", claseCliente);
        return instanciador.crear(tiposDedatos, parametros, nombreClase);
    }
}
