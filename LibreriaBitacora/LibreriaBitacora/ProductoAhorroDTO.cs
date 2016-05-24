using System;
using System.Globalization;

namespace LibreriaBitacora
{
    public class ProductoAhorroDTO
    {
        private string _nombreCliente;
        private double _monto;
        private int _periodo;
        private string _sistema;
        private double _interes;
        private string _tipoMoneda;


        public string NombreCliente { get { return _nombreCliente; }}
        public double Monto{ get{ return _monto; }}
        public int Periodo { get { return _periodo; }}
        public string Sistema { get { return _sistema; }}
        public double Interes { get { return _interes; }}
        public string TipoMoneda { get { return _tipoMoneda; }}

        public ProductoAhorroDTO(double monto, double interes, int periodo, 
            string tipoMoneda, string sistema, string nombre)
        {
            _nombreCliente = nombre;
            _monto = monto;
            _periodo = periodo;
            _sistema = sistema;
            _interes = interes;
            _tipoMoneda = tipoMoneda;
        }
    }
}
