using System;

namespace LibreriaBitacora
{
    public class Bitacora
    {
        public void escribir(string monto, string interes, string periodo, string tipoMoneda, string SistemaAmortizacion, string nombreCliente)
        {
            ProductoAhorroDTO dto = new ProductoAhorroDTO(Double.Parse(monto), Double.Parse(interes), Int32.Parse(periodo), tipoMoneda, SistemaAmortizacion, nombreCliente);
            EscritorBitacora xml = new EscritorXML();
            EscritorBitacora csv = new EscritorCSV();
            xml.escribir(dto);
            csv.escribir(dto);
        }
    }
}
