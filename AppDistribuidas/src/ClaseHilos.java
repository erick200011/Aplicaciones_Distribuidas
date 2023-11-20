// Proceso principal

import java.util.logging.Logger;

public class ClaseHilos {
    public static void main(String[] args) {

        //Crear una instancia del hilo1 e hilo 2
        Hilos hilo1 = new Hilos(1);
        Hilos hilo2 = new Hilos(2);

        hilo1.start();
        hilo2.start();






        // Programa principal
        System.out.println("programa principal");

    }

}