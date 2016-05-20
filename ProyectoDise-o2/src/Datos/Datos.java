package Datos;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;


public class Datos {
    private static JSONObject datos;
    public static void inicializar() throws FileNotFoundException, IOException, ParseException{
        String direccion ="..\\ProyectoDise-o2\\config.json";
        JSONParser parseador= new JSONParser();
        FileReader archivo = new FileReader(direccion);
        Object objectoJson = parseador.parse(archivo);
        datos=(JSONObject)objectoJson;
    }
    public static String obtenerDatoString(String tipo,String llave){
        JSONObject informacion=(JSONObject) datos.get("identificadores");
        informacion=(JSONObject) informacion.get(tipo);
        return (String)informacion.get(llave);
    }
    public static Double obtenerDatoDouble(String llave){
        return (Double) datos.get(llave);
    }
    public static Boolean validarLlave(String tipo, String llave){
        JSONObject informacion=(JSONObject) datos.get("identificadores");
        informacion=(JSONObject) informacion.get(tipo);
        return informacion.containsKey(llave);
    }
}
