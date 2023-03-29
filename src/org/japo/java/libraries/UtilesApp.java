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

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.Properties;

/**
 *
 * @author Pedro David Serrano Llorca - davserllo@gmail.com
 */
public class UtilesApp {

    // Valores por defecto
    public static final String DEF_FICHERO_PRP = "app.properties";
    public static final String DEF_FICHERO_XML = "app.xml";

    private UtilesApp() {
    }

    // Fichero Propiedades > Objeto Propiedades Predeterminado
    public static final Properties importarPropiedades(String fichero) {
        // Objeto Properties Vacio
        Properties prp = new Properties();

        // Presistencia > Propiedades
        try ( FileReader fr = new FileReader(fichero)) {
            prp.load(fr);
        } catch (Exception e) {
            System.out.println("ERROR: Imposible Acceder a " + fichero);
        }

        // Retorno
        return prp;
    }

    // Fichero Propiedades > Objeto Propiedades Predeterminado
    public static final Properties importarPropiedadesXML(String fichero) {
        // Objeto Properties Vacio
        Properties prp = new Properties();

        // Presistencia > Propiedades
        try (FileInputStream fis = new FileInputStream(fichero)) {
            prp.loadFromXML(fis);
        } catch (Exception e) {
            System.out.println("ERROR: Imposible Acceder a " + fichero);
        }

        // Retorno
        return prp;
    }

    // Fichero Propiedades > Objeto Propiedades Predeterminado
    public static final Properties importarPropiedades() {
        return importarPropiedades(DEF_FICHERO_PRP);
    }

    // Fichero Propiedades > Objeto Propiedades Predeterminado
    public static final Properties importarPropiedadesXML() {
        return importarPropiedades(DEF_FICHERO_XML);
    }

    public static final boolean exportarPropiedades(Properties prp, String fichero) {
        // Semaforo de estado
        boolean estadoOK = false;

        // Salvaguarda de propiedades
        try ( FileWriter fw = new FileWriter(fichero)) {
            // ProProperties > Presistencia
            prp.store(fw, null);

            // Proceso OK
            estadoOK = true;
        } catch (Exception e) {
            System.out.println("ERROR: Imposible Acceder a " + fichero);
        }

        // Retorno
        return estadoOK;
    }

    public static final boolean exportarPropiedadesXML(Properties prp, String fichero) {
        // Semaforo de estado
        boolean estadoOK = false;

        // Salvaguarda de propiedades
        try ( FileOutputStream fos = new FileOutputStream(fichero)) {
            // ProProperties > Presistencia
            prp.storeToXML(fos, null);

            // Proceso OK
            estadoOK = true;
        } catch (Exception e) {
            System.out.println("ERROR: Imposible Acceder a " + fichero);
        }

        // Retorno
        return estadoOK;
    }

    public static final boolean exportarPropiedades(Properties prp) {
        return exportarPropiedades(prp, DEF_FICHERO_PRP);
    }

    public static final boolean exportarPropiedadesXML(Properties prp) {
        return exportarPropiedadesXML(prp, DEF_FICHERO_XML);
    }

}
