package sockettcpserver;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class SocketTCPServer {

    public static void main(String[] args) throws IOException {
        int counter = 1, size = 1000;
        Byte[] ficheroVolcado;
        System.out.println("Soy el Servidor");
        try {
            ServerSocket server = new ServerSocket(5000, size);
            while (true) {
                Socket connection = server.accept();
                DataInputStream disSocket = new DataInputStream(connection.getInputStream());
                DataOutputStream dosSocket = new DataOutputStream(connection.getOutputStream());

                System.out.println("Conexion No." + counter + " Recibida de: " + connection.getInetAddress().getHostName());
                
                SupportS otro = new SupportS();
                
                ficheroVolcado=otro.RecibirFichero(dosSocket, disSocket);
                    
                
                connection.close();
                disSocket.close();
                dosSocket.close();
                counter++;

            }
        } catch (IOException ex) {
            System.out.println("error1: " + ex.getLocalizedMessage());
        }

    }

}
