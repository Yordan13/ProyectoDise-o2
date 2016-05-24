using System.IO;
using System.Reflection;

namespace LibreriaBitacora
{
    public abstract class EscritorBitacora
    {
        protected string _direccion;

        public abstract void escribir(ProductoAhorroDTO datos);

        protected bool validarExistenciaArchivo(string direccion)
        {
            return File.Exists(direccion);
        }

        protected PropertyInfo[] informacionPropiedadesDTO()
        {
            return typeof(ProductoAhorroDTO).GetProperties();
        }
    }
}