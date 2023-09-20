/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.hiloscooperantessincronizados;

/**
 *Objeto Hilo Implementa Runnable
 * @author CES
 */
public class Hilo implements Runnable{

    int numHilo,miParte,miCuenta= 0;
    private final Contador contador ;

    public Hilo(int numHilo, int miParte, Contador contador) {
        this.numHilo = numHilo;
        this.miParte = miParte;
        this.contador = contador;
    }
    
    
    @Override
    public void run() {//el men del hijo 
        for (int i = 0; i < miParte; i++) {
            this.contador.incrementa();
            //System.out.println(""+numHilo+":"+contador.getClass());
            miCuenta++;
        }
        System.out.println("\t\t\t"+numHilo +":he añadido "+miCuenta);
    }
    
}
