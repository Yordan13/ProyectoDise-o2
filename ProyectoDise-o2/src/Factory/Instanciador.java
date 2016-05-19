
package Factory;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;


public class Instanciador<T> {

    public Instanciador() {
    }
    public Class[] getTipoDatos(Object[] parametros){
       Class[] tipos = new Class[parametros.length];
        for(int contador=0;contador< parametros.length;contador++){
            tipos[contador]=parametros[contador].getClass();
        } 
        return tipos;
    }
    public T crear(Class[] tiposParametros, Object[] parametros,String tipo) throws ClassNotFoundException, InstantiationException, NoSuchMethodException, IllegalAccessException, IllegalArgumentException, InvocationTargetException{
        Class clase =Class.forName(tipo);
        Constructor constructor=clase.getConstructor(tiposParametros);
        return (T)constructor.newInstance(parametros);
    }
}
