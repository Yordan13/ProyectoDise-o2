
package Controlador;

import DTOSistemaAmortizacion.DtoSistema;
import Factory.FactoryAmortizacion;
import Factory.FactoryCliente;
import Factory.FactoryMoneda;
import Modelo.Cliente;
import Modelo.Moneda;
import Modelo.SistemaAmortizacion;
import Vistas.Vista;
import java.util.logging.Level;
import java.util.logging.Logger;


public class AbstractControlador {
    Vista vista;
    public AbstractControlador(Vista vista) {
        this.vista=vista;
        init();
    }
    private void init(){}
    public void crearSistemaAhorro(DtoSistema dto){
        try {
            Moneda moneda= FactoryMoneda.instanciar(dto.getTipoMoneda(), dto.getMonto(), 530.0);
            Cliente cliente = FactoryCliente.instanciar(dto.getNombreCliente(), "persona");
            SistemaAmortizacion sistema = FactoryAmortizacion.instanciar(cliente, moneda, dto.getPeriodo(), "17/8/9", dto.getInteres(), dto.getSistemaAmortizacion());
            sistema.generarCuotas();
            DtoSistema nuevoDto=sistema.getDTO();
            actualizarBitacora(nuevoDto);
            actualizarVista(nuevoDto);
        } catch (Exception ex) {
            return;
        }
        
    }
    private void actualizarVista(DtoSistema dto){}
    private void actualizarBitacora(DtoSistema dto){}
}
