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

/**
 *
 * @author Pedro David Serrano Llorca - davserllo@gmail.com.
 */

public final class UtilesFecha {

    private UtilesFecha() {
    }
    
    // Año > Estado Bisiesto; SI | NO
    public static final boolean validarBisiesto(int any) {
        return any % 400 == 0 || any % 100 !=0 && any % 4 == 0;
    }

    
//        public static final boolean validarMes(int any) {
//    int diam = calcularDiasMes(mes, any);
//    // Semaforo
//    boolean diaOk = true;
//
//    // Discriminación
//    if (mes < 1 || mes > 12) {
//        boolean diaOK = false;
//    } else {
//        // Situación nominal
//        boolean diaOK = dia >= 1 && dia <= diam;
//    }
//
//    // Retorno
//    return diaOk;
//}
    
    
    public static final boolean validarDia(int dia, int mes, int any) {
    int diam = calcularDiasMes(mes, any);
    // Semaforo
    boolean diaOk = true;

    // Discriminación
    if (mes < 1 || mes > 12) {
        boolean diaOK = false;
    } else {
        // Situación nominal
        boolean diaOK = dia >= 1 && dia <= diam;
    }

    // Retorno
    return diaOk;
}
      
    
    // mes + año > Dias que tiene el mes.
    public static final int calcularDiasMes(int mes, int any) {
        // Dias
        int dias;

        
        // Discriminación
        if (mes == 1 || mes == 3 || mes == 5 || mes == 7 || mes == 8 || mes == 10 || mes == 12) {
            dias = 31;
        } else if (mes == 4 || mes == 6 || mes == 9 || mes == 11) {
            dias = 30;
        } else if (mes == 2 && (any % 400 == 0 || any % 100 != 0 && any % 4 == 0)) {
            dias = 29;
        } else if (mes == 2) {
            dias = 28;
        } else {
            dias = 0;
        }

        // Retorno
        return dias;
    }
    
    
        // Dos fechas: Mismo mes > Dias (Incluye Dia Inicial)
    public static final int calcularDiasFechasMes(int diaIni, int diaFin, int mes, int any) {
        // Dias
        int dias = 0;

        // Discriminación
        if (!validarDia(dias, mes, any)) {
            // Situacion error
            dias = 0;
        } else if (!validarDia(dias, mes, any)) {
            // Situación error
            dias = 0;
        } else if (diaFin <= diaIni) {
            // Situación error
            dias = 0;
        }  else {
            // Situación nominal
            dias = diaFin - diaIni;
        }

        // Retorno
        return dias;
    }
    
    
//    public static final int calcularDiasEntreMes(int diaIni, int diaFin) {
//        // Dias entre meses calculados.
//        return diaFin - diaIni;
//    }
        
    
    public static final int calcularDiasRestantesMes(int dia, int mes, int any) {
        
        // Acumulador
        int dias;
        
        // Discriminación
        if (!validarDia(dia, mes, any)) {
            dias = 0;
        } else if (mes < 1 || mes > 12){
           dias = 0;
        } else {
            dias = calcularDiasMes(mes, any) - dia;
        }
     return dias;
    }
       

    public static final int calcularDiasEntreFechasMesesAbyacentes(int diaIni, int diaFin, int mes, int any) {
        int dia = 0;
        dia = calcularDiasRestantesMes(dia, mes, any);
        int dias = 0;
        
        // Discriminación
        if (!validarDia(dias, mes, any)) {
            dias = 0;
        } else if (!validarDia(dias, mes, any)) {
            dias = 0;
        } else if (mes < 1 || mes > 12) {
            dias = 0;
        }  else {
            // Situación nominal
            dias = dia + diaFin;
        }
     return dias;
    }
    
    
    
