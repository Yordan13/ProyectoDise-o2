using System;
using System.Text;
using System.Reflection;
using System.IO;

namespace LibreriaBitacora
{
    public class EscritorCSV : EscritorBitacora
    {
        private char _caracteresEspecialPuntoyComa;
        private char _caracteresEspecialComilla;
        private StringBuilder _lineaActual;
        private StreamWriter _escritor;

        public EscritorCSV()
        {
            _direccion = Environment.GetFolderPath(Environment.SpecialFolder.MyDocuments) + "/Bitacora.csv";
            _lineaActual = new StringBuilder();
            _caracteresEspecialComilla = '\"';
            _caracteresEspecialPuntoyComa = ';';
        }
        public override void escribir(ProductoAhorroDTO datos)
        {
            inicializarArchivoCsv();
            agregarDatosDTO(datos);
            cerrarEscritor();
        }
        private void inicializarArchivoCsv()
        {
            //En esta funcion, se llama dos veces al inicializadorEscritor, pues el crea el archivo al mismo
            //tiempo que instancia este objeto, lo cual es necesario para validar la existencia del archivo
            if (validarExistenciaArchivo(_direccion))
            {
                inicializarEscritor();
            }
            else
            {
                inicializarEscritor();
                agregarEncabezado();
                guardarLinea();
            }
        }
        private void agregarDatosDTO(ProductoAhorroDTO datosConcretos)
        {
            PropertyInfo[] datosObjetosDTO = informacionPropiedadesDTO();
            foreach (PropertyInfo informacion in datosObjetosDTO)
            {
                string valor = Convert.ToString(informacion.GetValue(datosConcretos));
                agregarCasilla(valor);
            }
            guardarLinea();
        }
        private void agregarEncabezado()
        {
            PropertyInfo[] datosObjetosDTO = informacionPropiedadesDTO();
            foreach (PropertyInfo informacion in datosObjetosDTO)
            {
                agregarCasilla(informacion.Name);
            }
        }
        private void agregarCasilla(string casilla)
        {
            casilla = repararFormatoCasilla(casilla);
            agregarNuevaCasillaBuffer(casilla);
        }
        private void agregarNuevaCasillaBuffer(string casilla)
        {
            if (_lineaActual.Length == 0)
            {
                _lineaActual.Append(casilla);
            }
            else
            {
                _lineaActual.Append(";" + casilla);
            }
        }
        private string repararFormatoCasilla(string casilla)
        {            
            if (validarCaracterCasilla(casilla, _caracteresEspecialComilla))
            {
                casilla = casilla.Replace("\"", "\"\"");
            }
            if (validarCaracterCasilla(casilla, _caracteresEspecialPuntoyComa))
            {
                casilla = "\""+casilla+"\"";
            }
            return casilla;
        }
        private bool validarCaracterCasilla(string casilla,char caracter)
        {
            return casilla.IndexOf(caracter) != -1;
        }
        private void guardarLinea()
        {
            string linea = _lineaActual.ToString();
            _escritor.WriteLine(linea);
            _lineaActual = new StringBuilder();
        }
        private void inicializarEscritor()
        {
            _escritor = File.AppendText(_direccion);

        }
        private void cerrarEscritor()
        {
            _escritor.Close();
        }
    }
}