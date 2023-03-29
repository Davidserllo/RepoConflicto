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

import java.util.Locale;
import java.util.Scanner;

/**
 *
 * @author Pedro David Serrano Llorca - davserllo@gmail.com
 */
public final class UtilesCalculos {

    // Scanner - Separacion de decimanl por (.)
    public static final Scanner SCN
            = new Scanner(System.in, "Windows-1252")
                    .useLocale(Locale.ENGLISH).useDelimiter("\\s+");

    // Lotería Primitiva
    public static final int PRIM_MIN = 1;
    public static final int PRIM_MAX = 49;

    // Tipos IVA
    public static final int IVA_MIN = 4;
    public static final int IVA_MED = 10;
    public static final int IVA_MAX = 21;

    private UtilesCalculos() {
    }

    // Validar paridad
    public static final boolean validarParidad(int n) {
        return n % 2 == 0;
    }

    // Validar positivo
    public static final boolean validarPositivo(int n) {
        return n >= 0;
    }

    // Validar primitiva - Entre 1 y 49
    public static final boolean validarNumeroPrimitiva(int n) {
        return n >= PRIM_MIN && n <= PRIM_MAX;
    }

    // Validar IVA
    public static final boolean validarTipoIVA(int iva) {
        return iva == IVA_MIN || iva == IVA_MED || iva == IVA_MAX;
    }

    public static int calcularCuadrado(int n) {
        int cuadrado = n * n;
        return cuadrado;
    }

    public static final int leerEntero(String msgUsr, String msgErr) {

        int num = 0;
        boolean lecturaOK = false;
        do {
            try {
                // Entrada de numero
                System.out.print(msgUsr);
                num = SCN.nextInt();

                // Validacion
                lecturaOK = true;
            } catch (Exception e) {
                System.out.print(msgErr);
            } finally {
                SCN.nextLine();
            }
        } while (!lecturaOK);
        return num;
    }

}
