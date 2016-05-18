import Modelo.Dolar;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Constructor;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Date;
public class Main {

    public static void main(String[] args) {
        System.out.println(Dolar.class.getName());
        double p=938383;
        Dolar d =(Dolar)instance("Modelo.Dolar", new Object[]{p,p,"dolares"});
        //socket();
        
    }
    static Object instance (String type,Object [] parametros ){
        Class h;
        try{
            h=Class.forName(type);
            Class[] tipos = new Class[parametros.length];
            for(int contador=0;contador< parametros.length;contador++){
                tipos[contador]=parametros[contador].getClass();
            }
            Constructor c=h.getConstructor(tipos);
            return c.newInstance(parametros);
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
        return null;
    }
    static void socket(){
        try{
            Socket socket = new Socket("localhost", 8666);
            BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            System.out.println(reader.readLine());
            return;
           

        } catch (IOException e) {
            System.err.println("Couldn't get I/O for "
                               + "the connection.");
        }
    }
}

