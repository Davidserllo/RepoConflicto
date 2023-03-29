/*
 * Copyright 2022 Pedro David Serrano Llorca - davserllo@gmail.com.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.japo.java.libraries;

import java.util.Random;

/**
 *
 * @author Pedro David Serrano Llorca - davserllo@gmail.com.
 */
public final class UtilesOperacion {
    
    // Iniciar Sistema Aleatorio
    public static final Random RND = new Random();
    
    // Operaciones
    public static final int OP_SUM = 0; // Suma
    public static final int OP_RES = 1; // Resta
    public static final int OP_MUL = 2; // Producto
    public static final int OP_DIV = 3; // Cociente
    public static final int OP_MOD = 4; // Resto
    public static final int OP_MED = 5; // Media
    public static final int OP_MAY = 6; // Mayor
    public static final int OP_MEN = 7; // Menor
    
    private UtilesOperacion() {
    }
    
    public static final double operar(double n1, double n2, int op) {
        double n;
        
        switch (op) {
            case OP_SUM:
                n = calcularSuma(n1, n2);
                break;
            case OP_RES:
                n = calcularResta(n1, n2);
                break;
            case OP_MUL:
                n = calcularmultiplicacion(n1, n2);
                break;
            case OP_DIV:
                n = calcularDivision(n1, n2);
                break;
            case OP_MOD:
                n = calcularResto(n1, n2);
                break;
            case OP_MED:
                n = calcularMedia(n1, n2);
                break;
            case OP_MAY:
                n = calcularMayor(n1, n2);
                break;
            case OP_MEN:
                n = calcularMenor(n1, n2);
                break;
            default:
                n = 0;
        }
        
        return n;
    }
    
    private static double calcularSuma(double n1, double n2) {
//        return n1 + n2;
        double op = n1 + n2;
        return op;
    }

    private static double calcularResta(double n1, double n2) {
//        return n1 - n2;
        double op = n1 - n2;
        return op;
    }

    private static double calcularmultiplicacion(double n1, double n2) {
//        return n1 * n2;
        double op = n1 * n2;
        return op;
    }

    private static double calcularDivision(double n1, double n2) {
//        return n1 / n2;
        double op = n1 / n2;
        return op;
    }
    
    private static double calcularResto(double n1, double n2) {
//        return n1 % n2;
        double op = n1 % n2;
        return op;
    }

    private static double calcularMedia(double n1, double n2) {
//        return (n1 + n2) / 2;
        double op = (n1 + n2) / 2;
        return op;
    }

    private static double calcularMayor(double n1, double n2) {
        double op = 0;
        
        if (n1 >= n2) {
            op = n1;
        } else if (n1 <= n2) {
            op = n2;
        }
        return op;
    }    

    private static double calcularMenor(double n1, double n2) {
        double op = 0;
        
        if (n1 <= n2) {
            op = n1;
        } else if (n1 <= n2) {
            op = n2;
        }
        return op;
    }
    
    public static final double aleatorio(int n1min, int n2max) {
        
        int numaleatorios = RND.nextInt(n2max - n1min + 1) + n1min;
        return numaleatorios;
    }

}
