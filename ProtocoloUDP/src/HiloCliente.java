import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.Inet4Address;
import java.net.InetAddress;

public class HiloCliente extends Thread{
    private DatagramSocket socket;
    private DatagramPacket paquete;

    // Constructor
    public HiloCliente(DatagramSocket socket, DatagramPacket paquete){
        this.socket = socket;
        this.paquete =paquete;
    }

    public void run(){


        // Extraer la información del paquete
        String mensajeRecibido = new String(paquete.getData());
        System.out.println("Mensaje recibido: " + mensajeRecibido);

        // Obtener la dirección del cliente (dirección de origen)
        InetAddress direccionIP_cliente = paquete.getAddress();
        int puerto_cliente = paquete.getPort();


        // Mensaje de respuesta
        String respuesta = "Hola, soy el servidor";

        // Arreglos de bytes para recibir los datos
        byte[] bufferSalida = respuesta.getBytes();

        // Crear paquete
        DatagramPacket paquete_respuesta = new DatagramPacket(bufferSalida, 0, bufferSalida.length, direccionIP_cliente, puerto_cliente);

        // Enviar el Datagrama
        try {
            socket.send(paquete_respuesta);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
}
