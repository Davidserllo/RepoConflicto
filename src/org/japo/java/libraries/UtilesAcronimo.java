/*
 * Copyright 2023 Pedro David Serrano Llorca
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

/**
 *
 * @author Pedro David Serrano Llorca
 */
public final class UtilesAcronimo {

    private UtilesAcronimo() {
    }
 
//        String s = "pedro david serrano llorca";
//        String a = obtenerAcronimoDirecto(s);
//        String b = obtenerAcronimoInverso(s);
//        System.out.println("Nombre .......: " + s);
//        System.out.println("Acronimo INI ...: " + a);
//        System.out.println("Acronimo FIN ...: " + b);  
    
   // Introduciremos un nombre y los apellidos, nos devolvera las inicales.
   private static final String obtenerAcronimoDirecto(String s) {

        String resto = s;
        String a = s.charAt(0) + "";
        int posicion;
       do {
           posicion = resto.indexOf(" ");
            if (posicion >= 0) {
                resto = resto.substring(posicion + 1);
                a = a + resto.charAt(0);
           }
        } while (posicion >= 0);
    return a.toUpperCase();
    }

    // Introduciremos un nombre y los apellidos, nos devolvera las inicales empezando desde el final.
    private static final String obtenerAcronimoInverso(String s) {

        String resto = s;
        String a = resto.charAt(resto.length() - 1) + "";
        int posicion;
        do {
            posicion = resto.lastIndexOf(" ");
            if (posicion >= 0) {
                resto = resto.substring(0, posicion);
                a = resto.charAt(resto.length() - 1) + a;
        }
        } while (posicion >= 0);
    return a.toUpperCase();
    }
    
}