    public static final int calcularDiasEntreMesesAny(int mesIni, int mesFin, int any) {
        int dia = calcularDiasMes(any, any);
        int dias = 0;

        // Discriminación
        if (mesIni < 1 || mesIni > 12) {
            dias = 0;
        } else if (mesFin < 1 || mesFin > 12) {
            dias = 0;
        } else if (mesFin - mesIni < 2) {
            dias = 0;
        }  else {
            // 
            for (int mes = mesIni; mes <= mesFin; mes++){
             dias = dia + dias;   
            }

        }
     return dias;
    }
    
//    public static final int calcular(int dia, int mes, int any) {
//        int diam = calcularDiasMes(mes, any);
//        // Semaforo
//        boolean diaOk = true;
//    
//        // Discriminación
//        if (mes < 1 || mes > 12) {
//            boolean diaOK = false;
//        } else {
//            // Situación nominal
//            boolean diaOK = dia >= 1 && dia <= diam;
//        }
//    
//        // Retorno
//        return diaOk;
//}
    
    public static final int calcularDiasMesesAbyacentes(int diaIni, int diaFin, int mes, int any) {
        int dias = calcularDiasRestantesMes(diaIni, mes, any);
        // Dias entre meses abyacentes calculados.
        return dias + diaFin;
    }

    
    public static final int calcularDiasMesesCompletosAny(int mesIni, int mesFin, int any) {
        int dias = 0;
        for (int mes = mesIni; mes <= mesFin; mes++) {
            dias = dias + calcularDiasMes(mes, any);
        }
        return dias;   
    }
    
    
    public static final int calcularDiasMesesAny(int diaIni, int diaFin, int mesIni, int mesFin, int any) {
        int dias = calcularDiasRestantesMes(diaIni, mesIni, any) ;
        if (mesFin > mesIni + 1) {
            dias = dias + calcularDiasMesesCompletosAny(mesIni, mesIni -1, any);
        }
        dias = dias + diaFin;
        return dias;
    }
    
    
    public static final int calcularDiasRestantesAny(int dia, int mes, int any) {
        // return calcularDiasMesesAny(dia, 31, mes, 12, any);
        int dias = calcularDiasMesesAny(dia, 31, mes, 12, any);
        // 
        return dias;
    }
    
    
    public static final int calcularDiasLlegadosAny(int dia, int mes, int any) {
        // return calcularDiasMesesAny(1, dia, 1, mes, any);
        int dias = calcularDiasMesesAny(0, dia, 1, mes, any);
        // 
        return dias;
    }
    
    
    public static final int calcularDiasFechasAnyAbyacentes(int diaIni, int diaFin, int mesIni, int mesFin, int any) {
        // return calcularDiasRestantesAny(diaIni, mesIni, any) + calcularDiasRestantesAny(diaFin, mesFin, any + 1);
        int diasIni = calcularDiasRestantesAny(diaIni, mesIni, any);
        int diasFin = calcularDiasRestantesAny(diaFin, mesFin, any + 1);
        // 
        return diasIni + diasFin;
    }

    
//    public static final int calcularDiasEntreFechasAny(int diaIni, int diaFin, int mesIni, int mesFin, int any) {
//        // Dias
//        int dias = 0;
//
//        // Discriminación
//        if (mesIni == mesFin) {
//            dias = calcularDiasFechasMes(diaIni, mesIni, anyIni);
//        } else {
//            
//            int diasIni = calcularDiasRestantesAny(dias, dias, any);
//            int diasMed = calcularDiasEntreAnys(anyIni, anyIni);
//            int diasFin = calcularDiasFechasMes(diaIni, mesIni, anyIni, anyIni);
//            int dias = diasIni + diasMed + diasFin;
//       }
//         // Retorno
//        return dias;
//    }
    
//    public static final int calcularAnyCompletos(int anyIni, int anyFin) {
//        int anyIni;
//        int anyFin;
//        // 
//        return diasIni + diasFin;
//    }
//
//        public static final int calcularDiasMesesCompletosAny(int mesIni, int mesFin, int any) {
//        int dias = 0;
//        for (int mes = mesIni; mes <= mesFin; mes++) {
//            dias = dias + calcularDiasMes(mes, any);
//        }
//        return dias;   
//    }
//    
//    
//    public static final int calcularAnyAbyacentes(int diaIni, int diaFin, int mesIni, int mesFin, int any) {
//        // 
//        int diasIni = calcularDiasRestantesAny(diaIni, mesIni, any);
//        int diasFin = calcularDiasRestantesAny(diaFin, mesFin, any + 1);
//        // 
//        return diasIni + diasFin;
//    }
    
}