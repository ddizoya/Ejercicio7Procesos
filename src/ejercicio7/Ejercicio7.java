/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejercicio7;

/**
 *
 * @author ddizoya
 */
public class Ejercicio7 {

    public static void main(String[] args) {
    	//Monitor que enviaremos a clase hilo.
        Monitor m = new Monitor();
        //Dos clases-hilo que envían mensajes, y dos que leen. (Extienden de Thread).
        new Enviar(m, "\n Primer hilo emisor").start();
        new Enviar(m, "\n Segundo hilo emisor").start();
        new Leer(m, "Primer lector").start();
        new Leer(m, "Segundo lector").start();   
        
       
       
    }

}
