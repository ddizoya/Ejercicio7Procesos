/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejercicio7;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author ddizoya
 */

//Clase Enviar --> Productor 
public class Enviar extends Thread{ //Extendemos de Thread, para tener todos los métodos de los hilos. 
    Monitor monitor;
    
    public Enviar(Monitor monitor, String nombre) {
        this.monitor = monitor; //Le pasamos el monitor común desde el main()
        super.setName(nombre); //Le damos un nombre al hilo que le pasamos desde el main para saber quién lee y quien no. 

    }
    
    @Override
    public void run() {
        int i = 0; //Un contador. 
       while (true){
            try {
                monitor.enviando(getName() +" dice: " + "Hola" + " x " + i); //Enviamos el mensaje del tipo messenger. Le pasamos el nombre del objeto de esta clase + mensaje + contador
                i++; //Lo empleamos para contabilidad que realmente iteramos infinitamente, y no es que se repita el mismo mensaje una y otra vez. 
                sleep(1000); //Una vez ejecutado este método, esperamos 1 segundo. Facilita la visión de las impresiones y de dónde vienen.
            } catch (InterruptedException ex) {
                Logger.getLogger(Enviar.class.getName()).log(Level.SEVERE, null, ex);
            }
       }
    }
}
