package Datos;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import org.json.simple.JSONArray;
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
    public static String obtenerDatoString(String identificador,String tipo,String llave){
        JSONObject informacion=(JSONObject) datos.get(identificador);
        informacion=(JSONObject) informacion.get(tipo);
        return (String)informacion.get(llave);
    }
    public static Double obtenerDatoDouble(String llave){
        return (Double) datos.get(llave);
    }
    public static Integer obtenerDatoInteger(String llave) {
        Long r = (Long) datos.get(llave);
        return r.intValue();
    }
    public static Integer obtenerDatoInteger(String identificador,String tipo,String llave) {
        JSONObject informacion = (JSONObject) datos.get(identificador);
        informacion = (JSONObject) informacion.get(tipo);
        Long resultado = (Long) informacion.get(llave);
        return resultado.intValue();
    }
    
    public static ArrayList<String> obtenerDatosEnLista(String identificador, String tipo, String llave) {
        JSONObject informacion = (JSONObject) datos.get(identificador);
        informacion = (JSONObject) informacion.get(tipo);
        JSONArray ArrayInformacion = (JSONArray) informacion.get(llave);
        ArrayList<String> listaDatos = Util.JSON_Util.jsonTOList(ArrayInformacion);
        return listaDatos;
    }

    
    public static Boolean validarLlave(String identificador,String tipo, String llave){
        JSONObject informacion=(JSONObject) datos.get(identificador);
        informacion=(JSONObject) informacion.get(tipo);
        return informacion.containsKey(llave);
    }
}
