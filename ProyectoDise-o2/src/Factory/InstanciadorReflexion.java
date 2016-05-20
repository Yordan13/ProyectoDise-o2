
package Factory;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

public class InstanciadorReflexion<T> extends Instanciador<T>{

    public InstanciadorReflexion(){
    }
    @Override
    public Class[] getTipoDatos(Object[] parametros){
       Class[] tipos = new Class[parametros.length];
        for(int contador=0;contador< parametros.length;contador++){
            tipos[contador]=parametros[contador].getClass();
        } 
        return tipos;
    }
    @Override
    public T crear(Class[] tiposParametros, Object[] parametros,String tipo) throws ClassNotFoundException, InstantiationException, NoSuchMethodException, IllegalAccessException, IllegalArgumentException, InvocationTargetException{
        Class clase =Class.forName(tipo);
        tiposParametros = ajustarParametros(clase.getConstructors(), tiposParametros);
        Constructor constructor=clase.getConstructor(tiposParametros);
        return (T)constructor.newInstance(parametros);
    }
    private Class[] ajustarParametros(Constructor[] constructores, Class[] parametros){
        for(Constructor constructor:constructores){
            Class[] parametrosActual = constructor.getParameterTypes();
            if (parametrosActual.length==parametros.length){
                Class[] resultado = new Class[parametros.length];
                resultado=validaParametros(parametros, parametrosActual);
                if (!resultado.equals(null)){
                    return resultado;
                }
            }
        }
        return null;
    }
    private Class[] validaParametros(Class[] parametros,Class[] parametrosActual){
        int totalElementos=parametros.length;
        Class[] resultado=new Class[totalElementos];
        for(int contador=0;contador<totalElementos;contador++){
            if (parametros[contador].equals(parametrosActual[contador])){
                resultado[contador]=parametros[contador];
            }else if(esSubclass(parametros[contador], parametrosActual[contador])){
                resultado[contador]=parametros[contador].getSuperclass();
            }else{
                return null;
            }
        }
        return resultado; 
    }
    private Boolean esSubclass(Class tipo1,Class tipo2){
        return tipo1.getSuperclass().equals(tipo2);
    }
}
