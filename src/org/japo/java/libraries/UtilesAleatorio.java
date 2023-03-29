/*
 * Copyright 2023 Pedro David Serrano Llorca - davserllo@gmail.com
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
 * @author Pedro David Serrano Llorca - davserllo@gmail.com
 */
public class UtilesAleatorio {

    // Iniciar Sistema Aleatorio
    public static final Random RND = new Random();

    private UtilesAleatorio() {
    }

    // Generacion de un numero (int) aleatorio.
    public static final int obtenerAleatorioEntero(int MIN, int MAX) {
        return RND.nextInt(MAX - MIN + 1) + MIN;
    }

    // Generacion de un numero (double) aleatorio.
    public static final double obtenerAleatorioReal(double MIN, double MAX) {
        return RND.nextDouble() * (MAX - MIN) + MIN;
    }

    // Generacion de un numero (boolean) aleatorio.
    public static final boolean obtenerAleatorioLogico(boolean MIN, boolean MAX) {
        return RND.nextBoolean();
    }

    // Generacion de un numero (Caracter) aleatorio.
    public static final char obtenerAleatorioCaracter(char CAR_MIN, char CAR_MAX) {
        return (char) (RND.nextInt(CAR_MAX - CAR_MIN + 1) + CAR_MIN);
    }

}
