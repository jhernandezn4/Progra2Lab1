/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jorge.lab1;

import java.text.DecimalFormat;
import java.util.Scanner;

/**
 *
 * @author GAMERS
 */
public class ClsProrrateo {

    /**
     * @return the fletes
     */
    public Double getFlete() {
        return flete;
    }

    /**
     * @param fletes the fletes to set
     */
    public void setFlete(Double fletes) {
        this.flete = fletes;
    }

    /**
     * @return the Acarreo
     */
    public Double getAcarreo() {
        return acarreo;
    }

    /**
     * @param Acarreo the Acarreo to set
     */
    public void setAcarreo(Double Acarreo) {
        this.acarreo = Acarreo;
    }

    /**
     * @return the seguro
     */
    public Double getSeguro() {
        return seguro;
    }

    /**
     * @param seguro the seguro to set
     */
    public void setSeguro(Double seguro) {
        this.seguro = seguro;
    }

    /**
     * @return the impuestos
     */
    public Double getImpuestos() {
        return impuestos;
    }

    /**
     * @param impuestos the impuestos to set
     */
    public void setImpuestos(Double impuestos) {
        this.impuestos = impuestos;
    }

    /**
     * @return the comisiones
     */
    public Double getComisiones() {
        return comisiones;
    }

    /**
     * @param comisiones the comisiones to set
     */
    public void setComisiones(Double comisiones) {
        this.comisiones = comisiones;
    }
    /**
     * SE DEFINE LA TABLA Y SUS COLUMNAS
     */
    private String[][] tabla;
    private static final int UNIDADES =0;
    private static final int DESCRIPCION =1;
    private static final int VALOR=2;
    private static final int PESO=3;
    private static final int GASTO_VALOR =4;
    private static final int GASTO_PESO =5;
    private static final int COSTO_UNIDAD =6;
    private static final int COSTO_TOTAL=7;
    private static DecimalFormat df = new DecimalFormat("0.00");
    
    /**
     * SE DEFINEN LOS PARAMETROS DE LA TABLA
     */
    private int FILA_ACTUAL=0;
    private int TOTAL_FILAS=0;
    private final int MAX_FILAS=4;
    private final int MAX_COLUMNAS=8;
    
    /**
     * Variable relacionadas al precio 
     */
    private Double seguro;
    private Double impuestos;
    private Double comisiones;
    
    /**
     * Variables relacionadas al peso
     */
    private Double flete;
    private Double acarreo;
    
    public ClsProrrateo(int filas){
         if (filas > MAX_FILAS){
            throw (new IllegalArgumentException());
        } else {
            TOTAL_FILAS = filas;
            tabla = new String[TOTAL_FILAS][MAX_COLUMNAS];
        }
    }
    public String AgregarProducto(ClsProductos producto){
        if(FILA_ACTUAL>=MAX_FILAS){
            return "Ya llegaste al final";
        }else{
            tabla[FILA_ACTUAL][UNIDADES]=String.valueOf(producto.getUnidades());
            tabla[FILA_ACTUAL][DESCRIPCION]=String.valueOf(producto.getDescripcion());
            tabla[FILA_ACTUAL][VALOR]=String.valueOf(producto.getPrecio());
            tabla[FILA_ACTUAL][PESO]=String.valueOf(producto.getPeso());
            FILA_ACTUAL=FILA_ACTUAL+1;
        }
        return "Ok";
    }
    public void IngresarGastos(){
        Scanner t = new Scanner(System.in);
        System.out.println("Ingrese el pago del seguro local: 3500");
        setSeguro(3500.0);
        //setSeguro(Double.valueOf(t.nextLine()));
        System.out.println("Ingrese el pago de impuestos: 5000");
        setImpuestos(5000.0);
        //setImpuestos(Double.valueOf(t.nextLine()));
        System.out.println("Ingrese el pago de comisiones: 200");
        setComisiones(200.0);
        //setComisiones(Double.valueOf(t.nextLine()));
        System.out.println("Ingrese el pago de fletes: 2500");
        setFlete(2500.0);
        //setFlete(Double.valueOf(t.nextLine()));
        System.out.println("Ingrese el pago de acarreo: 5000");
        setAcarreo(5000.0);
        //setAcarreo(Double.valueOf(t.nextLine()));
    }
    public void AnalizarDatos(){
        Double total_valor=0.0;
        /**
         * PASO 1
         */
        for (String[] columna : tabla) {
            total_valor=total_valor+=Double.valueOf(columna[UNIDADES])*Double.valueOf(columna[VALOR]);
        }
        
        /**
         * PASO 2
         */
        Double total_gasto_valor=seguro+impuestos+comisiones;
        
        /**
         * PASO 3
         */
        Double coheficiente_gasto=total_gasto_valor/total_valor;
        
        /**
         * PASO 4 y 5
         */
        Double total_peso=0.0; //paso 5
        for (String[] columna : tabla) {
            columna[GASTO_VALOR]=String.valueOf(df.format(Double.valueOf(columna[VALOR])*coheficiente_gasto));
            total_peso=total_peso+(Double.valueOf(columna[UNIDADES])*Double.valueOf(columna[PESO]));
        }
        /**
         * PASO 6
         */
        Double gasto_peso = flete+acarreo;
        
        /**
         * PASO 7
         */
        Double coheficiente_gasto_peso=gasto_peso/total_peso;
        
        /**
         * PASO 8 y 9
         */
        for (String[] columna : tabla) {
            columna[GASTO_PESO]=String.valueOf(df.format(Double.valueOf(columna[PESO])*coheficiente_gasto_peso));
            columna[COSTO_UNIDAD]=String.valueOf(df.format(Double.valueOf(columna[VALOR])+Double.valueOf(columna[GASTO_VALOR])+Double.valueOf(columna[GASTO_PESO])));
            columna[COSTO_TOTAL]=String.valueOf(df.format(Double.valueOf(columna[COSTO_UNIDAD])*Double.valueOf(columna[UNIDADES])));
        }
        
        /**
         * PASO 10
         */
        Double gran_total=total_valor+total_gasto_valor+gasto_peso;
        System.out.println("Gran Total (Comprobación): "+gran_total);
    }
    public  void imprimirDecorado(){
        Double gran_total=0.0;
        for (String[] tabla1 : tabla) {
            gran_total=gran_total+Double.valueOf(tabla1[COSTO_TOTAL]);
            System.out.print("|");
            for (int y = 0; y < tabla1.length; y++) {
                System.out.print(tabla1[y]);
                if (y != tabla1.length - 1) {
                    System.out.print("\t");
                }
                
            }
            System.out.println("|");
        }
        System.out.println("Gran Total: "+gran_total);
   }
}
