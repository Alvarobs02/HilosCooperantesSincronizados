/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.hiloscooperantessincronizados;

/**
 *Recurso Compartdo 
 * @author CES
 */
public class Contador {
    private int cuenta=0;

    public int getCuenta() {
        return cuenta;
    }
    
   synchronized public int incrementa(){
    this.cuenta++;
    return cuenta;
    }
}
