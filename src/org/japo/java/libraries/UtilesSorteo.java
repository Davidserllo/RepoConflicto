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
public class UtilesSorteo {

    // Constantes longitud
    public static final int LONGITUD_BOMBO_PRIMITIVA = 49;
    public static final int LONGITUD_APUESTA_PRIMITIVA = 6;

    
    private UtilesSorteo() {
    }

    public static final int[] generarApuestaPrimitiva() {
        int[] apuesta = new int[LONGITUD_APUESTA_PRIMITIVA];
        int[] bombo = generarBomboPrimitiva();
        
        for (int i = 0; i < apuesta.length; i++) {
            int posicion = UtilesAleatorio.obtenerAleatorioEntero(0, LONGITUD_BOMBO_PRIMITIVA - 1 - i);
            apuesta[i] = bombo[posicion];
            bombo[posicion] = bombo[LONGITUD_BOMBO_PRIMITIVA - 1 - i];
        }
        
        return apuesta;
    } 
    
    private static int[] generarBomboPrimitiva() {
        int[] bombo = new int[LONGITUD_BOMBO_PRIMITIVA];
        
        for (int i = 0; i < bombo.length; i++) {
            bombo[i] = i + 1;
        }
        
        return bombo;
    }

}
