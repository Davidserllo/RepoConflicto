/*
 * Copyright 2022 Pedro David Serrano Llorca - davserllo@gmail.com
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
 * @author Pedro David Serrano Llorca - davserllo@gmail.com
 */
public class UtilesPrimitivos {

    public static final int RANGE_IN = 0;    // Dentro de Rango
    public static final int RANGE_BELOW = 1; // Debajo de Rango
    public static final int RANGE_ABOVE = 2; // Encima de Rango

    private UtilesPrimitivos() {
    }

    public static final double calcularMedia(double n1, double n2) {

        double media = (n1 + n2) / 2;

        return media;
    }

//    public static final int analizarRango(double num, double min, double max) {
//                char chr = 0;
//        boolean rangoOK;
//        do {
//            chr = leerCaracter(msg);
//            rangoOK = chr >= min && chr <= max;
//            if (!rangoOK) {
//                System.out.println("ERROR: Caracter fuera de rango");
//                System.out.println("---");
//            }
//        } while (!rangoOK);
//
//        return chr;
//    }
}
