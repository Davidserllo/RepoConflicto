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

/**
 *
 * @author Pedro David Serrano Llorca - davserllo@gmail.com
 */
public class UtilesPassword {

    // Caracteres
    public static final int NUM_CAT = 4;    // Número de Categorias
    public static final int CAT_MIN = 0;    // Categoría Minúsculas
    public static final int CAT_MAY = 1;    // Categoría Mayúsculas
    public static final int CAT_NUM = 2;    // Categoría Dígitos
    public static final int CAT_CAR = 3;    // Categoría Caracter
    public static final int CAT_PUN = 3;    // Categoría Signos Puntuación

    // Caracteres
    public static final String MIN = "abcdefghijklmnñopqrstuvwxyz";
    public static final String MAY = "ABCDEFGHIJKLMNÑOPQRSTUVWXYZ";
    public static final String NUM = "0123456789";
    public static final String CAR = "@#~$%&()[]{}=?¿¡!+-*/;:";

    // Caracteres en Array
    public static final char[] CAR_MIN = {'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'ñ', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z'};
    public static final char[] CAR_MAY = {'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'Ñ', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z'};
    public static final char[] CAR_NUM = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9'};
    public static final char[] CAR_PUN = {'|', '@', '#', '~', '$', '%', '&', '(', ')', '[', ']', '{', '}', '=', '?', '¿', '¡', '!', '+', '-', '*', '/', ';', ':'};

//    // Caracteres en String para convertir en un Array de char
//    public static final String CAR_MIN_STR = "abcdefghijklmnñopqrstuvwxyz";
//    public static final String CAR_MAY_STR = "ABCDEFGHIJKLMNÑOPQRSTUVWXYZ";
//    public static final String CAR_NUM_STR = "0123456789";
//    public static final String CAR_PUN_STR = "|@#~$%&()[]{}=?¿¡!+-*/;:";
//    
//    // Conversion de String a Array char
//    public static final char[] CAR_MIN = CAR_MIN_STR.toCharArray();
//    public static final char[] CAR_MAY = CAR_MAY_STR.toCharArray();
//    public static final char[] CAR_NUM = CAR_NUM_STR.toCharArray();
//    public static final char[] CAR_PUN = CAR_PUN_STR.toCharArray();
    // Longitud Contraseña
    public static final int LONG_MIN = 4;
    public static final int LONG_MAX = 24;

    // Longitud de la contraseña. (La definiremos al utilizar en el App.java)
    //    public static final int LONG_PASS = 12;
    private UtilesPassword() {
    }

    public static final String generarPassword() {
        return generarPassword(LONG_MIN, LONG_MAX);
    }

    // Obtencion de una letras (MIN) del abecedario en minuscula de forma aleatoria.
    public static final char obtenerMin() {
        return MIN.charAt(UtilesAleatorio.obtenerAleatorioEntero(0, MIN.length() - 1));
    }

    // Obtencion de una letras (MAY) del abecedario en mayusculas de forma aleatoria.
    public static final char obtenerMay() {
        return MAY.charAt(UtilesAleatorio.obtenerAleatorioEntero(0, MAY.length() - 1));
    }

    // Obtencion de un numero (NUM) de forma aleatoria.
    public static final char obtenerNum() {
        return NUM.charAt(UtilesAleatorio.obtenerAleatorioEntero(0, NUM.length() - 1));
    }

    // Obtencion de un caracter (CAR) de forma aleatoria.
    public static final char obtenerCar() {
        return CAR.charAt(UtilesAleatorio.obtenerAleatorioEntero(0, CAR.length() - 1));
    }

    // Intercambio de caracteres
    public static final String intercambiar(String s, int ini, int fin) {
        // Obtener carecteres
        char carIni = s.charAt(ini);
        char carFin = s.charAt(fin);

        // Remplazo Caracter Inicial
        String strIni = s.substring(0, fin);
        String strFin = s.substring(fin + 1);
        String aux = strIni + carIni + strFin;

        // Remplazo Caracter Final
        strIni = aux.substring(0, ini);
        strFin = aux.substring(ini + 1);

        // Retorno
        String valor = strIni + carFin + strFin;
        return valor;
    }

    public static final String Aleatorizar(String s) {
        String aux = s;
        for (int i = 0; i < aux.length(); i++) {
            int f = UtilesAleatorio.obtenerAleatorioEntero(0, aux.length() - 1);
            aux = intercambiar(aux, i, f);
        }
        return aux;
    }

    // Generación de la contraseña
    public static final String generarPassword(int min, int max) {
        // Acumulador
        String pass = "";

        if (min >= 4 && max >= min) {

            //Predeterminados
            pass += obtenerMin();
            pass += obtenerMay();
            pass += obtenerNum();
            pass += obtenerCar();

            // Longitud Aleatoria
            int lonRnd = UtilesAleatorio.obtenerAleatorioEntero(min, max);

            // Resto de caracteres
            for (int i = 4; i < lonRnd - 1; i++) {
                int cat = UtilesAleatorio.obtenerAleatorioEntero(0, 3);

                switch (cat) {
                    case CAT_MIN:
                        pass += obtenerMin();
                        break;
                    case CAT_MAY:
                        pass += obtenerMay();
                        break;
                    case CAT_NUM:
                        pass += obtenerNum();
                        break;
                    case CAT_CAR:
                        pass += obtenerCar();
                }
            }

            // Aleatorizar
            pass = Aleatorizar(pass);
        }
        // Retorno
        return pass;
    }

    public static final void generarPassword(char[] pass) {

        //Inicializacion Categoria
        pass[0] = generarCaracter(CAR_MIN);
        pass[1] = generarCaracter(CAR_MAY);
        pass[2] = generarCaracter(CAR_NUM);
        pass[3] = generarCaracter(CAR_PUN);

        // Resto de Caracteres
        for (int i = NUM_CAT; i < pass.length; i++) {
            pass[i] = generarCaracter();
        }

        // Desordenar Array
        desordenar(pass);
    }

    public static final char generarCaracter(char[] lista) {
        return lista[UtilesAleatorio.obtenerAleatorioEntero(0, lista.length - 1)];
    }

    public static final char generarCaracter() {
        // Categoria Aleatoria
        int cat = UtilesAleatorio.obtenerAleatorioEntero(0, 3);

        // Caracter Generado
        char car = 0;
        switch (cat) {
            case CAT_MIN:
                car = generarCaracter(CAR_MIN);
                break;
            case CAT_MAY:
                car = generarCaracter(CAR_MAY);
                break;
            case CAT_NUM:
                car = generarCaracter(CAR_NUM);
                break;
            case CAT_PUN:
                car = generarCaracter(CAR_PUN);
                break;
        }
        return car;
    }

    public static final void desordenar(char[] pass) {
        for (int i = 0; i < pass.length; i++) {
            // Posicion destino Aleatoria
            int pos = UtilesAleatorio.obtenerAleatorioEntero(0, pass.length - 1);

            // Intercambio
            char aux = pass[pos];
            pass[pos] = pass[i];
            pass[i] = aux;
        }
    }

    public static final String obtenerTexto(char[] lista) {
        StringBuilder buffer = new StringBuilder();
        for (char c : lista) {
            buffer.append(c);
        }
        
        return buffer.toString();
    }
    
//  Metodo similar al de arriba -99% menos eficiente en relacion a optencion de codigo largo.
//    public static final String obtenerTexto(char[] lista) {
//        String buffer = "";
//        for (char c : lista) {
//            buffer += c;
//        }
//
//        return buffer;
//    }

}
