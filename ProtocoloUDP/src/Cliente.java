import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.util.Scanner;

public class Cliente {

    public static void main(String[] args) throws IOException {

        Scanner mensaje=new Scanner(System.in);
        int puerto = 5000; //Número de puerto

        // Crear un socket UDP
        DatagramSocket socket = new DatagramSocket();

        while (true){
            // Dirección IP del servidor
            InetAddress direccionIP_servidor = InetAddress.getByName("172.31.118.92");


            // Mensaje para enviar
            String mensaje_cliente = mensaje.nextLine();

            // Arreglo de bytes para enviar los datos
            byte[] bufferSalida = mensaje_cliente.getBytes();

            // Crear paquete para enviar datos
            DatagramPacket paquete_enviar = new DatagramPacket(bufferSalida,
                    0, bufferSalida.length, direccionIP_servidor, puerto);

            // Enviar paquete
            socket.send(paquete_enviar);

            // Arreglos de bytes para recibir los datos
            byte[] bufferEntrada = new byte[1024];

            // Crear paquete para recibir datos
            DatagramPacket paquete_recibir = new DatagramPacket(bufferEntrada, 0, bufferEntrada.length);

            // Recibir paquete
            socket.receive(paquete_recibir);

            // Extraer la información del paquete
            String mensajeRecibido = new String(paquete_recibir.getData());
            System.out.println("Mensaje recibido: " + mensajeRecibido);
        }


    }
}
