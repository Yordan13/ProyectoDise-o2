using System;
using System.Xml;
using System.Reflection;

namespace LibreriaBitacora
{
    public class EscritorXML : EscritorBitacora
    {
        private XmlDocument _documento;
        private string _nodoPrincipalEtiqueta;
        private string _etiquetaSeparadora;
        public EscritorXML()
        {
            _direccion = Environment.GetFolderPath(Environment.SpecialFolder.MyDocuments) + "/Bitacora.xml";
            _nodoPrincipalEtiqueta = "Bitacora";
            _etiquetaSeparadora = "Cuenta";

        }
        public override void escribir(ProductoAhorroDTO datos)
        {
            inicializarArchivoXML();
            XmlElement nodoPrincipal = obtenerNodoPrincipal(_nodoPrincipalEtiqueta);
            XmlElement nuevaCuenta = crearNodoConDatos(datos, _etiquetaSeparadora);
            nodoPrincipal = agregarHijo(nodoPrincipal, nuevaCuenta);
            agregarNodoDocumento(nodoPrincipal);
            guardarDocumento();
        }
        private XmlElement crearNodoConDatos(ProductoAhorroDTO datosConcretos, string etiqueta)
        {
            PropertyInfo[] datosDTO = informacionPropiedadesDTO();
            XmlElement nodoActual = crearNodo(etiqueta);
            foreach (PropertyInfo informacion in datosDTO)
            {
                string valor = Convert.ToString(informacion.GetValue(datosConcretos));
                string nombre = informacion.Name;
                XmlElement nuevoNodo = crearNodo(nombre);
                nuevoNodo = añadirValorNodo(nuevoNodo, valor);
                nodoActual = agregarHijo(nodoActual, nuevoNodo);
            }
            return nodoActual;
        }
        private void inicializarArchivoXML()
        {
            _documento = new XmlDocument();
            if (validarExistenciaArchivo(_direccion))
            {
                _documento.Load(_direccion);
            }
            else
            {
                agregarDeclaracion(_documento.CreateXmlDeclaration("1.0", "utf-8", "yes"));
                XmlElement primerNodo = crearNodo(_nodoPrincipalEtiqueta, _nodoPrincipalEtiqueta);
                agregarNodoDocumento(primerNodo);
            }
        }
        private XmlElement obtenerNodoPrincipal(string identificador)
        {
            string query = string.Format("//*[@id='{0}']", identificador);
            XmlElement nodo = (XmlElement)_documento.SelectSingleNode(query);
            return nodo;
        }
        private XmlElement crearNodo(string nombre)
        {
            XmlElement nuevoElemento = _documento.CreateElement(nombre);
            return nuevoElemento;
        }
        private XmlElement crearNodo(string nombre, string id)
        {
            XmlElement nuevoElemento = _documento.CreateElement(nombre);
            nuevoElemento.SetAttribute("id", id);
            return nuevoElemento;
        }
        private XmlElement añadirValorNodo(XmlElement nodo, string valor)
        {
            nodo.InnerText = valor;
            return nodo;
        }
        private void agregarNodoDocumento(XmlElement nodo)
        {
            _documento.AppendChild(nodo);
        }
        private XmlElement agregarHijo(XmlElement padre, XmlElement hijo)
        {
            padre.AppendChild(hijo);
            return padre;
        }
        private void agregarDeclaracion(XmlDeclaration encabezado) {
            _documento.AppendChild(encabezado);
        }
        private void guardarDocumento()
        {
            _documento.Save(_direccion);
        }
    }
}