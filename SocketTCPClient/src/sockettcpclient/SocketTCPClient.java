package sockettcpclient;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

public class SocketTCPClient {

    public static void main(String[] args) throws IOException {    
        Byte[] ficheroVolcado;
        try(
                Socket client = new Socket("localhost",5000);
                DataInputStream disSocket = new DataInputStream(client.getInputStream());
                DataOutputStream dosSocket = new DataOutputStream(client.getOutputStream());
                ){
            System.out.println("Soy el Cliente");
            SupportC otro = new SupportC();
            
            ficheroVolcado=otro.VolcarFichero();            
            otro.EnviarFichero(dosSocket, ficheroVolcado, disSocket);
            
            
        }
        
    }
    
}
