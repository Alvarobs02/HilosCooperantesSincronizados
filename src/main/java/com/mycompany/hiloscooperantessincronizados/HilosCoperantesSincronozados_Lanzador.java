/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.hiloscooperantessincronizados;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *Se encarga de crear el recurso compartido y los hilos 
 * pasando el rescurso conpartodo 
 * @author CES
 */
public class HilosCoperantesSincronozados_Lanzador {
   private static final int NUM_HILOS= 100;
   private static final int CUENTA_TOTAL= 100000;//100.000
   
   
    public static void main(String[] args) {
        //DECLARAR EL RECURSO CONPARTIDO --CONTADOR
        Contador contador = new Contador ();
        
        //Array para generar y controlar todos los hilos/Threads
        Thread[]hilos =new Thread[NUM_HILOS];
        
        for (int i = 0; i < NUM_HILOS; i++) {
            //crear el hilo ,le damos id de hilo asignamos
            //su parte de la cuenta total y 
            //Y LE PASAMOS EL RECURSO COMPARTIDO  
            Thread h =new Thread(new Hilo(i,CUENTA_TOTAL/NUM_HILOS,contador));
            //arranca el hilo
            h.start();
            
            //añadimo el hilo al array de "gestion"
            hilos[i]= h;
        }
            
            //ponemos al padre a esperar a la muerte de los hijos 
            for (Thread hilo : hilos) {
                try {
                    hilo.join();
                } catch (InterruptedException ex) {
                    Logger.getLogger(HilosCoperantesSincronozados_Lanzador.class.getName()).log(Level.SEVERE, null, ex);
                }
               
            }
            //una vez que los hijos han terminado y muerto 
            //revision el valor del contrador
            System.out.println("Cuenta toatal: "+contador.getCuenta());
            
        
        
    }
}
