
/**
 *
 * @author Leonel Londoño Y Erika Gonzalez
 */

    package Conexion;

import Entidades.Broker;
import java.io.DataInputStream;
import java.io.DataOutput;
import java.io.DataOutputStream;
    import java.io.IOException;
    import java.net.ServerSocket;
    import java.net.Socket;
import java.net.SocketAddress;
import java.util.Observable;
import java.util.logging.Level;
import java.util.logging.Logger;

    public class ConexionServidor extends  Observable implements Runnable {
      
        private int puerto;
       public ConexionServidor(int puerto){
           this.puerto= puerto; 
           
       }
        
    public void run()
    {
    ServerSocket servidor = null;
    Socket sock = null;
    DataInputStream entrada;
  
    try
    {   
        servidor = new ServerSocket(puerto);
        while(true)
        {
              sock = servidor.accept();
        entrada = new DataInputStream(sock.getInputStream());
      
        String recibir = entrada.readUTF(); 
      this.setChanged();
       this.notifyObservers(recibir);
       this.clearChanged();
        
      sock.close();
        
        
        }
      
    }catch(IOException excep)
    {
         Logger.getLogger(ConexionServidor.class.getName()).log(Level.SEVERE, null, excep);
    }
    }
    }
