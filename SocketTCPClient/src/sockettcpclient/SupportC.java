package sockettcpclient;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Objects;

public class SupportC {

    protected File file1 = new File("File1.pdf");

    public Byte[] VolcarFichero() throws FileNotFoundException, IOException {
        Byte[] ficheroVolcado;
        try (
                DataInputStream dis = new DataInputStream(new FileInputStream(file1));) {
            int tamaño = (int) file1.length();
            ficheroVolcado = new Byte[tamaño];
            for (int i = 0; i < ficheroVolcado.length; i++) {
                ficheroVolcado[i] = dis.readByte();
            }
        }
        return ficheroVolcado;
    }

    public void EnviarFichero(DataOutputStream dosSocket, Byte[] ficheroVolcado, DataInputStream disSocket) throws IOException {
        Byte verificacion;
        int counter = 1000, tamaño;
        try {
            tamaño = ficheroVolcado.length;
            dosSocket.writeInt(tamaño);            
            for (int i = 0; i < ficheroVolcado.length; i++) {
                dosSocket.writeByte(ficheroVolcado[i]);                
                if (i == counter) {
                    verificacion = disSocket.readByte();                    
                }
                counter = counter + 1000;
            }
            if(ficheroVolcado[ficheroVolcado.length-1]==disSocket.readByte())
                System.out.println("Fichero enviado correctamente");
            
        } catch (IOException ex) {
            System.out.println("error 2: " + ex.getLocalizedMessage());
        }
    }

}
