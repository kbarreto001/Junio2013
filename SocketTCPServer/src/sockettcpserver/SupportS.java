package sockettcpserver;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.util.Objects;

public class SupportS {

    public void EnviarFichero(DataOutputStream dosSocket, Byte[] ficheroVolcado, DataInputStream disSocket) throws IOException {
        Byte verificacion;
        int counter = 1000;
        try {
            for (int i = 0; i < ficheroVolcado.length; i++) {
                dosSocket.writeByte(ficheroVolcado[i]);
                if (i == counter) {
                    if (Objects.equals(verificacion = disSocket.readByte(), ficheroVolcado[i])) {
                        System.out.println("Se ha enviado bien: " + counter);
                    }
                    counter = counter + 1000;
                }
            }
        } catch (IOException ex) {
            System.out.println("error 2: " + ex.getLocalizedMessage());
        }
    }

    public Byte[] RecibirFichero(DataOutputStream dosSocket, DataInputStream disSocket) throws IOException {
        Byte verificacion;
        int counter = 1000, tamaño;
        Byte[] ficheroVolcado = null;
        try {
            tamaño = disSocket.readInt();
            System.out.println("Tamaño fichero: " + tamaño);
            ficheroVolcado = new Byte[tamaño];
            for (int i = 0; i < ficheroVolcado.length; i++) {
                ficheroVolcado[i] = disSocket.readByte();
                if (i == counter) {
                    dosSocket.writeByte(ficheroVolcado[i]);
                }
                counter = counter + 1000;
            }
            dosSocket.writeByte(ficheroVolcado[ficheroVolcado.length - 1]);
        } catch (IOException ex) {
            System.out.println("error 2: " + ex.getLocalizedMessage());
        }

        return ficheroVolcado;
    }

    public Byte[] Algoritmo(Byte[] ficheroVolcado) {
        int paq = 0;
        Byte[] deco = new Byte[ficheroVolcado.length];
        
        


    }

}
