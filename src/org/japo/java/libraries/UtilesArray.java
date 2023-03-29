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

import java.util.Locale;

/**
 *
 * @author Pedro David Serrano Llorca - davserllo@gmail.com
 */
public final class UtilesArray {

    private UtilesArray() {
    }

    public static final double[] generarArrayRealAleatorio(int longitud) {
        double[] lista = new double[longitud];

        for (int i = 0; i < lista.length; i++) {
            lista[i] = UtilesAleatorio.obtenerAleatorioReal(0, 1);
        }

        return lista;
    }

    public static final void listarArray(double[] lista, String msg) {
        for (int i = 0; i < lista.length; i++) {
            System.out.printf(Locale.ENGLISH, msg, i + 1, lista[i]);
        }
    }

    public static final double acumular(double[] lista) {
        double suma = 0;

        for (int i = 0; i < lista.length; i++) {
            suma += lista[i];
        }

        return suma;
    }

    public static final int buscarMaximo(double[] lista) {
        int posicion = 0;

        for (int i = 1; i < lista.length; i++) {
            if (lista[i] > lista[posicion]) {
                posicion = i;
            }
        }

        return posicion;
    }

    public static final int buscar(int valor, int[] lista) {
        int posicion = -1;
        try {
            boolean seekOK = true;
            int i = 0;
            do {
                if (i >= lista.length) {
                    seekOK = false;
                } else if (lista[i] == valor) {
                    seekOK = false;
                    posicion = i;
                } else {
                    i++;
                }
            } while (seekOK);
        } catch (Exception e) {
            System.out.println("ERROR: Búsqueda cancelada");
        }
        return posicion;
    }

    public static final void ordenarBurbuja(int[] lista) {
        int i, j, aux;
        for (i = 0; i < lista.length - 1; i++) {
            for (j = 0; j < lista.length - i - 1; j++) {
                if (lista[j + 1] < lista[j]) {
                    aux = lista[j + 1];
                    lista[j + 1] = lista[j];
                    lista[j] = aux;
                }
            }
        }
    }

    public static final void ordenarBaraja(int[] lista) {
        int n = lista.length;
        for (int i = 1; i <= n - 1; i++) {
            int aux = lista[i];
            int j = i - 1;
            while (j >= 0 && aux < lista[j]) {
                lista[j + 1] = lista[j];
                j = j - 1;
            }
            lista[j + 1] = aux;
        }
    }

//    public static void ordenarSeleccion(int[] lista) {
//        int n = lista.length;
//        int posmin;
//        for (int i = 0; i < n - 1; i++) {
//            posmin = i;
//            for (int j = i + 1; j < n; j++) {
//                if (lista[j] < lista[posmin]) {
//                    posmin = j;
//                }
//            }
//            permuta(lista, i, posmin);
//        }
//    }

}
