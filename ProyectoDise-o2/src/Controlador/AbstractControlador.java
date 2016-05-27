
package Controlador;

import AdaptadorSocket.AdapterSocket;
import AdaptadorSocket.PythonSocket;
import AdaptadorWebService.AdapterWebService;
import AdaptadorWebService.WebServiceBCCR;
import DTOSistemaAmortizacion.DtoSistema;
import Datos.Datos;
import Factory.FactoryAmortizacion;
import Factory.FactoryCliente;
import Factory.FactoryMoneda;
import Modelo.Cliente;
import Modelo.Moneda;
import Modelo.SistemaAmortizacion;
import Vistas.Vista;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.json.simple.parser.ParseException;


public class AbstractControlador {
    Vista vista;
    public AbstractControlador(Vista vista) {
        this.vista=vista;
        init();
    }
    private void init(){
        try {
            Datos.inicializar();
        } catch (IOException error) {
            vista.mostrarMensaje(error.getMessage());
        } catch (ParseException error) {
            vista.mostrarMensaje(error.getMessage());
        }
    }
    public void crearSistemaAhorro(DtoSistema dto){
        try {
            Moneda moneda= FactoryMoneda.instanciar(dto.getTipoMoneda(), dto.getMonto(), Double.parseDouble(obtenerTipoCambio()));
            Cliente cliente = FactoryCliente.instanciar(dto.getNombreCliente(), "persona");
            SistemaAmortizacion sistema = FactoryAmortizacion.instanciar(cliente, moneda, dto.getPeriodo(), obtenerFechaServidor(), dto.getInteres(), dto.getSistemaAmortizacion());
            sistema.generarCuotas();
            DtoSistema nuevoDto=sistema.getDTO();
            actualizarBitacora(dto);
            actualizarVista(nuevoDto);
        } catch (Exception error) {
            vista.mostrarMensaje(error.getMessage());
        }
        
    }
    private String obtenerFechaServidor() {
        AdapterSocket fechaServidor = new PythonSocket(Datos.obtenerDatoString("direcciones", "chucky", "direccion"), Datos.obtenerDatoInteger("direcciones", "chucky", "puerto"));
        return fechaServidor.obtenerRespuestaSocket();
    }
    private String obtenerTipoCambio() {
        AdapterWebService tipoCambioServidor = new WebServiceBCCR("tipoCambio");
        return tipoCambioServidor.consumirWebService().get(0);
    }
    private void actualizarVista(DtoSistema dto){
        vista.mostrarInformacion(dto);
    }
    private void actualizarBitacora(DtoSistema dto){
        System.loadLibrary("cppLibreriaBitacora");
        this.escribir(String.valueOf(dto.getMonto()),String.valueOf(dto.getInteres()), String.valueOf(dto.getPeriodo()), 
                dto.getTipoMoneda(), dto.getSistemaAmortizacion(), dto.getNombreCliente());
    }
    private native void escribir(String monto, String interes, String periodo, String tipoMoneda, String SistemaAmortizacion, String nombreCliente);
}
