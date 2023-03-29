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

import java.util.Locale;
import java.util.Scanner;

/**
 *
 * @author Pedro David Serrano Llorca - davserllo@gmail.com.
 */
public final class UtilesEntrada {

    // Scanner - Separacion de decimanl por (.)
    public static final Scanner SCN
            = new Scanner(System.in, "Windows-1252")
                    .useLocale(Locale.ENGLISH).useDelimiter("\\s+");
    
    private UtilesEntrada() {
    }
    
    public static final int leerEntero(String msg) {
        int num = 0;
        boolean introOK = false;
        do {
            try {
                System.out.print(msg);
                num = SCN.nextInt();
                introOK = true;
            } catch (Exception e) {
                System.out.println("---");
                System.out.println("ERROR: Entrada incorrecta");
            } finally {
                System.out.println("---");
                SCN.nextLine();
            }
        } while (!introOK);
        return num;
    }
    
    public static final int leerEnteroRango(String msg, int min, int max) {
        int num;
        boolean rangoOK;
        do {
            num = leerEntero(msg);
            rangoOK = num >= min && num <= max;
            if (!rangoOK) {
                System.out.println("ERROR: Número fuera de rango");
                System.out.println("---");
            }
        } while (!rangoOK);

        return num;
    }
    
    public static final char leerCaracter(String msg) {
        char chr = 0;
        boolean introOK = false;
        do {
            try {
                System.out.print(msg);
                chr = SCN.nextLine().charAt(0);
                System.out.println("---");
                introOK = true;
            } catch (Exception e) {
                System.out.println("---");
                System.out.println("ERROR: Entrada incorrecta");
                System.out.println("---");
            }
        } while (!introOK);
        return chr;
    }
    
    public static final int leerCaracterRango(String msg, char min, char max) {
        char chr = 0;
        boolean rangoOK;
        do {
            chr = leerCaracter(msg);
            rangoOK = chr >= min && chr <= max;
            if (!rangoOK) {
                System.out.println("ERROR: Caracter fuera de rango");
                System.out.println("---");
            }
        } while (!rangoOK);

        return chr;
    }
    
    public static final double obtenerNumero(String msgUsr, String msgErr) {

        double num = 0.00;
        boolean lecturaOK = false;
        do {
            try {
                // Entrada de numero
                System.out.print(msgUsr);
                num = SCN.nextDouble();

                // Validacion
                lecturaOK = true;
            } catch (Exception e) {
                System.out.println(msgErr);
                System.out.println("---");
            } finally {
                SCN.nextLine();
            }
        } while (!lecturaOK);
        return num;
    }
    
}
