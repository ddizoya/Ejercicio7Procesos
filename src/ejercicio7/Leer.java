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

//Clase Leer --> Consumidor
public class Leer extends Thread{ //Extendemos de Thread, para tener todos los m�todos de los hilos. 
    Monitor monitor; 
    
    public Leer(Monitor monitor, String nombre) {
        this.monitor = monitor; //Le pasamos el monitor com�n desde el main()
        super.setName(nombre); //Le damos un nombre al hilo que le pasamos desde el main para saber qui�n lee y quien no. 

    }

    @Override
    public void run() { 
       while (true){
           try {
               monitor.leyendo(getName()); //Leemos el mensaje. Le pasamos el nombre que le hemos dado al objeto de esta clase para diferenciarlos. 
               sleep(1000); //Una vez ejecutado este m�todo, esperamos 1 segundo. Facilita la visi�n de las impresiones y de d�nde vienen.
           } catch (InterruptedException ex) {
               Logger.getLogger(Leer.class.getName()).log(Level.SEVERE, null, ex);
           }
       }
    }
    
}
