
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.io.IOException;
import  java.net.SocketException;

public class ServidorUDP {


    public static void main(String[] args) throws IOException {

        int puerto = 500; //Número de puerto

        // Crear un socket UDP
        DatagramSocket socket = new DatagramSocket(puerto);

        // Arreglos de bytes para recibir los datos
        byte[] bufferEntrada = new byte[1024];

        // Crear paquete
        DatagramPacket paquete = new DatagramPacket(bufferEntrada, 0, puerto);

        // Recibir paquete
        socket.receive(paquete);

        // Iniciar un nuevo hilo para manejar solicitudes de clientes
        Thread hilo_cliente = new HiloCliente (socket,paquete);
        hilo_cliente.start();

    }
}