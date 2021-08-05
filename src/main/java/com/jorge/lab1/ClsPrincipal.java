/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jorge.lab1;

/**
 *
 * @author GAMERS
 */
public class ClsPrincipal {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        ClsProductos producto1=new ClsProductos().unidades(50).descripcion("Cemento").precio(60.0).peso(50.0).crear();
        ClsProductos producto2=new ClsProductos().unidades(150).descripcion("Cal").precio(40.0).peso(20.0).crear();
        ClsProductos producto3=new ClsProductos().unidades(200).descripcion("PVC").precio(55.0).peso(10.0).crear();
        ClsProductos producto4=new ClsProductos().unidades(50).descripcion("Hierro").precio(350.0).peso(50.0).crear();
        
        ClsProrrateo tabla = new ClsProrrateo(4);
        tabla.AgregarProducto(producto1);
        tabla.AgregarProducto(producto2);
        tabla.AgregarProducto(producto3);
        tabla.AgregarProducto(producto4);
        
        tabla.IngresarGastos();
        tabla.AnalizarDatos();
        tabla.imprimirDecorado();
    }
    
}
