package simple5;

import java.io.*;
import java.net.*;
import java.util.Scanner;

public class Client {
    public static void main(String[] args) throws Exception {
        // Crea un objeto Socket y se conecta al servidor en el puerto 2022
        Socket socket = new Socket("localhost", 2022);

        // Crea los objetos DataInputStream y DataOutputStream para enviar y recibir datos del servidor
        DataInputStream inputStream = new DataInputStream(socket.getInputStream());
        DataOutputStream outputStream = new DataOutputStream(socket.getOutputStream());

        // Pide al usuario que ingrese 3 números para enviar al servidor
        Scanner scanner = new Scanner(System.in);
        System.out.print("Ingresa el primer número: ");
        int numero1 = scanner.nextInt();
        System.out.print("Ingresa el segundo número: ");
        int numero2 = scanner.nextInt();
        System.out.print("Ingresa el tercer número: ");
        int numero3 = scanner.nextInt();

        // Envía los 3 números al servidor
        outputStream.writeInt(numero1);
        outputStream.writeInt(numero2);
        outputStream.writeInt(numero3);

        // Lee la respuesta del servidor y la imprime en la consola
        int mayor = inputStream.readInt();
        System.out.println("El número mayor es: " + mayor);

        // Cierra el socket
        socket.close();
    }
}



