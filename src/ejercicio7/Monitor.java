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

//Clase para monotorizar un mensaje de 1 solo buzon. Enviamos solo 1, y al leer, lo eliminamos dejando otra vez 1 hueco. 
public class Monitor { 

    static String mensaje = null; //Null == leido

    public synchronized void leyendo(String nombreHilo) {
        while(mensaje == null ) { //Si el mensaje está vacío, lo ponemos en espera al hilo. Sino es así, se dispone a leer. 
            try {
            wait(); //Pone en espera al hilo que llama al método leyendo() (Leer.java)
            } catch (InterruptedException ex) {
                ex.printStackTrace();
            }
        }
        System.out.println(">> Leyendo...");
        System.out.println("Mensaje leido por " + nombreHilo +" : " + mensaje); //Leemos el mensaje. 
        mensaje = null; //Lo marcamos como que ha sido leido, y por tanto, vuelve a estar vacio (nulo)
        System.out.println("Mensaje borrado. \n");
        notify(); //Desbloquea al primer hilo que encuentra que ha sido bloqueado por notify().

    }   

    public synchronized void enviando(String texto) {
     
        while(mensaje != null ) {  //Si el mensaje tiene contenido, ponemos en espera al hilo. Sino, se dispone a grabar. 
            try {  
            wait(); //Pone en espera al método que llama al método enviando() (Enviar.java)
            } catch (InterruptedException ex) {
               ex.printStackTrace();
            }
        }
        System.out.println(">> Enviando mensaje... ");
        this.mensaje = texto; //El mensaje tiene contenido, dejando de estar vacío (nulo).
        System.out.println("Mensaje enviado: " + mensaje + "\n");
        notify(); //Desbloquea al primer hilo que encuentra que ha sido bloqueado por notify().
    }
    

}
