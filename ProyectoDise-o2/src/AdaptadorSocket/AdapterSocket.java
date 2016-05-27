package AdaptadorSocket;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;

public abstract class AdapterSocket {
    
   protected String direccionIP; 
   protected int puerto;
   protected String respuestaSocket;
   
   public AdapterSocket(String pDireccionIP, int pPuerto) {
       this.direccionIP = pDireccionIP;
       this.puerto = pPuerto;
   }
   
    protected void conectarSocket() {
        try {
            respuestaSocket = "";
            Socket socket = new Socket(direccionIP, puerto);
            BufferedReader lector = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            Object[] lista = lector.lines().toArray();
            for (Object iterador : lista) {
                respuestaSocket += (String) iterador;
            }
        } catch (IOException e) {
            System.err.println("No se puede conectar al Socket");
        }
    }
   public String obtenerRespuestaSocket() {
       conectarSocket();
       return respuestaSocket;
   }
}
