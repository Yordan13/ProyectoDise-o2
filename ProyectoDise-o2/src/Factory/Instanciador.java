
package Factory;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;


public abstract class Instanciador<T> {

    public Instanciador() {
    }
    public abstract Class[] getTipoDatos(Object[] parametros);
    public abstract T crear(Class[] tiposParametros, Object[] parametros,String tipo)throws Exception;
}
