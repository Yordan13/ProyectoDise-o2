
package Vistas;

import DTOSistemaAmortizacion.DtoSistema;

public interface Vista {
    public void mostrarMensaje(String mensaje);
    public void mostrarInformacion(DtoSistema dto);
}
