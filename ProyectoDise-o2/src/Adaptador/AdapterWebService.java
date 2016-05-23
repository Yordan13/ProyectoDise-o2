package Adaptador;

import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.Scanner;

public abstract class AdapterWebService {
    
    protected String url;
    protected String operacion;
    protected String consulta;
    protected ArrayList<String> parametros;
    
    public AdapterWebService(String pOperacion) {
        this.operacion = pOperacion;
    }
    
    protected String ejecutarConsulta() throws MalformedURLException, IOException {
        URLConnection connection = new URL(url + "?" + consulta).openConnection();
        connection.setRequestProperty("Accept-Charset", "UTF-8");
        InputStream response = connection.getInputStream();
        Scanner scanner = new Scanner(response);
        return  scanner.useDelimiter("\\A").next();
    }
    
    protected abstract void prepararConsulta();
    protected abstract void llenarParametros();
    public abstract ArrayList<String> consumirWebService();
    
}
