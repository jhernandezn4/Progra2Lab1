/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jorge.lab1;

import java.util.Scanner;

/**
 *
 * @author GAMERS
 */
public class ClsProductos {
    /**
     * @return the unidades
     */
    public Integer getUnidades() {
        return unidades;
    }

    /**
     * @param unidades the unidades to set
     */
    public void setUnidades(int unidades) {
        this.unidades = unidades;
    }

    /**
     * @return the descripcion
     */
    public String getDescripcion() {
        return descripcion;
    }

    /**
     * @param descripcion the descripcion to set
     */
    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
    
    /**
     * @return the precio
     */
    public Double getPrecio() {
        return precio;
    }

    /**
     * @param precio the precio to set
     */
    public void setPrecio(Double precio) {
        this.precio = precio;
    }
    
    /**
     * @return the Peso
     */
    public Double getPeso() {
        return peso;
    }

    /**
     * @param Peso the Peso to set
     */
    public void setPeso(Double Peso) {
        this.peso = Peso;
    }

    
    private Integer unidades;
    private String descripcion;
    private Double precio;
    private Double peso;
   
    public ClsProductos(){
        
    }
    
    public void IngresarProducto(int unidades){
        Scanner t = new Scanner(System.in);
        System.out.println("Ingrese las unidades del producto: ");
        setUnidades(Integer.valueOf(t.nextLine()));
        System.out.println("Ingrese la descripción del producto: ");
        setDescripcion(t.nextLine());
        System.out.println("Ingrese el peso del producto (Kg): ");
        setPeso(Double.valueOf(t.nextLine()));
    }
    public ClsProductos unidades(int Unidades){
        this.setUnidades(Unidades);
        return this;
    }
    public ClsProductos descripcion(String Descripcion){
        this.setDescripcion(Descripcion);
        return this;
    }
    public ClsProductos precio(Double Precio){
        this.setPrecio(Precio);
        return this;
    }
    public ClsProductos peso(Double Peso){
        this.setPeso(Peso);
        return this;
    }
    public ClsProductos crear(){
        return this;
    }
}
