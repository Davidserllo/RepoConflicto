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
public final class UtilesNombres {

    public static final String[] NOMBRES = {
        "Manolo", "Puri", "Abel", "María",
        "Eustaquio", "Engracia", "Pako", "Ainhoa",
        "Sócrates", "Pancracia", "Nícola", "Nikita"
    };

    public static final void listarArrayNombresAleatorios(
            String[] lista, String msg) {
        for (int i = 0; i < lista.length; i++) {
            System.out.printf(msg, i + 1, lista[i]);
        }
    }

    public static int buscar(String nombre, String[] lista) {
        int posicion = -1;
        try {
            boolean seekOK = true;
            int i = 0;
            do {                
                if (i >= lista.length) {
                    seekOK = false;
                } else if (lista[i].equals(nombre)){
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

    private UtilesNombres() {
    }

    public static final String obtenerNombreAleatorio() {
        return NOMBRES[new Random().nextInt(NOMBRES.length)];
    }

    public static final String[] obtenerArrayNombresAleatorios(int longitud) {
        String[] nombre = new String[longitud];

        for (int i = 0; i < nombre.length; i++) {
            nombre[i] = obtenerNombreAleatorio();
        }

        return nombre;
    }

}
