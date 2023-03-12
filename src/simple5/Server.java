package simple5;

import java.io.*;
import java.net.*;

public class Server {
    public static void main(String[] args) throws Exception {
        // Crea un objeto ServerSocket en el puerto 2022
        ServerSocket serverSocket = new ServerSocket(2022);

        // Espera a que un cliente se conecte al servidor
        Socket clientSocket = serverSocket.accept();

        // Crea los objetos DataInputStream y DataOutputStream para enviar y recibir datos del cliente
        DataInputStream inputStream = new DataInputStream(clientSocket.getInputStream());
        DataOutputStream outputStream = new DataOutputStream(clientSocket.getOutputStream());

        // Lee los 3 números enviados por el cliente
        int numero1 = inputStream.readInt();
        int numero2 = inputStream.readInt();
        int numero3 = inputStream.readInt();

        // Determina cuál es el mayor de los 3 números
        int mayor = Math.max(Math.max(numero1, numero2), numero3);

        // Envía el número mayor al cliente
        outputStream.writeInt(mayor);

        // Cierra el socket del servidor
        serverSocket.close();
    }
}




