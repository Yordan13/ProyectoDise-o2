package AdaptadorWebService;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.xml.parsers.ParserConfigurationException;
import org.xml.sax.SAXException;

public class WebServiceBCCR extends AdapterWebService {
    
    private String fechaActual;
    
    public WebServiceBCCR(String pOperacion) {
        super(pOperacion);
        this.url = Datos.Datos.obtenerDatoString("direcciones", "BancoCentral", "url");
        fechaActual = Util.Dates.getCurrentDate("dd/MM/yyyy");
        llenarParametros();
        prepararConsulta();
    }
    
    @Override
    public void llenarParametros() {
        this.parametros = Datos.Datos.obtenerDatosEnLista("direcciones", "BancoCentral", this.operacion);
    }
    
    @Override
    public void prepararConsulta() {
        String charset = "UTF-8";
        try {
            this.consulta = String.format(Datos.Datos.obtenerDatoString("direcciones", "BancoCentral", "formatoParametros"),
                    URLEncoder.encode(parametros.get(0), charset),
                    URLEncoder.encode(fechaActual, charset),
                    URLEncoder.encode(fechaActual, charset),
                    URLEncoder.encode(parametros.get(1), charset),
                    URLEncoder.encode(parametros.get(2), charset));
        } catch (UnsupportedEncodingException ex) {
            Logger.getLogger(WebServiceBCCR.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    @Override
    public ArrayList<String> consumirWebService() {
        ArrayList<String> resultado = null;
        String xmlDeWebService;
        try {
            xmlDeWebService = this.ejecutarConsulta();
            resultado = Util.XML_Util.parsearXML(parametros.get(3), xmlDeWebService);
        } catch (IOException ex) {
            Logger.getLogger(WebServiceBCCR.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ParserConfigurationException ex) {
            Logger.getLogger(WebServiceBCCR.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SAXException ex) {
            Logger.getLogger(WebServiceBCCR.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return resultado;
    }
}
